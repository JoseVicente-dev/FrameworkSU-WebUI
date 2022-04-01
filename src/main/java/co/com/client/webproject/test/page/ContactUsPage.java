package co.com.client.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {

    @FindBy(id="id_contact")
    @CacheLookup
    WebElement subject;

    @FindBy(id="email")
    @CacheLookup
    WebElement email;

    @FindBy(id="message")
    @CacheLookup
    WebElement subjectMessage;

    @FindBy(id="submitMessage")
    @CacheLookup
    WebElement sendBtn;

    @FindBy(xpath = "//*[contains(text(),'Your message has been successfully sent to our team.')]")
    @CacheLookup
    WebElement contactMessageSuccessful;

    @FindBy(xpath = "//*[contains(text(),'The message cannot be blank.')]")
    @CacheLookup
    WebElement contactMessageFail;

    public WebElement getContactMessageFail() {
        return contactMessageFail;
    }

    public WebElement getContactMessageSuccessful() {
        return contactMessageSuccessful;
    }

    public WebElement getSubject() {
        return subject;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getSubjectMessage() {
        return subjectMessage;
    }

    public WebElement getSendBtn() {
        return sendBtn;
    }

    public ContactUsPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }
}
