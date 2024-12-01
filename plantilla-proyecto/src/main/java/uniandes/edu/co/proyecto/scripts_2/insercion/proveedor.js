// Ejemplo de inserción de un proveedor
db.proveedor.insertOne({
  nit: 1234567890123, // Usamos Number para el NIT
  direccion: "Calle 123, Bogotá",
  nombre_contacto: "Juan Pérez",
  telefono_contacto: "3001234567",
  id_productos: [
    ObjectId("CAMBIAR"), // Referencia a un _id de un producto
    ObjectId("CAMBIAR"), // Otra referencia a un _id de un producto
  ],
});
