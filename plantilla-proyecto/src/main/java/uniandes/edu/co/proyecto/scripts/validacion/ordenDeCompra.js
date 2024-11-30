db.createCollection("orden_de_compra", {
  validator: {
    $jsonSchema: {
      bsonType: "object",
      required: [
        "id",
        "fecha_esperada_entrega",
        "estado",
        "id_sucursal",
        "id_proveedor",
        "productosOrdenCompra",
      ],
      properties: {
        id: {
          bsonType: "int",
          description:
            "Debe ser un número entero único que identifica la orden de compra",
        },
        fecha_esperada_entrega: {
          bsonType: "date",
          description: "Fecha esperada de entrega en formato ISODate",
        },
        estado: {
          bsonType: "string",
          description:
            "Estado de la orden de compra (ej. 'pendiente', 'completada')",
        },
        id_sucursal: {
          bsonType: "int",
          description: "ID de la sucursal que realizó la orden de compra",
        },
        id_proveedor: {
          bsonType: "int",
          description: "ID del proveedor al que se realizó la orden de compra",
        },
        productosOrdenCompra: {
          bsonType: "array",
          items: {
            bsonType: "object",
            required: ["cantidad", "precio", "id_producto"],
            properties: {
              cantidad: {
                bsonType: "int",
                description:
                  "Cantidad de productos solicitados en la orden de compra",
              },
              precio: {
                bsonType: "int",
                description: "Precio de cada unidad del producto",
              },
              id_producto: {
                bsonType: "int",
                description: "ID del producto que se ordenó",
              },
            },
            description: "Producto ordenado con su cantidad y precio",
          },
          description: "Lista de productos en la orden de compra",
        },
      },
    },
  },
  validationAction: "warn", // Se puede cambiar a "error" para bloquear documentos inválidos
});
