package com.test.weborder.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class FoodOrderPage {

    public FoodOrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//label[@for='GroupOrder']")
    WebElement checkBox;

    @FindBy(css = "#getAddressNextButton")
    WebElement nextButton;

    @FindBy(css = "#InviteNote")
    WebElement noteMsg;

    @FindBy(css = "#InviteList")
    WebElement inviteList;

    @FindBy(css = "#ConfirmAddressID")
    WebElement location;

    @FindBy(css = "#addressPreview")
    WebElement address;

    @FindBy(css = "#createGroupOrder")
    WebElement groupOrderButton;

    @FindBy(tagName = "h1")
    WebElement header;

    @FindBy(xpath = "//div//p")
    WebElement description;


    public void orderPageCheckBoxFunctionality(){

        if (checkBox.isDisplayed() && checkBox.isEnabled() && !checkBox.isSelected()) {
            checkBox.click();
        }
    }

    public void orderPageFunctionality(String note,String emails,String location) throws InterruptedException {

        nextButton.click();
        Thread.sleep(2000);
        noteMsg.sendKeys(note);
        inviteList.sendKeys(emails);
        BrowserUtils.selectBy(this.location,"text",location);
    }
    public void orderPageAddressValidation(String expectedAddress) throws InterruptedException {

        Assert.assertTrue(BrowserUtils.getText(address).contains(expectedAddress));
        groupOrderButton.click();
        Thread.sleep(2000);

    }
    public void orderPageValidations(String expectedHeader,String expectedDescription){

        Assert.assertEquals(expectedHeader,BrowserUtils.getText(header));
        Assert.assertTrue(BrowserUtils.getText(description).contains(expectedDescription));
    }

}
