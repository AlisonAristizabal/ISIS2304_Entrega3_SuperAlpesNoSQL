db.ciudad.insertOne({
  nombre: "Bogotá",
});
db.sucursal.insertOne({
  nombre: "Sucursal Centro",
  telefono: "123456789",
  direccion: "Carrera 10 #20-30",
  ciudad: {
    _id: ObjectId("CAMBIAR POR EL QUE SE ASIGNE"), // Esto sería el _id de una ciudad existente
    nombre: "Bogotá",
  },
});
