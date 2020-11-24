package com.team06.pages;

import com.team06.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OnurUS16Page {
    public OnurUS16Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    //==================LOGIN=======================
    @FindBy(xpath= "//input[@id='email']")
    public WebElement loginEmailKutusu;

    @FindBy(xpath= "//input[@id='password']")
    public WebElement loginPasswordKutusu;

    @FindBy(xpath= "//button[@name='submit']")
    public WebElement loginButonu;

    @FindBy(xpath = "//img[@class='img-responsive text-center_xs']")
    public WebElement alaaddinLambasiLinki;
    //==================16TC02=======================
    @FindBy(partialLinkText = "How Can I list my products?")
    public WebElement urunleriNasilListelerimLinki;

    @FindBy(xpath = "//span[text()='How Can I list my products in Glbtrader.com?']")
    public WebElement urunleriNasilListelerimSayfasiniDogrulama;
    //==================16TC03=======================
    @FindBy(xpath = "//a[text()='Frequently Asked Questions']")
    public WebElement sıkSorulanSorularLinki;

    @FindBy(xpath = "//h1")
    public WebElement sıkSorulanSorularSayfasiniDogrulama;
    //==================16TC04=======================
    @FindBy(partialLinkText = "HELP&SUPPORT")
    public WebElement yardimDestekLinki;

    @FindBy(tagName = "h1")
    public WebElement yardimDestekSayfasiniDogrulama;
    //==================16TC05=======================
    @FindBy(xpath = "//a[@class='gray']")
    public WebElement alisverisSepetiLinki;

    @FindBy(xpath = "//*[text()='Your Shopping Cart ']")
    public WebElement alisverisSepetindekiDogrulama;
    //==================16TC06=======================
    @FindBy(xpath = "//a[@class='red']")
    public WebElement begenilenUrunlerLinki;

    @FindBy(xpath = "//*[.='My Wishlist']")
    public WebElement begenilenUrunlerBolumundekiDogrulama;
















}
