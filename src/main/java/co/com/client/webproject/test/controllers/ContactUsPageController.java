package co.com.client.webproject.test.controllers;

import co.com.client.webproject.test.helpers.Dictionary;
import co.com.client.webproject.test.helpers.Seconds;
import co.com.client.webproject.test.model.ContactUsMessage;
import co.com.client.webproject.test.page.ContactUsPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class ContactUsPageController {

    private WebAction webAction;
    private ContactUsMessage contactUsMessage;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void diligenciarMensajeDeServicioAlCliente() {
        try {
            ContactUsPage contactUsPage = new ContactUsPage(webAction.getDriver());
            webAction.selectByText(contactUsPage.getSubject(), contactUsMessage.getSubject(), true);
            webAction.sendText(contactUsPage.getEmail(), contactUsMessage.getEmail(), true);
            if (contactUsMessage.getMessage()!=null){
            webAction.sendText(contactUsPage.getSubjectMessage(), contactUsMessage.getMessage(), true);
            }
            webAction.click(contactUsPage.getSendBtn(), true);
        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrió un error al intentar enviar el mensaje para servicio al cliente " + e);
        }
    }

    public void definirCuerpoDelMensaje(ContactUsMessage contactUsMessage) {
        this.contactUsMessage = contactUsMessage;
    }

    public String obtenerConfirmacionDeMensajeEnviado() {

        String mensaje = Dictionary.EMPTY_STRING;
        try {
            ContactUsPage contactUsPage = new ContactUsPage(webAction.getDriver());
            webAction.waitUntilExist(contactUsPage.getContactMessageSuccessful(), Seconds.THIRTY_SECONDS.getValue(), true);
            mensaje = webAction.getText(contactUsPage.getContactMessageSuccessful(), true).trim();
        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al intentar confirmar que el mensaje de servicio al cliente se envio correctamente " + e);
        }
        return mensaje;
    }

    public String obtenerErrorAlEnviarMensaje() {

        String mensaje = Dictionary.EMPTY_STRING;
        try {
            ContactUsPage contactUsPage = new ContactUsPage(webAction.getDriver());
            webAction.waitUntilExist(contactUsPage.getContactMessageFail(), Seconds.THIRTY_SECONDS.getValue(), true);
            mensaje = webAction.getText(contactUsPage.getContactMessageFail(), true).trim();
        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al intentar obtener una advertencia de que no se puede dejar sin diligenciar el mensaje de servicio al cliente  " + e);
        }
        return mensaje;
    }

}
