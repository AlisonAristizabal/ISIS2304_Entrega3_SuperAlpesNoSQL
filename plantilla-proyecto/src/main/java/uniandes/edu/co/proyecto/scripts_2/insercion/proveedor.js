// Ejemplo de inserción de un proveedor
db.proveedor.insertOne({
  nit: 1234567890123, // Usamos Number para el NIT
  direccion: "Calle 123, Bogotá",
  nombre_contacto: "Juan Pérez",
  telefono_contacto: "3001234567",
  id_productos: [
    ObjectId("613b23f7c2b6b0f1a4c3e938"), // Referencia a un _id de un producto
    ObjectId("613b23f7c2b6b0f1a4c3e938"), // Otra referencia a un _id de un producto
  ],
});
