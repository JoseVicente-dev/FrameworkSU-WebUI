# language: es
@FeatureName:soporteAlCliente
Característica: : Soporte al cliente
  Como visitante de la pagina
  Deseo realizar una peticion
  Para que atendida por el area de servicio al cliente
 @ScenarioName:contactarConServicioAlCliente
  Escenario: : Contactar con servicio al cliente
  Dado que estoy en la seccion Contact Us
  Cuando diligencie mi PQRS y la envie
  | SubjectHeading | Webmaster               |
  | Email           | p.sherman@pixar.com            |
  | Message         | ALL THE ANIMALS HAVE GONE MAD! |
  Entonces se confirmara el envio de la misma "Your message has been successfully sent to our team."

 @ScenarioName:intentarEnviarPQRSSinMensaje
 Escenario: : Intentar enviar una PQRS sin mensaje
  Dado que estoy en Contact Us
  Cuando diligencie el correo de contacto pero no suministre un mensaje
  | SubjectHeading | Customer service               |
  | Email           | p.sherman@pixar.com            |
  | Message         |   |
  Entonces se mostrara el error "The message cannot be blank."