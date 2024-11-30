db.sucursal.insertOne({
  id: 1,
  nombre: "Sucursal Centro",
  telefono: "123456789",
  direccion: "Av. Principal 123",
  ciudad: {
    id_ciudad: 1,
    nombre: "Bogotá",
  },
});
