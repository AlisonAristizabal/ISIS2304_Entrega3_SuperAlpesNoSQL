// Crear la colección "categoria" con esquema de validación
db.createCollection("categoria", {
  validator: {
    $jsonSchema: {
      bsonType: "object",
      required: [
        "id",
        "codigo",
        "nombre",
        "descripcion",
        "caracteristica_almacenamiento",
      ],
      properties: {
        id: {
          bsonType: "int",
          description:
            "Debe ser un número entero único que identifica la categoría",
        },
        codigo: {
          bsonType: "int",
          description:
            "Debe ser un número entero único que identifica la categoría",
        },
        nombre: {
          bsonType: "string",
          description: "Nombre de la categoría",
        },
        descripcion: {
          bsonType: "string",
          description: "Descripción de la categoría",
        },
        caracteristica_almacenamiento: {
          bsonType: "string",
          description: "Condiciones necesarias para almacenar esta categoría",
        },
      },
    },
  },
});

// Crear un índice único en el campo "codigo"
db.categoria.createIndex({ codigo: 1 }, { unique: true });
