db.createCollection("sucursal", {
  validator: {
    $jsonSchema: {
      bsonType: "object",
      required: ["id", "nombre", "telefono", "direccion", "ciudad"],
      properties: {
        id: {
          bsonType: "int",
          description:
            "Debe ser un número entero único que identifica la sucursal",
        },
        nombre: {
          bsonType: "string",
          description: "Nombre de la sucursal",
        },
        telefono: {
          bsonType: "string",
          description: "Número de teléfono de la sucursal",
        },
        direccion: {
          bsonType: "string",
          description: "Dirección de la sucursal",
        },
        ciudad: {
          bsonType: "object",
          required: ["id_ciudad", "nombre"],
          properties: {
            id_ciudad: {
              bsonType: "int",
              description: "ID único de la ciudad",
            },
            nombre: {
              bsonType: "string",
              description: "Nombre de la ciudad",
            },
          },
          description: "Información de la ciudad asociada a la sucursal",
        },
      },
    },
  },
  validationAction: "warn", // Se puede cambiar a "error" para bloquear documentos inválidos
});
