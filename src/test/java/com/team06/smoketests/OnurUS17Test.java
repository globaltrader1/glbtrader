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
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.concurrent.TimeUnit;

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
        softAssert.assertAll();
        us17Page.mukerrerUyariYazisiKapatma.click();

        Driver.getDriver().get(ConfigurationReader.getProperty("istek_linki"));
        Thread.sleep(1000);
        us17Page.istekListesiUrunSilme.click();
        Thread.sleep(1000);
        Driver.getDriver().switchTo().alert().accept();
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
        us17Page.sepeteSifirdanUrunEkleButonu.click();
        System.out.println(us17Page.alisverisSepetindekiDogrulamaYazisi.getText());
        softAssert.assertTrue(us17Page.alisverisSepetindekiDogrulamaYazisi.isDisplayed());
        softAssert.assertAll();
    }

    @Test  //@Ignore
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
        us17Page.sepeteSifirdanUrunEkleButonu.click();

        Select select = new Select(us17Page.shippingDropDown);
        select.selectByIndex(0);

        softAssert.assertTrue(select.getFirstSelectedOption().getText().startsWith("Expres"));
        softAssert.assertAll();
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
    @Test
    public void US17TC13() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        OnurUS17Page us17Page = new OnurUS17Page();
        Thread.sleep(1000);
        us17Page.sepeteUrunEkleButonu.click();
        us17Page.sepettekiSatinAlmaButonu.click();
        us17Page.fullNameBox.clear();
        us17Page.mobilNumberBox.clear();
        us17Page.postalCodeBox.clear();
        us17Page.streetAddressBox.clear();
        us17Page.fullNameBox.sendKeys(ConfigurationReader.getProperty("full_name"));
        us17Page.mobilNumberBox.sendKeys(ConfigurationReader.getProperty("mobile_number"));
        Thread.sleep(1000);
        Select selectCountry = new Select(us17Page.countryRagionDropDown);
        selectCountry.selectByVisibleText(ConfigurationReader.getProperty("country_region"));
        Select selectState = new Select(us17Page.stateRagionDropDown);
        selectState.selectByVisibleText(ConfigurationReader.getProperty("state_province_region"));
        Select selectCity = new Select(us17Page.cityDropDown);
        selectCity.selectByVisibleText(ConfigurationReader.getProperty("city"));

        us17Page.postalCodeBox.sendKeys(ConfigurationReader.getProperty("ZIP_postal_code"));
        us17Page.streetAddressBox.sendKeys(ConfigurationReader.getProperty("street_address"));

        Thread.sleep(1000);
        us17Page.saveShipButonu.click();
        us17Page.placeOrderButonu.click();

        Thread.sleep(1000);
        softAssert.assertTrue(us17Page.paymentsSayfaYazisi.isDisplayed());
        softAssert.assertAll();
    }
    @Test
    public void US17TC14() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        OnurUS17Page us17Page = new OnurUS17Page();
        Thread.sleep(1000);
        us17Page.sepeteUrunEkleButonu.click();
        us17Page.sepettekiSatinAlmaButonu.click();
        us17Page.fullNameBox.clear();
        us17Page.mobilNumberBox.clear();
        us17Page.postalCodeBox.clear();
        us17Page.streetAddressBox.clear();
        us17Page.fullNameBox.sendKeys(ConfigurationReader.getProperty("full_name"));
        us17Page.mobilNumberBox.sendKeys(ConfigurationReader.getProperty("mobile_number"));
        Thread.sleep(1000);
        Select selectCountry = new Select(us17Page.countryRagionDropDown);
        selectCountry.selectByVisibleText(ConfigurationReader.getProperty("country_region"));
        Select selectState = new Select(us17Page.stateRagionDropDown);
        selectState.selectByVisibleText(ConfigurationReader.getProperty("state_province_region"));
        Select selectCity = new Select(us17Page.cityDropDown);
        selectCity.selectByVisibleText(ConfigurationReader.getProperty("city"));

        us17Page.postalCodeBox.sendKeys(ConfigurationReader.getProperty("ZIP_postal_code"));
        us17Page.streetAddressBox.sendKeys(ConfigurationReader.getProperty("street_address"));

        Thread.sleep(1000);
        us17Page.saveShipButonu.click();
        us17Page.placeOrderButonu.click();

        Thread.sleep(1000);
        us17Page.paypalRadioButton.click();
        Thread.sleep(1000);
        softAssert.assertTrue(us17Page.paypalRadioButton.isSelected());
        softAssert.assertAll();
        Thread.sleep(1000);
        us17Page.paymentsContinueButton.click();

        Driver.getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        softAssert.assertTrue(Driver.getDriver().getCurrentUrl().contains("paypal"));
        softAssert.assertAll();
    }
    @Test
    public void US17TC15() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        OnurUS17Page us17Page = new OnurUS17Page();
        Thread.sleep(1000);
        us17Page.sepeteUrunEkleButonu.click();
        us17Page.sepettekiSatinAlmaButonu.click();
        us17Page.fullNameBox.clear();
        us17Page.mobilNumberBox.clear();
        us17Page.postalCodeBox.clear();
        us17Page.streetAddressBox.clear();
        us17Page.fullNameBox.sendKeys(ConfigurationReader.getProperty("full_name"));
        us17Page.mobilNumberBox.sendKeys(ConfigurationReader.getProperty("mobile_number"));
        Thread.sleep(1000);
        Select selectCountry = new Select(us17Page.countryRagionDropDown);
        selectCountry.selectByVisibleText(ConfigurationReader.getProperty("country_region"));
        Select selectState = new Select(us17Page.stateRagionDropDown);
        selectState.selectByVisibleText(ConfigurationReader.getProperty("state_province_region"));
        Select selectCity = new Select(us17Page.cityDropDown);
        selectCity.selectByVisibleText(ConfigurationReader.getProperty("city"));

        us17Page.postalCodeBox.sendKeys(ConfigurationReader.getProperty("ZIP_postal_code"));
        us17Page.streetAddressBox.sendKeys(ConfigurationReader.getProperty("street_address"));

        Thread.sleep(1000);
        us17Page.saveShipButonu.click();
        us17Page.placeOrderButonu.click();

        Thread.sleep(2000);
        us17Page.athorizedRadioButton.click();
        Thread.sleep(2000);
        softAssert.assertTrue(us17Page.athorizedRadioButton.isSelected());
        softAssert.assertAll();

        softAssert.assertTrue(us17Page.athorizedDogrulamaYazisi.isDisplayed());
        softAssert.assertAll();
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        Driver.closeDriver();
    }
    @AfterClass
    public void close() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("url_login"));
        Thread.sleep(1000);
        OnurUS16Page us16Page = new OnurUS16Page();
        OnurUS17Page us17Page = new OnurUS17Page();
        us16Page.loginEmailKutusu.sendKeys(ConfigurationReader.getProperty("email"));
        us16Page.loginPasswordKutusu.sendKeys(ConfigurationReader.getProperty("password"));
        us16Page.loginButonu.click();
        Driver.getDriver().get(ConfigurationReader.getProperty("istek_linki"));
        us17Page.istekListesiUrunSilme.click();
        Driver.getDriver().switchTo().alert().accept();
        Driver.getDriver().get(ConfigurationReader.getProperty("urunsepeti_linki"));
        us17Page.sepettekiRemoveButonu.click();
        Driver.getDriver().switchTo().alert().accept();
        Driver.closeDriver();
    }
}
