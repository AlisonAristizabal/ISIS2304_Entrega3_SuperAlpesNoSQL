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
        "categoria",
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
          description: "Costo en la bodega",
        },
        precio_unidad: {
          bsonType: "int",
          description: "Precio de venta por unidad",
        },
        presentacion: {
          bsonType: "string",
          description: "Formato o presentación del producto",
        },
        cantidad_presentacion: {
          bsonType: "double",
          description: "Cantidad incluida en la presentación (peso o volumen)",
        },
        volumen: {
          bsonType: "double",
          description: "Volumen del empaque en cm3",
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
        categoria: {
          bsonType: "object",
          required: [
            "codigo",
            "nombre",
            "descripcion",
            "caracteristica_almacenamiento",
          ],
          properties: {
            codigo: {
              bsonType: "int",
              description: "Código único de la categoría",
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
              description: "Condiciones necesarias para almacenar la categoría",
            },
          },
          description: "Información de la categoría asociada al producto",
        },
      },
    },
  },
  validationAction: "warn", // Puede ser "error" para que se rechacen los documentos inválidos
});
