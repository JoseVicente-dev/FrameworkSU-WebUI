package co.com.client.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DressesPage {

    @FindBy(xpath = "/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[2]/a")
    @CacheLookup
    WebElement linkDresses;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[2]/h5/a")
    @CacheLookup
    WebElement productLabelText;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[3]/div[1]/p/button/span")
    @CacheLookup
    WebElement addToChartBtn;


    @FindBy(xpath = "//*[contains(text(),'There is 1 item in your cart.')]")
    @CacheLookup
    WebElement addedProductMessage;

    public WebElement getLinkDresses() {
        return linkDresses;
    }

    public WebElement getAddToChartBtn() {
        return addToChartBtn;
    }

    public WebElement getAddedProductMessage() {
        return addedProductMessage;
    }

    public WebElement getProductLabelText() {
        return productLabelText;
    }

    public DressesPage(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
    }
}
