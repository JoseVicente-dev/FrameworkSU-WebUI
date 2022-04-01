package co.com.client.webproject.test.controllers;

import co.com.client.webproject.test.helpers.Dictionary;
import co.com.client.webproject.test.helpers.Seconds;
import co.com.client.webproject.test.page.ShoppingCartPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class ShoppingCartPageController {

    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void eliminarProducto(){

        try {
            ShoppingCartPage shoppingCartPage = new ShoppingCartPage(webAction.getDriver());
            webAction.click(shoppingCartPage.getTrashCanIcon(),Seconds.THIRTY_SECONDS.getValue(),true);
        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al intentar eliminar el producto "+e);
        }
    }

    public String obtenerMensajeDeConfirmacion(){
        String mensaje = Dictionary.EMPTY_STRING;

        try {
            ShoppingCartPage shoppingCartPage = new ShoppingCartPage(webAction.getDriver());
            webAction.waitUntilExist(shoppingCartPage.getEmptyShoppingCartMessage(), Seconds.THIRTY_SECONDS.getValue(), true);
            mensaje = webAction.getText(shoppingCartPage.getEmptyShoppingCartMessage(),Seconds.THIRTY_SECONDS.getValue(),true).trim();

        }catch (WebActionsException e){
            Report.reportFailure("Ocurrió un error al intentar validar el mensaje de eliminacion del producto "+e);
        }

        return mensaje;
    }
}
