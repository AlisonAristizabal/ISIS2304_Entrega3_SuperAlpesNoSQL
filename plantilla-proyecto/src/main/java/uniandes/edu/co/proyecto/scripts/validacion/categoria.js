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
          description: "Código único para la categoría",
        },
        nombre: {
          bsonType: "string",
          description: "Nombre descriptivo de la categoría",
        },
        descripcion: {
          bsonType: "string",
          description: "Descripción de la categoría",
        },
        caracteristica_almacenamiento: {
          bsonType: "string",
          description:
            "Características relacionadas con el almacenamiento de la categoría",
        },
      },
    },
  },
  validationAction: "warn", // Cambiar a "error" para bloquear documentos inválidos
});
