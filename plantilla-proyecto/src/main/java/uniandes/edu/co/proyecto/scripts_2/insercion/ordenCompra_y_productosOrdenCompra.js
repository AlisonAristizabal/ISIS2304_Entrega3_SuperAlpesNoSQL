db.orden_de_compra.insertOne({
  fecha_esperada_entrega: ISODate("2024-01-15T00:00:00Z"), // Fecha esperada de entrega
  estado: "Pendiente", // Estado de la orden
  id_sucursal: ObjectId("613b23f7c2b6b0f1a4c3e939"), // Referencia a una sucursal existente
  id_proveedor: ObjectId("613b23f7c2b6b0f1a4c3e940"), // Referencia a un proveedor existente
  productos_orden_compra: [
    {
      id_producto: ObjectId("613b23f7c2b6b0f1a4c3e938"), // Referencia a un producto existente
      cantidad: 50, // Número entero que indica la cantidad solicitada
      precio: 1500, // Número que indica el precio unitario
    },
    {
      id_producto: ObjectId("613b23f7c2b6b0f1a4c3e941"), // Otra referencia a un producto existente
      cantidad: 20,
      precio: 2000,
    },
  ],
});
