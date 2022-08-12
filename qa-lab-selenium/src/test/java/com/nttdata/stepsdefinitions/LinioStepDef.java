package com.nttdata.stepsdefinitions;

import com.nttdata.steps.LinioLoginSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.nttdata.steps.InventorySteps;

public class LinioStepDef {


    private WebDriver driver;
    private Scenario scenario;
    private LinioLoginSteps loginSteps;


    private InventorySteps inventorySteps(WebDriver driver){
        return new InventorySteps(driver);
    }

    @Before(order = 0)
    public void setUp() {
        //setUp
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        //crear el driver
        driver = new ChromeDriver();
        //max
        driver.manage().window().maximize();
    }

    @Before(order = 1)
    public void setScenario(Scenario scenario) {

        this.scenario = scenario;
    }

    @After
    public void quitDriver() {
        driver.quit();
    }


    @Given("que estoy en la pagina de inicio de Linio")
    public void queEstoyEnLaPaginaDeInicioDeLinio() {
            driver.get("https://www.linio.com.pe/account/login");
            screenShot();
        }

        @When("ingresamos mis credenciales usuario {string} y la clave {string}")
        public void ingresamosMisCredencialesUsuarioYLaClave (String user, String password){
            loginSteps = new LinioLoginSteps(driver);
            loginSteps.typeUser(user);
            loginSteps.typePassword(password);
            screenShot();
        }


        @And("hago clic en Iniciar Sesión Segura")
        public void hagoClicEnIniciarSesiónSegura () {
            loginSteps.login();
            screenShot();
        }

        @And("validar que estoy logeado correctamente")
        public void validarQueEstoyLogeadoCorrectamente () {
        }

        public void screenShot () {
            byte[] evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            this.scenario.attach(evidencia, "image/png", "evidencias");
        }

    @And("me dirijo a la sección {string}")
    public void meDirijoALaSección(String arg0) {
        driver.get("https://www.linio.com.pe/cm/mejor-calificados");
        screenShot();
    }


    @And("hago clic en el producto {string}")
    public void hagoClicEnElProducto(String arg0) {
        loginSteps.click();
        screenShot();
    }

    @And("hago clic en añadir al carrito")
    public void hagoClicEnAñadirAlCarrito() {
        loginSteps.compra();
        screenShot();

    }

    @And("validar mensaje tu {string}")
    public void validarMensajeTu( String title) {

    }



}
