package com.test.weborder.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class WebOrderLoginPage {

    public WebOrderLoginPage (WebDriver driver){
        PageFactory.initElements(driver,this);

    }

    @FindBy(css = "#Email")
    WebElement userName;

    @FindBy(css = "#Password")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement signInButton;

    @FindBy(xpath = "//div[@class='mt-2 alert alert-danger']")
    WebElement message;

    public void loginPageFunctionality(String user,String pass){

        userName.clear();
        userName.sendKeys(user);
        password.clear();
        password.sendKeys(pass);
        signInButton.click();

    }

    public String errorMessage(){
        return BrowserUtils.getText(message);

    }
}
