package com.team06.pages;

import com.team06.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OnurUS17Page {
    public OnurUS17Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    //======================LOGIN========================
    @FindBy(xpath = "//*[text()='Hot Products']")
    public WebElement sicakUrunlerBolumu;

    @FindBy(xpath = "//a[text()='Apple iPad Pro (256GB, Wi-Fi + Cellular, Space Gray) 12.9-inch Display']")
    public WebElement secilenUrunLinki;
    //=====================TC01=========================
    //Gerekli Webelement(addToCartButonu) TC07 de mevcut
    // ====================TC02=========================
    @FindBy(xpath = "//a[@class='btn btn-default']")
    public WebElement romKismi32GbLinki;

    @FindBy(xpath = "//img[@title='Gold']")
    public WebElement colorKismiGriRenkLinki;
   // ======================TC03=========================
    @FindBy(xpath = "//a[@class='plus']")
    public WebElement urunSayisiArtirmaLinki;

    @FindBy(xpath = "//a[@class='minus']")
    public WebElement urunSayisiAzaltmaLinki;

    @FindBy(xpath = "//input[@id='buy_quantity']")
    public WebElement urunSayisiGostergesi;
    //========================TC04=========================
    @FindBy(xpath = "//*[text()=' Add to wishlist']")
    public WebElement istekListesineEkleLinki;

    @FindBy(xpath = "//h4[@class='pro_new_head']")
    public WebElement urunSecmeBolumuUrunBasligi;

    @FindBy(xpath = "//a[text()='Apple iPad Pro (256GB, Wi-Fi + Cellular, Space Gray) 12.9-inch Display']")
    public WebElement istekListesiBolumuUrunBasligi;
    //=========================TC05=========================
    @FindBy(xpath = "//*[.='Oops ! Already added to Wishlist']")
    public WebElement mukerrerEklemeYapilamazUyarisi;
    @FindBy(xpath = "//i[@class='fa fa-times']")
    public WebElement istekListesiUrunSilme;
    @FindBy(xpath = "//i[@onclick='onClickAlertMessageClose();']")
    public WebElement mukerrerUyariYazisiKapatma;
    //=========================TC06=========================
    @FindBy(xpath = "//a[@class='btn btn_two form-control padd_btn']")
    public WebElement contactSellerLinki;

    @FindBy(xpath = "//h1[text()='Contact Us ']")
    public WebElement contactUsYazisi;
    //=======================TC07==========================
    @FindBy(xpath = "//input[@value='Add To Cart']")
    public WebElement sepeteUrunEkleButonu;

    @FindBy(xpath = "//*[text()='Your Shopping Cart ']")
    public WebElement alisverisSepetindekiDogrulamaYazisi;
    //=======================TC08-9==========================
    @FindBy(xpath = "//span[text()='Remove']")
    public WebElement sepettekiRemoveButonu;

    @FindBy(xpath = "//*[text()='Product Name']")
    public WebElement sepetteUrunMevcut;

    @FindBy(xpath = "//*[text()='Record Not Found..']")
    public WebElement sepetteUrunBulunamadiYazisi;
    //=======================TC10-11==========================
    @FindBy(xpath = "//button[@name='buynow_submit']")
    public WebElement sepeteSifirdanUrunEkleButonu;
    @FindBy(xpath = "//select[@class='form-control cart_carrier_dropdown_small']")
    public WebElement shippingDropDown;
    //=======================TC12==========================
    @FindBy(xpath = "//a[text()='Buy Now']")
    public WebElement sepettekiSatinAlmaButonu;
    @FindBy(xpath = "//h4[text()='1. Please fill in your shipping information :']")
    public WebElement satinAlmaAdresBilgileriGorundu;
    //=======================TC13==========================
    @FindBy(xpath = "//*[@id='delivery_name']")
    public WebElement fullNameBox;
    @FindBy(xpath = "//*[@id='delivery_mobile']")
    public WebElement mobilNumberBox;
    @FindBy(xpath = "//input[@id='delivery_pin_code']")
    public WebElement postalCodeBox;
    @FindBy(xpath = "//*[@id='delivery_address']")
    public WebElement streetAddressBox;
    @FindBy(xpath = "//*[@id='select_country']")
    public WebElement countryRagionDropDown;
    @FindBy(xpath = "//*[@id='select_state']")
    public WebElement stateRagionDropDown;
    @FindBy(xpath = "//*[@id='select_city']")
    public WebElement cityDropDown;
    @FindBy(xpath = "//*[@id='delivery_address_submit']")
    public WebElement saveShipButonu;
    @FindBy(xpath = "//button[@id='checkout_submit']")
    public WebElement placeOrderButonu;
    @FindBy(xpath = "//h4[text()='Choice Your Payment Option :']")
    public WebElement paymentsSayfaYazisi;
    //=======================TC14==========================
    @FindBy(xpath = "//div/input[@value='PP']")
    public WebElement paypalRadioButton;
    @FindBy(xpath = "//form/input[@value='Continue']")
    public WebElement paymentsContinueButton;
    @FindBy(xpath = "//p[@aria-label='PayPal Logo']")
    public WebElement paypalSitesiLogo;
    //=======================TC15==========================
   @FindBy(xpath = "//div/input[@value='ATH']")
   public WebElement athorizedRadioButton;
   @FindBy(xpath = "//h4[text()='Athorised Payment']")
   public WebElement athorizedDogrulamaYazisi;

















}
