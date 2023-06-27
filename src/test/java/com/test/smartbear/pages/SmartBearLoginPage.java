package com.test.smartbear.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SmartBearLoginPage {

    public SmartBearLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#ctl00_MainContent_username")
    WebElement username;

    @FindBy(css = "#ctl00_MainContent_password")
    WebElement password;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement login;

    public void smartBearLoginPage(String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        login.click();
    }
}
