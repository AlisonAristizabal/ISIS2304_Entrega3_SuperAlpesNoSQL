// Crear la colección "producto" con esquema de validación
db.createCollection("producto", {
  validator: {
    $jsonSchema: {
      bsonType: "object",
      required: [
        "id",
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
        "codigo_categoria",
      ],
      properties: {
        id: {
          bsonType: "int",
          description:
            "Debe ser un número entero único que identifica al producto",
        },
        nombre: {
          bsonType: "string",
          description: "Nombre del producto",
        },
        costo_bodega: {
          bsonType: "int",
          description: "Costo del producto en bodega",
        },
        precio_unidad: {
          bsonType: "int",
          description: "Precio de venta por unidad",
        },
        presentacion: {
          bsonType: "string",
          description: "Presentación del producto (ej: paquete de 6 unidades)",
        },
        cantidad_presentacion: {
          bsonType: "int",
          description: "Cantidad en la presentación (entero)",
        },
        volumen: {
          bsonType: "double",
          description: "Volumen del producto en cm³",
        },
        peso_empaque: {
          bsonType: "double",
          description: "Peso del empaque en gramos",
        },
        unidad_medida: {
          bsonType: "string",
          enum: ["gr", "ml"],
          description: "Unidad de medida: gramos o mililitros",
        },
        codigo_barras: {
          bsonType: "string",
          description: "Código de barras único del producto",
        },
        fecha_expiracion: {
          bsonType: "date",
          description: "Fecha de expiración del producto en formato ISODate",
        },
        codigo_categoria: {
          bsonType: "object",
          required: ["id", "codigo"],
          properties: {
            id: {
              bsonType: "int",
              description: "Identificador único de la categoría asociada",
            },
            codigo: {
              bsonType: "int",
              description: "Código de la categoría asociada",
            },
          },
          description: "Referencia a la categoría del producto",
        },
      },
    },
  },
});
