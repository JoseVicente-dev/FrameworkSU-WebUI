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
      Entonces se mostrará el mensaje "There is 1 item in your cart."

    @ScenarioName:eliminarProductosDelCarrito
    Escenario: eliminar producto del carrito
      Dado que como cliente regitrado estoy en la zona de compras de vestidos
      Y he añadido un producto a mi carrito de compras
      Cuando cambie de opinión y elimine el producto del carrito
      Entonces se mostrara un mensaje que me indica "Your shopping cart is empty."
