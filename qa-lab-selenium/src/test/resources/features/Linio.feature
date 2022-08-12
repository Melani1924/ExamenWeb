@LoginLinio
Feature: Login Linio

  Scenario: Login a Linio
    Given que estoy en la pagina de inicio de Linio
    When ingresamos mis credenciales usuario "gabrieljosvic@gmail.com" y la clave "Gabriel1924@"
    And hago clic en Iniciar Sesión Segura
    And validar que estoy logeado correctamente
    And  me dirijo a la sección "Mejores Calificados"
    And hago clic en el producto "Repetidor Wifi Xiaomi Pro R03"
    And hago clic en añadir al carrito
    And validar mensaje tu "Tu producto se agrego al carrito"