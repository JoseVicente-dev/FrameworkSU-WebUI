package co.com.client.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[7]/div/a/i")
    @CacheLookup
    WebElement trashCanIcon;

    @FindBy(xpath = "//*[contains(text(),'Your shopping cart is empty.')]")
    @CacheLookup
    WebElement emptyShoppingCartMessage;


    public WebElement getTrashCanIcon() {
        return trashCanIcon;
    }

    public WebElement getEmptyShoppingCartMessage() {
        return emptyShoppingCartMessage;
    }

    public ShoppingCartPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }
}
