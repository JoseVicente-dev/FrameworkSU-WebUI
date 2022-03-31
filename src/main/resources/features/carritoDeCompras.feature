# language: es
  @FeatureName:carritoDeCompras
  Característica: carrito de compras
    Como usuario registrado
    Deseo comprar en linea
    Para evitar ir a la tienda

    @ScenarioName:adicionarProductosAlCarrito
    Escenario: adicionar un producto al carrito
      Dado que soy un cliente registrado
      Y estoy en la zona de compras de vestidos casuales
      Cuando añada un producto al carrito y quiera seguir comprando
      Entonces el contador de productos aumentará en 1
