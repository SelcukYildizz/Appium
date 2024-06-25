package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class CurrencyConverterPage {

    public CurrencyConverterPage() {
        PageFactory.initElements((WebDriver) Driver.getAndroidDriver(), this);
    }

    @FindBy(xpath = "//*[@text='CURRENCY CONVERTER']")
    public WebElement homePageText;

    @FindBy(xpath = "//*[@resource-id='com.smartwho.SmartAllCurrencyConverter:id/SpinnerCurrencyA']")
    public WebElement firstCurrencyDropDown;

    @FindBy(xpath = "//*[@resource-id='com.smartwho.SmartAllCurrencyConverter:id/SpinnerCurrencyB']")
    public WebElement secondCurrencyDropDown;

    @FindBy(xpath = "//*[@text='1']")
    public WebElement digitOne;

    @FindBy(xpath = "//*[@text='0']")
    public WebElement digitZero;

    @FindBy(xpath = "(//*[@class='android.widget.TextView'])[10]")
    public WebElement resultCurrency;


}