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

    @FindBy(xpath = "//i[@onclick='onClickAlertMessageClose();']")
    public WebElement mukerrerUyariYazisiKapatma;
    //=========================TC06=========================
    @FindBy(xpath = "//a[@class='btn btn_two form-control padd_btn']")
    public WebElement contactSellerLinki;

    @FindBy(xpath = "//h1[text()='Contact Us ']")
    public WebElement contactUsYazisi;
    //=======================TC07==========================
    @FindBy(xpath = "//input[@value='Add To Cart']")
    public WebElement addToCartButonu;

    @FindBy(xpath = "//*[text()='Your Shopping Cart ']")
    public WebElement alisverisSepetindekiDogrulama;
    //=======================TC08==========================
    @FindBy(xpath = "//a[@onclick=\"return confirm('Do You  want to delete ?');\"]")
    public WebElement istekListesiRemoveButonu;

    //=======================TC09==========================

    //=======================TC10==========================

    //=======================TC11==========================

    //=======================TC12==========================

    //=======================TC14==========================

    //=======================TC15==========================

    //=======================TC16==========================


















}
