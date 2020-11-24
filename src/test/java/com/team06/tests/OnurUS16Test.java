package com.team06.tests;

import com.team06.pages.OnurUS16Page;
import com.team06.utilities.ConfigurationReader;
import com.team06.utilities.Driver;
import com.team06.utilities.TestBase;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class OnurUS16Test extends TestBase {
    OnurUS16Page us16Page = new OnurUS16Page();
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url_login"));
        us16Page.loginEmailKutusu.sendKeys(ConfigurationReader.getProperty("email"));
        us16Page.loginPasswordKutusu.sendKeys(ConfigurationReader.getProperty("password"));
        us16Page.loginButonu.click();
        us16Page.alaaddinLambasiLinki.click();
    }
    @Test
    public void US16TC02(){
        us16Page.urunleriNasilListelerimLinki.click();
        boolean dogrumu = us16Page.urunleriNasilListelerimSayfasiniDogrulama.isDisplayed();
        softAssert.assertTrue(dogrumu);
    }
    @Test
    public void US16TC03(){
        us16Page.sıkSorulanSorularLinki.click();
        boolean dogrumu = us16Page.sıkSorulanSorularSayfasiniDogrulama.isDisplayed();
        softAssert.assertTrue(dogrumu);
    }
    @Test
    public void US16TC04(){
        us16Page.yardimDestekLinki.click();
        boolean dogrumu = us16Page.yardimDestekSayfasiniDogrulama.isDisplayed();
        softAssert.assertTrue(dogrumu);
    }
    @Test
    public void US16TC05(){
        us16Page.alisverisSepetiLinki.click();
        boolean dogrumu = us16Page.alisverisSepetindekiDogrulama.isDisplayed();
        softAssert.assertTrue(dogrumu);
    }
    @Test
    public void US16TC06(){
        us16Page.begenilenUrunlerLinki.click();
        boolean dogrumu = us16Page.begenilenUrunlerBolumundekiDogrulama.isDisplayed();
        softAssert.assertTrue(dogrumu);
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
