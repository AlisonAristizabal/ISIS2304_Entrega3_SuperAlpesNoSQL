db.producto.insertOne({
  id: NumberInt(1),
  nombre: "Leche Entera",
  costo_bodega: NumberInt(1500),
  precio_unidad: NumberInt(2000),
  presentacion: "Paquete de 6 unidades",
  cantidad_presentacion: NumberInt(6),
  volumen: 1000.0,
  peso_empaque: 150.0,
  unidad_medida: "ml",
  codigo_barras: "123456789",
  fecha_expiracion: ISODate("2025-01-01T00:00:00Z"),
  codigo_categoria: {
    id: NumberInt(1),
    codigo: NumberInt(101),
  },
});
