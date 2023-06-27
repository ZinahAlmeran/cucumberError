package com.test.weborder.stepdefinitions;

import com.test.weborder.pages.WebOrderLoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class LoginStepDef {

    WebDriver driver = DriverHelper.getDriver();
    WebOrderLoginPage webOrderLoginPage = new WebOrderLoginPage(driver);


    @When("The user provides the {string} , {string} and clicks on sign in button")
    public void the_user_provides_the_and_clicks_on_sign_in_button(String username, String password) {

        webOrderLoginPage.loginPageFunctionality(username,password);
    }
    @Then("The user validates the {string}")
    public void the_user_validates_the(String expectedTitle) {

        Assert.assertEquals(expectedTitle,driver.getTitle().trim());
    }

    @Then("The user validates the message {string}")
    public void the_user_validates_the_message(String expectedMsg) {
        Assert.assertEquals(expectedMsg,webOrderLoginPage.errorMessage());
    }

}
