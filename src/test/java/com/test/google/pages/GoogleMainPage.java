package com.test.google.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.security.Key;
import java.util.List;

public class GoogleMainPage {
    public GoogleMainPage(WebDriver driver){
        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath = "//textarea[@name='q']")
    WebElement searchBar;

    @FindBy(xpath = "//a//h3")
    List<WebElement> allLinks;

    @FindBy(xpath = "//div[@id='result-stats']")
    WebElement result;

    public void searchItem(String item){
        searchBar.sendKeys(item, Keys.ENTER);
    }

    public boolean linksCount(int expectedNum) throws InterruptedException {
        Thread.sleep(2000);
        return allLinks.size()>expectedNum;
    }

    public boolean resultFromSearch(int expectedResult){
        String [] result = BrowserUtils.getText(this.result).split( " ");
        return Integer.parseInt(result[1].replace(",",""))<expectedResult;
    }

    public boolean resultFromSearchLoadingTime(double expectedTime){

        String [] timeResult = BrowserUtils.getText(result).split(" ");
        return Double.parseDouble(timeResult [3].replace("(",""))<expectedTime;
    }

}
