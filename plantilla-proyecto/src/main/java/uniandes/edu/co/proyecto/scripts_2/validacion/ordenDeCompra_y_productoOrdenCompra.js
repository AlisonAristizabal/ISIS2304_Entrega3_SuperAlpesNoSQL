// Crear la colección "orden_de_compra" con esquema de validación
db.createCollection("orden_de_compra", {
  validator: {
    $jsonSchema: {
      bsonType: "object",
      required: [
        "fecha_esperada_entrega",
        "estado",
        "id_sucursal",
        "id_proveedor",
        "productos_orden_compra",
      ],
      properties: {
        fecha_esperada_entrega: {
          bsonType: "date", // Fecha en formato ISODate
          description: "Fecha esperada de entrega de la orden",
        },
        estado: {
          bsonType: "string",
          enum: ["Pendiente", "En Proceso", "Entregado"], // Validación de valores permitidos
          description: "Estado de la orden de compra",
        },
        id_sucursal: {
          bsonType: "objectId", // Referencia al _id de una sucursal
          description: "Referencia a la sucursal que genera la orden",
        },
        id_proveedor: {
          bsonType: "objectId", // Referencia al _id de un proveedor
          description: "Referencia al proveedor al que se realiza la orden",
        },
        productos_orden_compra: {
          bsonType: "array", // Lista de productos en la orden
          items: {
            bsonType: "object",
            required: ["cantidad", "precio", "id_producto"],
            properties: {
              cantidad: {
                bsonType: "number", // Validar que la cantidad sea un número
                description: "Cantidad solicitada del producto",
              },
              precio: {
                bsonType: "number", // Validar que el precio sea un número
                description: "Precio unitario del producto en la orden",
              },
              id_producto: {
                bsonType: "objectId", // Referencia al _id de un producto
                description: "Referencia al producto incluido en la orden",
              },
            },
          },
          description: "Lista de productos solicitados en la orden",
        },
      },
    },
  },
});
