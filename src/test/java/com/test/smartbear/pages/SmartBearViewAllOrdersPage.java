package com.test.smartbear.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class SmartBearViewAllOrdersPage {

    public SmartBearViewAllOrdersPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//tr[2]//td")
    List<WebElement> actualOrderInfo;

    public void orderInfoConfirmation(String name, String product, String quantity, String date,
                                      String street, String city, String state, String zipCode, String card,
                                      String cardNumber, String expiration){

        List<String> expectedOrderInfo = Arrays.asList("",name,product,quantity,date,street,city,state,
                zipCode,card,cardNumber,expiration,"");

        for (int i = 1; i < actualOrderInfo.size() - 1; i++) {
            Assert.assertEquals(BrowserUtils.getText(actualOrderInfo.get(i)), expectedOrderInfo.get(i));

        }
    }

}
