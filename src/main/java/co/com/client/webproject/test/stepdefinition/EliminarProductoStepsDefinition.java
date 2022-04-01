package co.com.client.webproject.test.stepdefinition;

import co.com.client.webproject.test.controllers.*;
import co.com.client.webproject.test.controllers.openwebpage.StartBrowserWebController;
import co.com.client.webproject.test.data.objects.TestInfo;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Assert;
import co.com.sofka.test.evidence.reports.Report;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

public class EliminarProductoStepsDefinition extends Setup {

    private WebAction webAction;
    ShoppingCartPageController shoppingCartPageController;


    @Before
    public void setup(Scenario scenario) {
        testInfo = new TestInfo(scenario);
        webAction = new WebAction(testInfo.getFeatureName());
        webAction.setScenario(testInfo.getScenarioName());
    }

    @Dado("que como cliente regitrado estoy en la zona de compras de vestidos")
    public void queComoClienteRegitradoEstoyEnLaZonaDeComprasDeVestidos() {

        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setWebAction(webAction);
        startBrowserWebController.setBrowser(browser());
        startBrowserWebController.setFeature(testInfo.getFeatureName());
        startBrowserWebController.abrirTiendaOnline();

        LoginPageController loginPageController = new LoginPageController();
        loginPageController.setWebAction(webAction);
        loginPageController.irHaciaLoginPage();

        CreateAnAccountWebController createAnAccountWebController = new CreateAnAccountWebController();
        createAnAccountWebController.setWebAction(webAction);
        createAnAccountWebController.crearUnaCuenta();

        MyAccountWebController myAccountWebController = new MyAccountWebController();
        myAccountWebController.setWebAction(webAction);
        myAccountWebController.irAComprarVestidos();
    }

    @Dado("he añadido un producto a mi carrito de compras")
    public void heAñadidoUnProductoAMiCarritoDeCompras() {

        DressesPageController dressesPageController = new DressesPageController();
        dressesPageController.setWebAction(webAction);
        dressesPageController.adicionarUnProductoAlCarrito();
        dressesPageController.procederAlCheckout();
    }

    @Cuando("cambie de opinión y elimine el producto del carrito")
    public void cambieDeOpiniónYElimineElProductoDelCarrito() {

        shoppingCartPageController = new ShoppingCartPageController();
        shoppingCartPageController.setWebAction(webAction);
        shoppingCartPageController.eliminarProducto();
    }

    @Entonces("se mostrara un mensaje que me indica {string}")
    public void seMostraraUnMensajeQueMeIndica(String mensajeDeConfirmacion) {
        String mensaje = shoppingCartPageController.obtenerMensajeDeConfirmacion();

        Assert
                .Hard
                .thatString(mensaje)
                .isEqualTo(mensajeDeConfirmacion);
    }

    @After
    public void cerrarDriver() throws InterruptedException {

        Thread.sleep(5000);

        if (webAction != null && webAction.getDriver() != null)
            webAction.closeBrowser();

        Report.reportInfo("***** HA FINALIZADO LA PRUEBA******"
                .concat(testInfo.getFeatureName())
                .concat("-")
                .concat(testInfo.getScenarioName()));
    }
}
