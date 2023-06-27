package com.test.smartbear.pages;

import org.junit.Assert;
import utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SmartBearOrderPage {
    public SmartBearOrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#ctl00_MainContent_fmwOrder_ddlProduct")
    WebElement product;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_txtQuantity")
    WebElement quantity;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_txtName")
    WebElement customerName;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox2")
    WebElement street;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox3")
    WebElement city;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox4")
    WebElement state;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox5")
    WebElement zipCode;

    @FindBy(xpath = "//input[@type='radio']")
    List<WebElement> allCards;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox6")
    WebElement cardNumber;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox1")
    WebElement expiration;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_InsertButton")
    WebElement processButton;

    @FindBy(tagName = "strong")
    WebElement message;

    public void productInformation( String productType,String quantity){
        BrowserUtils.selectBy(product,productType,"value");
        this.quantity.sendKeys(quantity);

    }

    public void addressInformation(String customerName, String street, String city, String state, String zipCode){
        this.customerName.sendKeys(customerName);
        this.street.sendKeys(street);
        this.city.sendKeys(city);
        this.state.sendKeys(state);
        this.zipCode.sendKeys(zipCode);
    }

    public void paymentInformation(String cardType, String cardNumber, String expiration){
        for (WebElement card: allCards) {
            if (card.getAttribute("value").equals(cardType)){
                card.click();
            }
        }

        this.cardNumber.sendKeys(cardNumber);
        this.expiration.sendKeys(expiration);

    }

    public void processButton(){
        processButton.click();
    }

    public void confirmationValidation(String expectedMessage){
        Assert.assertEquals(expectedMessage, BrowserUtils.getText(message));
    }

}

