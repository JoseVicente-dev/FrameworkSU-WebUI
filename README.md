# FrameworkSU-WebUI

# Plan de pruebas Framework Sofka WebUI

Es necesario verificar el funcionamiento del sitio web http://automationpractice.com/index.php

Se requiere probar los apartados web **Contac us** y **el carro de compras**.

# Alcance

Se probaran los apartados:

- **Contac us**
- **Carrito de compras**

Se crearan 2 escenarios por apartado.

**Fuera del alcance:** otros modulos no indicados en el alcance. Modificación de usuarios registraods. Modificación de información de productos.

# Estrategia de pruebas

Las pruebas se harán automatizadas usando el framework de automatización de Sofka Tech

Se plantearán 2 escenarios por cada modulo. Se ejecutarán en el siguiente orden:

1. Contact us
2. Carrito de compras

**Cobertura de pruebas:** se ejecutarán en navegador Google Chrome, usando el SO Windows 10.

**Estrategia de pruebas**: se generaran datos aleatorios para usuarios usando librerias de aleatorizacion de java, asi como JAVA Faker en donde se requiera.

## Escenarios contact us

```
# language: es
@FeatureName:soporteAlCliente
**Característica**: : Soporte al cliente
  **Como** visitante de la pagina
  **Deseo** realizar una peticion
  **Para** que atendida por el area de servicio al cliente
 @ScenarioName:contactarConServicioAlCliente
  **Escenario**: : Contactar con servicio al cliente
  **Dado** que estoy en la seccion Contact Us
  **Cuando** diligencie mi PQRS y la envie
  | SubjectHeading | Webmaster               |
  | Email           | p.sherman@pixar.com            |
  | Message         | ALL THE ANIMALS HAVE GONE MAD! |
  **Entonces** se confirmara el envio de la misma "Your message has been successfully sent to our team."

 @ScenarioName:intentarEnviarPQRSSinMensaje
 **Escenario**: : Intentar enviar una PQRS sin mensaje
  **Dado** que estoy en Contact Us
  **Cuando** diligencie el correo de contacto pero no suministre un mensaje
  | SubjectHeading | Customer service               |
  | Email           | p.sherman@pixar.com            |
  | Message         |   |
  **Entonces** se mostrara el error "The message cannot be blank."
```

## Escenarios carrito de compras

```
# language: es
  @FeatureName:carritoDeCompras
  **Característica**: carrito de compras
    **Como** usuario registrado
    **Deseo** comprar en linea
    **Para** evitar ir a la tienda

    @ScenarioName:adicionarProductosAlCarrito
    **Escenario**: adicionar un producto al carrito
      **Dado** que soy un cliente registrado
      **Y** estoy en la zona de compras de vestidos casuales
      **Cuando** añada un producto al carrito y quiera seguir comprando
      **Entonces** se mostrará el mensaje "There is 1 item in your cart."

    @ScenarioName:eliminarProductosDelCarrito
    **Escenario**: eliminar producto del carrito
      **Dado** que como cliente regitrado estoy en la zona de compras de vestidos
      **Y** he añadido un producto a mi carrito de compras
      **Cuando** cambie de opinión y elimine el producto del carrito
      **Entonces** se mostrara un mensaje que me indica "Your shopping cart is empty."
```

# Otros tipos de pruebas

Se recomienda al equipo realizar las siguientes pruebas:

- Pruebas de Rendimiento
- Pruebas de Seguridad

# Requerimientos

Acceso a ambiente de desarrollo

Acceso a framework de automatizacion de Sofka Tech con sus credenciales válidas