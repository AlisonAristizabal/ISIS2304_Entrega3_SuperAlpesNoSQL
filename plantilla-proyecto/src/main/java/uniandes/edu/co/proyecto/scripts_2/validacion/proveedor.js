// Crear la colección "proveedor" con esquema de validación donde todos los números sean de tipo "number"
db.createCollection("proveedor", {
  validator: {
    $jsonSchema: {
      bsonType: "object",
      required: [
        "nit",
        "direccion",
        "nombre_contacto",
        "telefono_contacto",
        "id_productos",
      ],
      properties: {
        _id: {
          bsonType: "objectId", // MongoDB asignará este campo automáticamente
          description: "Identificador único del proveedor",
        },
        nit: {
          bsonType: "number", // Validamos que sea un número (puede ser entero o decimal)
          description: "Número de identificación tributaria del proveedor",
        },
        direccion: {
          bsonType: "string", // Dirección del proveedor
          description: "Dirección del proveedor",
        },
        nombre_contacto: {
          bsonType: "string", // Nombre del contacto del proveedor
          description: "Nombre del contacto",
        },
        telefono_contacto: {
          bsonType: "string", // Teléfono del contacto
          description: "Teléfono de contacto del proveedor",
        },
        id_productos: {
          bsonType: "array", // Validamos que sea un arreglo
          items: {
            bsonType: "objectId", // Cada elemento en el arreglo debe ser una referencia al _id de un producto
            description: "Referencia a los _id de los productos",
          },
          description: "Lista de productos asociados al proveedor",
        },
      },
    },
  },
});
