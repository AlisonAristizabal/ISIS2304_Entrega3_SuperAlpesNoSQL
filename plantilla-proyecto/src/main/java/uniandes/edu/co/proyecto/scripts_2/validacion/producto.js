// Crear la colección "producto" con esquema de validación usando Number para todos los campos numéricos
db.createCollection("producto", {
  validator: {
    $jsonSchema: {
      bsonType: "object",
      required: [
        "nombre",
        "costo_bodega",
        "precio_unidad",
        "presentacion",
        "cantidad_presentacion",
        "volumen",
        "peso_empaque",
        "unidad_medida",
        "codigo_barras",
        "fecha_expiracion",
        "id_categoria",
      ],
      properties: {
        _id: {
          bsonType: "objectId", // MongoDB asignará este campo automáticamente
          description: "Identificador único del producto",
        },
        nombre: {
          bsonType: "string",
          description: "Nombre del producto",
        },
        costo_bodega: {
          bsonType: "number", // Usamos "number" para todos los valores numéricos
          description: "Costo del producto en bodega",
        },
        precio_unidad: {
          bsonType: "number", // Usamos "number" para todos los valores numéricos
          description: "Precio de venta por unidad",
        },
        presentacion: {
          bsonType: "string",
          description: "Presentación del producto (ej: paquete, botella, caja)",
        },
        cantidad_presentacion: {
          bsonType: "number", // Usamos "number" para todos los valores numéricos
          description: "Cantidad en la presentación",
        },
        volumen: {
          bsonType: "number", // Usamos "number" para volumen
          description: "Volumen en cm³",
        },
        peso_empaque: {
          bsonType: "number", // Usamos "number" para peso del empaque
          description: "Peso del empaque en gramos",
        },
        unidad_medida: {
          bsonType: "string",
          enum: ["gr", "ml"], // Solo se permiten estos valores
          description: "Unidad de medida del producto",
        },
        codigo_barras: {
          bsonType: "string",
          description: "Código de barras único",
        },
        fecha_expiracion: {
          bsonType: "date",
          description: "Fecha de expiración del producto en formato ISODate",
        },
        id_categoria: {
          bsonType: "objectId", // Referencia al _id de la categoría
          description: "Referencia al _id de la categoría",
        },
      },
    },
  },
});
