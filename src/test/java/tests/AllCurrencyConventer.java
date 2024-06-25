package tests;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.commons.io.FileUtils;
import org.aspectj.weaver.ast.And;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CurrencyConverterPage;
import utils.ConfigReader;
import utils.Driver;
import utils.ReusableMethods;

import java.io.File;
import java.io.IOException;

public class AllCurrencyConventer {

    AndroidDriver<AndroidElement> driver = Driver.getAndroidDriver();
    CurrencyConverterPage page = new CurrencyConverterPage();




    @Test
    public void allCurrencyTest() throws IOException {

// all currency uygulamasinin yuklendigi dogulanir

      Assert.assertTrue(driver.isAppInstalled(ConfigReader.getProperty("allCurrencyPackage")));

// uygulamanin acildigi dogrulanir

      Assert.assertTrue(page.homePageText.isDisplayed());

// cevirmek istedigimiz para birimi zloty olarak secilir

        page.firstCurrencyDropDown.click();
        ReusableMethods.dropDownKaydırma("PLN");
        ReusableMethods.wait(2);




// cevirelecek olan para birimi Tl olarak secilir

        ReusableMethods.dropDownKaydırma("TRY");
        ReusableMethods.wait(2);


// cevrilen tutar screenShot olarak kaydedilir

        page.digitOne.click();
        page.digitZero.click();
        page.digitZero.click();

  ReusableMethods.getScreenshot("PLN-TRY");


// Ardindan zloty nin tl karsiligi olan tl degeri kaydedilir

        String zlotyValue = page.resultCurrency.getText();




// kullaniciya sms olarak bildirilir

        driver.sendSMS("555555555","100 PLN'nin degeri" + zlotyValue);







    }





}
