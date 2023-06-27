package com.test.etsy.stepdefinitions;

import com.test.etsy.pages.EtsyMainPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class EtsySearchStepDef {

    WebDriver driver = DriverHelper.getDriver();
    EtsyMainPage etsyMainPage = new EtsyMainPage(driver);
    @When("user searches for {string} in Etsy")
    public void user_searches_for_in_etsy(String item) {
     etsyMainPage.itemSearch(item);
    }
    @Then("user validates the title {string} from Etsy")
    public void user_validates_the_title_from_etsy(String expectedTitle) {
        Assert.assertEquals(expectedTitle,driver.getTitle().trim());
    }

}
