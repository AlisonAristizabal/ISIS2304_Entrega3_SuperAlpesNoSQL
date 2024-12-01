db.bodega.insertOne({
  nombre: "Bodega Central",
  tamanio: 500.5, // Número que indica el tamaño en metros cuadrados
  id_sucursal: ObjectId("613b23f7c2b6b0f1a4c3e939"), // Referencia a una sucursal existente
  productos_en_bodega: [
    {
      id_producto: ObjectId("613b23f7c2b6b0f1a4c3e938"), // Referencia a un producto existente
      cantidad: 150, // Número entero
      costoPromedio: 2000.0, // Número decimal
      minimoReorden: 50, // Número entero
    },
    {
      id_producto: ObjectId("613b23f7c2b6b0f1a4c3e940"), // Otra referencia a un producto existente
      cantidad: 300,
      costoPromedio: 1800.0,
      minimoReorden: 100,
    },
  ],
});
