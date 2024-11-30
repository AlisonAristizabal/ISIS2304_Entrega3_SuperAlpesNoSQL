db.createCollection("bodega", {
  validator: {
    $jsonSchema: {
      bsonType: "object",
      required: ["id", "nombre", "tamanio", "id_sucursal", "productosEnBodega"],
      properties: {
        id: {
          bsonType: "int",
          description:
            "Debe ser un número entero único que identifica la bodega",
        },
        nombre: {
          bsonType: "string",
          description: "Nombre de la bodega",
        },
        tamanio: {
          bsonType: "double",
          description: "Tamaño de la bodega en metros cuadrados",
        },
        id_sucursal: {
          bsonType: "int",
          description: "ID de la sucursal a la que pertenece la bodega",
        },
        productosEnBodega: {
          bsonType: "array",
          items: {
            bsonType: "object",
            required: [
              "id_producto",
              "cantidad",
              "costoPromedio",
              "minimoReorden",
            ],
            properties: {
              id_producto: {
                bsonType: "int",
                description: "ID del producto almacenado en la bodega",
              },
              cantidad: {
                bsonType: "int",
                description: "Cantidad de productos disponibles en la bodega",
              },
              costoPromedio: {
                bsonType: "double",
                description: "Costo promedio del producto en la bodega",
              },
              minimoReorden: {
                bsonType: "int",
                description: "Cantidad mínima para el reorden de producto",
              },
            },
            description: "Producto almacenado en la bodega",
          },
          description: "Lista de productos almacenados en la bodega",
        },
      },
    },
  },
  validationAction: "warn", // Se puede cambiar a "error" para bloquear documentos inválidos
});
