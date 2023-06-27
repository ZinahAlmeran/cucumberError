package com.test.google.stepdefinitions;

import com.test.google.pages.GoogleMainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.BrowserUtils;
import utils.DriverHelper;

public class SearchStepParametersDef {

    WebDriver driver = DriverHelper.getDriver();
    GoogleMainPage googleMainPage = new GoogleMainPage(driver);

    @Given("User navigate to the {string}")
    public void user_navigate_to_the(String website) {
        driver.get(website);
    }
    @When("User searches for {string}")
    public void user_searches_for(String searchItem) {
        googleMainPage.searchItem(searchItem);
    }
    @Then("User validates first page returns more than {int} links")
    public void user_validates_first_page_returns_more_than_links(Integer expectedLink) throws InterruptedException {
        Assert.assertTrue(googleMainPage.linksCount(expectedLink));
    }

    @Then("User validates the result is less than {int}")
    public void user_validates_the_result_is_less_than(Integer expectedResult) {
        Assert.assertTrue(googleMainPage.resultFromSearch(expectedResult));
    }

    @Then("User validates the result loads in less than {double} second")
    public void user_validates_the_result_loads_in_less_than_second(Double expectedTime) {
        Assert.assertTrue(googleMainPage.resultFromSearchLoadingTime(expectedTime));
    }


}
