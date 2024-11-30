db.createCollection("proveedor", {
  validator: {
    $jsonSchema: {
      bsonType: "object",
      required: [
        "id",
        "NIT",
        "direccion",
        "nombre_contacto",
        "telefono_contacto",
        "id_productos",
      ],
      properties: {
        id: {
          bsonType: "int",
          description:
            "Debe ser un número entero único que identifica al proveedor",
        },
        NIT: {
          bsonType: "long",
          description: "Número de identificación tributaria del proveedor",
        },
        direccion: {
          bsonType: "string",
          description: "Dirección del proveedor",
        },
        nombre_contacto: {
          bsonType: "string",
          description: "Nombre de la persona de contacto en el proveedor",
        },
        telefono_contacto: {
          bsonType: "string",
          description: "Teléfono de contacto del proveedor",
        },
        id_productos: {
          bsonType: "array",
          items: {
            bsonType: "int",
            description:
              "Lista de IDs de productos que el proveedor puede ofrecer",
          },
          description: "Lista de productos que el proveedor ofrece",
        },
      },
    },
  },
  validationAction: "warn", // Se puede cambiar a "error" para bloquear documentos inválidos
});
