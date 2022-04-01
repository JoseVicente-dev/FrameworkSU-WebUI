package co.com.client.webproject.test.stepdefinition;
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

public class EliminarProductoStepsDefinition {

    @Dado("que como cliente regitrado estoy en la zona de compras de vestidos")
    public void queComoClienteRegitradoEstoyEnLaZonaDeComprasDeVestidos() {
    }
    @Dado("he añadido un producto a mi carrito de compras")
    public void heAñadidoUnProductoAMiCarritoDeCompras() {
    }
    @Cuando("cambie de opinión y elimine el producto del carrito")
    public void cambieDeOpiniónYElimineElProductoDelCarrito() {
    }
    @Entonces("se mostrara un mensaje que me indica {string}")
    public void seMostraraUnMensajeQueMeIndica(String string) {
    }
}
