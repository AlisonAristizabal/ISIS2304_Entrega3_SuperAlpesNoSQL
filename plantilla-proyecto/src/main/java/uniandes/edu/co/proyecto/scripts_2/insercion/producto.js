// Ejemplo de inserción de un producto
db.producto.insertOne({
  nombre: "Queso Fresco",
  costo_bodega: 5000, // Usamos Number para el costo
  precio_unidad: 6500, // Usamos Number para el precio
  presentacion: "Bulto de 5kg",
  cantidad_presentacion: 1, // Usamos Number para la cantidad
  volumen: 2000, // Usamos Number para el volumen
  peso_empaque: 5000, // Usamos Number para el peso
  unidad_medida: "gr",
  codigo_barras: "987654321",
  fecha_expiracion: ISODate("2025-06-01T00:00:00Z"),
  id_categoria: ObjectId("CAMBIAR"), // Reemplazar con un ObjectId de categoría válida
});
