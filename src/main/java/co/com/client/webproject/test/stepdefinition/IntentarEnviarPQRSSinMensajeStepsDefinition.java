package co.com.client.webproject.test.stepdefinition;

import co.com.client.webproject.test.controllers.ContactUsPageController;
import co.com.client.webproject.test.controllers.DressesPageController;
import co.com.client.webproject.test.controllers.LoginPageController;
import co.com.client.webproject.test.controllers.openwebpage.StartBrowserWebController;
import co.com.client.webproject.test.data.objects.TestInfo;
import co.com.client.webproject.test.helpers.ContactUsMessageKeys;
import co.com.client.webproject.test.helpers.Dictionary;
import co.com.client.webproject.test.helpers.Helper;
import co.com.client.webproject.test.model.ContactUsMessage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Assert;
import co.com.sofka.test.evidence.reports.Report;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import java.util.Map;

public class IntentarEnviarPQRSSinMensajeStepsDefinition extends Setup{
    private WebAction webAction;
    private ContactUsMessage contactUsMessage;
    private ContactUsPageController contactUsPageController;

    @Before
    public void setup(Scenario scenario){
        testInfo = new TestInfo(scenario);
        webAction = new WebAction(testInfo.getFeatureName());
        webAction.setScenario(testInfo.getScenarioName());
    }

    @Dado("que estoy en Contact Us")
    public void queEstoyEnContactUs() {

        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setWebAction(webAction);
        startBrowserWebController.setBrowser(browser());
        startBrowserWebController.setFeature(testInfo.getFeatureName());
        startBrowserWebController.abrirTiendaOnline();

        LoginPageController loginPageController = new LoginPageController();
        loginPageController.setWebAction(webAction);
        loginPageController.irAContactUs();

    }
    @Cuando("diligencie el correo de contacto pero no suministre un mensaje")
    public void diligencieElCorreoDeContactoPeroNoSuministreUnMensaje(Map<String,String> dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.

        contactUsMessage = Helper.createContactUsMessage(
                dataTable.get(ContactUsMessageKeys.SUBJECT.getValue()),
                dataTable.get(ContactUsMessageKeys.EMAIL.getValue()),
                dataTable.get(ContactUsMessageKeys.MESSAGE.getValue()));

        contactUsPageController = new ContactUsPageController();
        contactUsPageController.setWebAction(webAction);
        contactUsPageController.definirCuerpoDelMensaje(contactUsMessage);
        contactUsPageController.diligenciarMensajeDeServicioAlCliente();
    }
    @Entonces("se mostrara el error {string}")
    public void seMostraraElError(String mensajeDeError) {
        String mensaje = contactUsPageController.obtenerErrorAlEnviarMensaje();

        Assert.Hard
                .thatString(mensaje)
                .isEqualTo(mensajeDeError);
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
