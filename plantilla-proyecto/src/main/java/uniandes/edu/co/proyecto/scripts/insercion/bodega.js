db.bodega.insertOne({
  id: 1,
  nombre: "Bodega Central",
  tamanio: 500.0,
  id_sucursal: 1,
  productosEnBodega: [
    {
      id_producto: 101,
      cantidad: 100,
      costoPromedio: 1500.0,
      minimoReorden: 50,
    },
    {
      id_producto: 102,
      cantidad: 200,
      costoPromedio: 2500.0,
      minimoReorden: 30,
    },
  ],
});
