db.producto.insertOne({
  id: 1,
  nombre: "Leche Entera",
  costo_bodega: 1500,
  precio_unidad: 2000,
  presentacion: "Paquete de 6 unidades",
  cantidad_presentacion: 6,
  volumen: 1000,
  peso_empaque: 150,
  unidad_medida: "ml",
  codigo_barras: "123456789",
  fecha_expiracion: ISODate("2025-01-01T00:00:00Z"),
  categoria: {
    codigo: 101,
    nombre: "Perecederos",
    descripcion: "Productos que requieren refrigeración",
    caracteristica_almacenamiento: "Mantener entre 0-4 °C",
  },
});
