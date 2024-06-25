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

        //page.firstCurrencyDropDown.click();
        //ReusableMethods.dropDownKaydırma("PLN");
        //ReusableMethods.wait(2);

        // 2. Yontem

        page.firstCurrencyDropDown.click();
        ReusableMethods.scrollWithUiScrollableAndClick("PLN");




// cevirelecek olan para birimi Tl olarak secilir

        page.secondCurrencyDropDown.click();
        ReusableMethods.scrollWithUiScrollableAndClick("TRY");


// 100 PLN girilir

        page.digitOne.click();
        for (int i = 0; i < 2; i++) {
             page.digitZero.click();
        }

        // Ekran goruntusu al.

        //1. Yöntem, basit olan.

        //File screenshot = driver.getScreenshotAs(OutputType.FILE);
        //FileUtils.copyFile(screenshot,new File("screenshot.jpg"));

        //2. Yontem, methodlaşmış olan

        ReusableMethods.getScreenshot("Selcuk");

// Ardindan zloty nin tl karsiligi olan tl degeri kaydedilir

        String zlotyValue = page.resultCurrency.getText();




// kullaniciya sms olarak bildirilir

        driver.sendSMS("555555555","100 PLN'nin degeri" + zlotyValue);







    }





}
