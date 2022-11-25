#Test Automation Web Challenge
###Escenarios en el Feature:
- Agregar varias categorias
- Carrito de compras
- Flujo Checkout con visualización del numero de tarjeta

###Datos Técnicos:
- Java 11
- Selenium
- TestNg
- Cucumber
- Allure (Report)

###Ejecución por Terminal:
- Test: mvn clean test / mvn test
- Reporte: mvn allure:serve (Opcional)

###Estructura:
1. Main: 

    1.1 com.challenge.config 

    1.1.1 ConfigPage: 
    - Contiene los parámetros iniciales de configuración. 
    - Se implementó la librería WebDriverManager, para automatizar el proceso de obtención del chromedriver/geckodriver, no es necesario agregarlo ni actualizarlo.
    - Manejo de métodos de Selenium.

    1.1.2 LoggerPage:
    - Manejo de Logger (Log4j) para registrar el proceso.

    1.1.3 PropertiesPage:
    - Manejo de las propiedades de ejecución como Url, browser (chrome o firefox), username y password.
    
    1.1.4 TestDataPage:
    - Clase para el manejo de los datos de pruebas para el escenario de los Datos para la compra

    1.2 com.challenge.process

    //Los procesos son manejados por separados pero en ejecución son dependientes

    1.2.1 LoginProcess: 
    - Métodos para el manejo del Inicio y Login del usuario en la página web
    
    1.2.2 AddMultipleCategoriesProcess: 
    - Métodos para el manejo del agregado de productos por categoría
    
    1.2.3 ShoppingCartProcess: 
    - Métodos para el manejo del agregado de productos al carrito de compras y el chequeo 
    de su visualización en el mismo
    
    1.2.4 CheckoutFlowProcess: 
    - Métodos para el manejo del flujo de Agregar un producto, ir al carrito y procesar la compra. 
    Además de verificar que el numero de tarjeta de crédito ingresado coincida con el expuesto en el mensaje de confirmación.

2. Test:

    2.1 com.challenge.test.defs

    //Pasos en la ejecución del proceso. Asociados a los Scenarios del Feature

    2.1.1 AddMultipleCategoriesTest: métodos para la ejecución del Agregado de productos al carrito
    
    2.1.2 ShoppingCartTest: métodos para la ejecución del Chequeo del carrito de compras
    
    2.1.3 CheckoutFlowTest: métodos para la ejecución del Flujo de compra y verificación de datos

    2.2. RunCucumberTest.java
    Definición del ejecutable (Cucumber + TestNg)

###Escenarios
* src/test/resources/scenarios.feature contiene los Escenarios del Feature en Gherkin.

###Reportes:
Se pueden obtener reportes de dos maneras:
1. Allure: mvn allure:serve una vez terminada la ejecución del test. Este reporte
muestra cada escenario ejecutado e incluye los screenshots de cada proceso.
2. Cucumber Report: reporte por defecto, es posible encontrarlo en la carpeta Target del proyecto.
No incluye screenshots.

###Screenshots:
Están configurados por defecto para incluirse en el reporte de Allure y en la carpeta
Screenshots del proyecto, a modo de backup.

###Logs:
Están configurados para registrar los procesos de la ejecución. Se registran en dos archivos,
automation.log y automation.error según el status de los que se ha registrado. Se almacenan por día
en un archivo comprimido a fin de almacenar los registros.