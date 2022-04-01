package co.com.client.webproject.test.stepdefinition.shoppingcart;

import co.com.client.webproject.test.controllers.CreateAnAccountWebController;
import co.com.client.webproject.test.controllers.DressesPageController;
import co.com.client.webproject.test.controllers.LoginPageController;
import co.com.client.webproject.test.controllers.MyAccountWebController;
import co.com.client.webproject.test.controllers.openwebpage.StartBrowserWebController;
import co.com.client.webproject.test.data.objects.TestInfo;
import co.com.client.webproject.test.stepdefinition.Setup;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Assert;
import co.com.sofka.test.evidence.reports.Report;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

public class AdicionarUnProductoStepsDefinition extends Setup {

    private WebAction webAction;
    DressesPageController dressesPageController;

    @Before
    public void setup(Scenario scenario){
        testInfo = new TestInfo(scenario);
        webAction = new WebAction(testInfo.getFeatureName());
        webAction.setScenario(testInfo.getScenarioName());
    }

    @Dado("que soy un cliente registrado")
    public void queSoyUnClienteRegistrado() {
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

    }
    @Dado("estoy en la zona de compras de vestidos casuales")
    public void estoyEnLaZonaDeComprasDeVestidosCasuales() {

        MyAccountWebController myAccountWebController = new MyAccountWebController();
        myAccountWebController.setWebAction(webAction);
        myAccountWebController.irAComprarVestidos();
    }
    @Cuando("añada un producto al carrito y quiera seguir comprando")
    public void añadaUnProductoAlCarritoYQuieraSeguirComprando() {

        dressesPageController = new DressesPageController();
        dressesPageController.setWebAction(webAction);
        dressesPageController.adicionarUnProductoAlCarrito();
    }
    @Entonces("se mostrará el mensaje {string}")
    public void elContadorDeProductosAumentaráEn(String mensajeDeConfirmacion) {

        String mensaje = dressesPageController.obtenerMensajeDeConfirmacion();

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
