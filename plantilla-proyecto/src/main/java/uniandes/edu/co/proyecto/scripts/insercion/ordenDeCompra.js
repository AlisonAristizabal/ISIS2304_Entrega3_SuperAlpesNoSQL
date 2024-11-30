db.orden_de_compra.insertOne({
  id: 1,
  fecha_esperada_entrega: ISODate("2024-12-15T00:00:00Z"),
  estado: "pendiente",
  id_sucursal: 2,
  id_proveedor: 10,
  productosOrdenCompra: [
    {
      cantidad: 50,
      precio: 1500,
      id_producto: 101,
    },
    {
      cantidad: 30,
      precio: 2500,
      id_producto: 102,
    },
  ],
});
