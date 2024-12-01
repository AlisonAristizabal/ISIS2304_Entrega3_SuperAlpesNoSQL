// Crear la colección "sucursal" con esquema de validación actualizado
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
          required: ["nombre"],
          properties: {
            nombre: {
              bsonType: "string",
              description: "Nombre de la ciudad asociada a la sucursal",
            },
          },
          description: "Información de la ciudad asociada a la sucursal",
        },
      },
    },
  },
});
