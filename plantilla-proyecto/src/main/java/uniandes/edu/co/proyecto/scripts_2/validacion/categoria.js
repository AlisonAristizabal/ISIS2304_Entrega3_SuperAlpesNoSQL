// Crear la colección "categoria" con esquema de validación sin el campo "_id"
db.createCollection("categoria", {
  validator: {
    $jsonSchema: {
      bsonType: "object",
      required: [
        "codigo",
        "nombre",
        "descripcion",
        "caracteristica_almacenamiento",
      ],
      properties: {
        codigo: {
          bsonType: "int", // El código debe ser un número entero
          description: "Código único de la categoría",
        },
        nombre: {
          bsonType: "string", // Nombre de la categoría
          description: "Nombre de la categoría",
        },
        descripcion: {
          bsonType: "string", // Descripción de la categoría
          description: "Descripción de la categoría",
        },
        caracteristica_almacenamiento: {
          bsonType: "string", // Características de almacenamiento
          description: "Condiciones necesarias para almacenar la categoría",
        },
      },
    },
  },
});
