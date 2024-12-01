// Crear la colección "bodega" con esquema de validación (sin incluir _id)
db.createCollection("bodega", {
  validator: {
    $jsonSchema: {
      bsonType: "object",
      required: ["nombre", "tamanio", "id_sucursal", "productos_en_bodega"],
      properties: {
        nombre: {
          bsonType: "string",
          description: "Nombre de la bodega",
        },
        tamanio: {
          bsonType: "number", // El tamaño de la bodega será un número
          description: "Tamaño de la bodega en metros cuadrados",
        },
        id_sucursal: {
          bsonType: "objectId", // Referencia al _id de una sucursal
          description: "Referencia a la sucursal donde se encuentra la bodega",
        },
        productos_en_bodega: {
          bsonType: "array", // Es un arreglo embebido
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
                bsonType: "objectId", // Referencia al _id de un producto
                description: "Referencia al producto almacenado en la bodega",
              },
              cantidad: {
                bsonType: "number", // La cantidad de productos es un número
                description: "Cantidad de productos almacenados en la bodega",
              },
              costoPromedio: {
                bsonType: "number", // Costo promedio como número
                description: "Costo promedio del producto en la bodega",
              },
              minimoReorden: {
                bsonType: "number", // Mínimo de reorden como número
                description: "Nivel mínimo de stock para generar reorden",
              },
            },
          },
          description: "Lista de productos almacenados en la bodega",
        },
      },
    },
  },
});
