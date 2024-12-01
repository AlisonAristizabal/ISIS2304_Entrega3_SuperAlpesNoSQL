db.bodega.insertOne({
  nombre: "Bodega Central",
  tamanio: 500.5, // Número que indica el tamaño en metros cuadrados
  id_sucursal: ObjectId("674cc546f27f5d2338b51194"), // Referencia a una sucursal existente
  productos_en_bodega: [
    {
      id_producto: ObjectId("674bb85edf3c2478c8e91918"), // Referencia a un producto existente
      cantidad: 150, // Número entero
      costoPromedio: 2000.0, // Número decimal
      minimoReorden: 50, // Número entero
    },
    {
      id_producto: ObjectId("674bb85edf3c2478c8e91918"), // Otra referencia a un producto existente
      cantidad: 300,
      costoPromedio: 1800.0,
      minimoReorden: 100,
    },
  ],
});
