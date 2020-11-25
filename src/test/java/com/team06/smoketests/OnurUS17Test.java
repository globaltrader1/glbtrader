package com.team06.smoketests;

import com.team06.pages.OnurUS16Page;
import com.team06.pages.OnurUS17Page;
import com.team06.utilities.ConfigurationReader;
import com.team06.utilities.Driver;
import com.team06.utilities.TestBase;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
        OnurUS17Page us17Page = new OnurUS17Page();
        boolean dogrumu = us17Page.istekListesineEkleLinki.isDisplayed();
        Assert.assertTrue(dogrumu, "Urun satin alma sayfasinda mevcut degil");
    }
    @Test
    public void US17TC02() throws InterruptedException {
        OnurUS17Page us17Page = new OnurUS17Page();
        us17Page.romKismi32GbLinki.click();
        Thread.sleep(1000);
        us17Page.colorKismiGriRenkLinki.click();
        Thread.sleep(1000);
        boolean romDegisikligiGorunduMu = us17Page.romKismi32GbLinki.isDisplayed();
        Assert.assertTrue(romDegisikligiGorunduMu);
        boolean colorDegisikligiGorunduMu = us17Page.colorKismiGriRenkLinki.isDisplayed();
        Assert.assertTrue(colorDegisikligiGorunduMu);
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
        OnurUS17Page us17Page = new OnurUS17Page();
        us17Page.istekListesineEkleLinki.click();
        Thread.sleep(1000);
        String urunSecmeBolumuUrunBasligi = us17Page.urunSecmeBolumuUrunBasligi.getText();
        System.out.println(urunSecmeBolumuUrunBasligi);

        Driver.getDriver().get(ConfigurationReader.getProperty("istek_linki"));
        Thread.sleep(1000);
        String istekListesiBolumuUrunBasligi = us17Page.istekListesiBolumuUrunBasligi.getText();
        System.out.println(istekListesiBolumuUrunBasligi);
        Assert.assertEquals(urunSecmeBolumuUrunBasligi,istekListesiBolumuUrunBasligi);
    }
    @Test
    public void US17TC05() throws InterruptedException {
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
            Assert.assertTrue(mukerrerEklemeUyarisi.equals("Oops ! Already added to Wishlist"));
            us17Page.mukerrerUyariYazisiKapatma.click();
    }
    @Test
    public void US17TC06(){
        OnurUS17Page us17Page = new OnurUS17Page();
        us17Page.contactSellerLinki.click();
        System.out.println(us17Page.contactUsYazisi.getText());
        Assert.assertTrue(us17Page.contactUsYazisi.isDisplayed());
    }
    @Test
    public void US17TC07(){
        OnurUS17Page us17Page = new OnurUS17Page();
        us17Page.addToCartButonu.click();
        System.out.println(us17Page.alisverisSepetindekiDogrulama.getText());
        Assert.assertTrue(us17Page.alisverisSepetindekiDogrulama.isDisplayed());
    }


















    @AfterMethod
    public void tearDown() throws InterruptedException {

        Driver.closeDriver();
    }
}
