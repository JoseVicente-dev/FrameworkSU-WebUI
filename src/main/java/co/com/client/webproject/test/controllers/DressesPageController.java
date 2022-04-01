package co.com.client.webproject.test.controllers;

import co.com.client.webproject.test.helpers.Dictionary;
import co.com.client.webproject.test.page.DressesPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class DressesPageController {

    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void adicionarUnProductoAlCarrito(){

        try {
            DressesPage dressesPage = new DressesPage(webAction.getDriver());

            webAction.moveTo(dressesPage.getProductLabelText(),60,true);
            webAction.click(dressesPage.getProductLabelText(),60,true);
            webAction.waitUntilExist(dressesPage.getAddToChartBtn(),60,true);
            webAction.click(dressesPage.getAddToChartBtn(),60,true);
        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al adicionar un producto "+e);
        }
    }

    //For asserts
    public String obtenerContadorDelCarrito(){
        String mensaje= Dictionary.EMPTY_STRING;
        try {
            DressesPage dressesPage = new DressesPage((webAction.getDriver()));
            mensaje = webAction.getText(dressesPage.getAddedProductMessage(),60,true).trim();

        }catch (WebActionsException e){

            Report.reportFailure("Ocurrio un error intentando validar el mensaje de confirmacion "+e);
        }

        return mensaje;
    }
}
