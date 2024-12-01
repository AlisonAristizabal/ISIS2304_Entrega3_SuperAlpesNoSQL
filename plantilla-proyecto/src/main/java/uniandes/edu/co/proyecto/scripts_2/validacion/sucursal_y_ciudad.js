// Crear la colección "ciudad" con esquema de validación
db.createCollection("ciudad", {
  validator: {
    $jsonSchema: {
      bsonType: "object",
      required: ["nombre"], // solo "nombre" es obligatorio
      properties: {
        _id: {
          bsonType: "objectId", // MongoDB asignará este campo automáticamente
          description: "Identificador único de la ciudad",
        },
        nombre: {
          bsonType: "string",
          description: "Nombre de la ciudad",
        },
      },
    },
  },
});

// Crear la colección "sucursal" con esquema de validación
db.createCollection("sucursal", {
  validator: {
    $jsonSchema: {
      bsonType: "object",
      required: ["nombre", "telefono", "direccion", "ciudad"],
      properties: {
        nombre: {
          bsonType: "string",
          description: "Nombre de la sucursal",
        },
        telefono: {
          bsonType: "string",
          description: "Teléfono de la sucursal",
        },
        direccion: {
          bsonType: "string",
          description: "Dirección de la sucursal",
        },
        ciudad: {
          bsonType: "object",
          required: ["_id", "nombre"],
          properties: {
            _id: {
              bsonType: "objectId", // Referencia al _id de la ciudad
              description: "ID de la ciudad",
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
});
