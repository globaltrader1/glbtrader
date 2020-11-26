package com.team06.smoketests;

import com.team06.pages.OnurUS16Page;
import com.team06.pages.OnurUS17Page;
import com.team06.utilities.ConfigurationReader;
import com.team06.utilities.Driver;
import com.team06.utilities.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class OnurUS17Test extends TestBase {

    @BeforeMethod
    public void setUp() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("url_login"));
        Thread.sleep(1000);
        OnurUS16Page us16Page = new OnurUS16Page();
        us16Page.loginEmailKutusu.sendKeys(ConfigurationReader.getProperty("email"));
        us16Page.loginPasswordKutusu.sendKeys(ConfigurationReader.getProperty("password"));
        us16Page.loginButonu.click();
        us16Page.alaaddinLambasiLinki.click();
        Actions actions = new Actions(Driver.getDriver());
        OnurUS17Page us17Page = new OnurUS17Page();
        actions.moveToElement(us17Page.sicakUrunlerBolumu);
        Thread.sleep(1000);
        us17Page.secilenUrunLinki.click();

    }

    @Test
    public void US17TC01() {
        SoftAssert softAssert = new SoftAssert();
        OnurUS17Page us17Page = new OnurUS17Page();
        boolean dogrumu = us17Page.istekListesineEkleLinki.isDisplayed();
        softAssert.assertTrue(dogrumu, "Urun satin alma sayfasinda mevcut degil");
        softAssert.assertAll();
    }

    @Test
    public void US17TC02() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        OnurUS17Page us17Page = new OnurUS17Page();
        us17Page.romKismi32GbLinki.click();
        Thread.sleep(1000);
        us17Page.colorKismiGriRenkLinki.click();
        Thread.sleep(1000);
        boolean romDegisikligiGorunduMu = us17Page.romKismi32GbLinki.isDisplayed();
        Assert.assertTrue(romDegisikligiGorunduMu);
        boolean colorDegisikligiGorunduMu = us17Page.colorKismiGriRenkLinki.isDisplayed();
        softAssert.assertTrue(colorDegisikligiGorunduMu);
        softAssert.assertAll();
    }

    @Test
    public void US17TC03() throws InterruptedException {
        OnurUS17Page us17Page = new OnurUS17Page();
        us17Page.urunSayisiArtirmaLinki.click();
        us17Page.urunSayisiArtirmaLinki.click();
        us17Page.urunSayisiArtirmaLinki.click();
        Thread.sleep(1000);

        us17Page.urunSayisiAzaltmaLinki.click();
        us17Page.urunSayisiAzaltmaLinki.click();
        us17Page.urunSayisiAzaltmaLinki.click();
        Thread.sleep(1000);

    }

    @Test
    public void US17TC04() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        OnurUS17Page us17Page = new OnurUS17Page();
        us17Page.istekListesineEkleLinki.click();
        Thread.sleep(1000);
        String urunSecmeBolumuUrunBasligi = us17Page.urunSecmeBolumuUrunBasligi.getText();
        System.out.println(urunSecmeBolumuUrunBasligi);

        Driver.getDriver().get(ConfigurationReader.getProperty("istek_linki"));
        Thread.sleep(1000);
        String istekListesiBolumuUrunBasligi = us17Page.istekListesiBolumuUrunBasligi.getText();
        System.out.println(istekListesiBolumuUrunBasligi);
        softAssert.assertEquals(urunSecmeBolumuUrunBasligi, istekListesiBolumuUrunBasligi);
        softAssert.assertAll();
    }

    @Test
    public void US17TC05() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        OnurUS17Page us17Page = new OnurUS17Page();
        us17Page.romKismi32GbLinki.click();
        Thread.sleep(1000);
        us17Page.colorKismiGriRenkLinki.click();
        Thread.sleep(1000);
        us17Page.istekListesineEkleLinki.click();
        Thread.sleep(1000);
        us17Page.istekListesineEkleLinki.click();
        Thread.sleep(1000);
        String mukerrerEklemeUyarisi = us17Page.mukerrerEklemeYapilamazUyarisi.getText();
        System.out.println(mukerrerEklemeUyarisi);
        softAssert.assertTrue(mukerrerEklemeUyarisi.equals("Oops ! Already added to Wishlist"));
        us17Page.mukerrerUyariYazisiKapatma.click();
        softAssert.assertAll();
    }

    @Test
    public void US17TC06() {
        SoftAssert softAssert = new SoftAssert();
        OnurUS17Page us17Page = new OnurUS17Page();
        us17Page.contactSellerLinki.click();
        System.out.println(us17Page.contactUsYazisi.getText());
        softAssert.assertTrue(us17Page.contactUsYazisi.isDisplayed());
        softAssert.assertAll();
    }

    @Test
    public void US17TC07() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        OnurUS17Page us17Page = new OnurUS17Page();
        us17Page.sepeteUrunEkleButonu.click();
        System.out.println(us17Page.alisverisSepetindekiDogrulamaYazisi.getText());
        softAssert.assertTrue(us17Page.alisverisSepetindekiDogrulamaYazisi.isDisplayed());
        softAssert.assertAll();
        //sepete urun eklendigini gordukten sonra eklenen urunu simdi silmeliyiz
        //Cunku buton degisikliginden dolayi TC08'de hata aliyoruz
        //Sepette hic urun yokken ismi "Buy Now" olan buton
        //eger sepette urun varsa ikinci urunu eklerken "Add To Cart" butonuna donusuyor
        us17Page.sepettekiRemoveButonu.click();
        Alert alert = Driver.getDriver().switchTo().alert();
        Thread.sleep(2000);
        String alertText = alert.getText();
        System.out.println("Alert data: " + alertText);
        alert.accept();
    }

    @Test (dependsOnMethods = "US17TC09") //@Ignore
    public void US17TC08() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        OnurUS17Page us17Page = new OnurUS17Page();
        Thread.sleep(1000);
        us17Page.sepeteUrunEkleButonu.click();
        String sepetteUrunMevcut = us17Page.sepetteUrunMevcut.getText();
        System.out.println(sepetteUrunMevcut);
        Thread.sleep(1000);

        us17Page.sepettekiRemoveButonu.click();

        Alert alert = Driver.getDriver().switchTo().alert();
        Thread.sleep(2000);
        String alertText = alert.getText();
        System.out.println("Alert data: " + alertText);
        alert.dismiss();
        softAssert.assertTrue(us17Page.sepetteUrunMevcut.isDisplayed());
        softAssert.assertAll();
    }
    @Test
    public void US17TC09() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        OnurUS17Page us17Page = new OnurUS17Page();
        Thread.sleep(1000);
        us17Page.sepeteUrunEkleButonu.click();
        String sepetteUrunMevcut = us17Page.sepetteUrunMevcut.getText();
        System.out.println(sepetteUrunMevcut);
        Thread.sleep(1000);

        us17Page.sepettekiRemoveButonu.click();

        Alert alert = Driver.getDriver().switchTo().alert();
        Thread.sleep(2000);
        String alertText = alert.getText();
        System.out.println("Alert data: " + alertText);
        alert.accept();
        softAssert.assertTrue(us17Page.sepetteUrunBulunamadiYazisi.isDisplayed());
        softAssert.assertAll();
    }
    @Test
    public void US17TC10() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        OnurUS17Page us17Page = new OnurUS17Page();
        Thread.sleep(1000);
        us17Page.sepeteUrunEkleButonu.click();

        Select select = new Select(us17Page.shippingDropDown);
        select.selectByIndex(0);

        softAssert.assertTrue(select.getFirstSelectedOption().getText().startsWith("Expres"));
        softAssert.assertAll();

        us17Page.sepettekiRemoveButonu.click();
        Alert alert = Driver.getDriver().switchTo().alert();
        Thread.sleep(2000);
        String alertText = alert.getText();
        System.out.println("Alert data: " + alertText);
        alert.accept();
    }
    @Test
    public void US17TC11() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        OnurUS17Page us17Page = new OnurUS17Page();
        Thread.sleep(1000);
        us17Page.sepeteUrunEkleButonu.click();

        Select select = new Select(us17Page.shippingDropDown);
        select.selectByIndex(1);

        softAssert.assertTrue(select.getFirstSelectedOption().getText().startsWith("Standart"));
        softAssert.assertAll();

        us17Page.sepettekiRemoveButonu.click();
        Alert alert = Driver.getDriver().switchTo().alert();
        Thread.sleep(2000);
        String alertText = alert.getText();
        System.out.println("Alert data: " + alertText);
        alert.accept();
    }
    @Test
    public void US17TC12() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        OnurUS17Page us17Page = new OnurUS17Page();
        Thread.sleep(1000);
        us17Page.sepeteUrunEkleButonu.click();

        us17Page.sepettekiSatinAlmaButonu.click();
        softAssert.assertTrue(us17Page.satinAlmaAdresBilgileriGorundu.isDisplayed());
        softAssert.assertAll();
    }





    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        Driver.closeDriver();
    }
}
