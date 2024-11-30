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
            "Debe ser un número entero único que identifica el producto",
        },
        nombre: {
          bsonType: "string",
          description: "Nombre descriptivo del producto",
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
          description: "Descripción de la presentación del producto",
        },
        cantidad_presentacion: {
          bsonType: "int",
          description: "Cantidad contenida en cada presentación",
        },
        volumen: {
          bsonType: "double",
          description: "Volumen del producto en unidades de medida",
        },
        peso_empaque: {
          bsonType: "double",
          description: "Peso del empaque del producto",
        },
        unidad_medida: {
          bsonType: "string",
          description: "Unidad de medida para el volumen y peso",
        },
        codigo_barras: {
          bsonType: "string",
          description: "Código de barras del producto",
        },
        fecha_expiracion: {
          bsonType: "date",
          description: "Fecha de expiración del producto",
        },
        codigo_categoria: {
          bsonType: "int",
          description: "Identificador único de la categoría asociada",
        },
      },
    },
  },
  validationAction: "warn", // Cambiar a "error" para bloquear documentos inválidos
});
