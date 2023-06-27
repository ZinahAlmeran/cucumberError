package com.test.weborder.stepdefinitions;

import com.test.weborder.pages.FoodOrderPage;
import com.test.weborder.pages.WebOrderLoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class FoodOrderStepDef {

    WebDriver driver = DriverHelper.getDriver();
    WebOrderLoginPage webOrderLoginPage = new WebOrderLoginPage(driver);
    FoodOrderPage foodOrderPage = new FoodOrderPage(driver);

    @When("The user provides the username , password, clicks on sign in button and go to food order page")
    public void the_user_provides_the_username_password_clicks_on_sign_in_button_and_go_to_food_order_page()  {

        webOrderLoginPage.loginPageFunctionality(ConfigReader.readProperty("webOrder_userName"),ConfigReader.readProperty("webOrder_password"));
    }
    @Then("The user validates the group order checkbox functionality")
    public void the_user_validates_the_group_order_checkbox_functionality(){
        foodOrderPage.orderPageCheckBoxFunctionality();

    }
    @Then("The user clicks on the next button, provides the note {string} to invitees,emails {string} to invite list and select the delivery location {string}")
    public void the_user_clicks_on_the_next_button_provides_the_note_to_invitees_emails_to_invite_list_and_select_the_delivery_location(String note, String emails, String location) throws InterruptedException {
        foodOrderPage.orderPageFunctionality(note, emails, location);
    }

    @Then("The user validates the home address {string} and clicks create group order button")
    public void the_user_validates_the_home_address_and_clicks_create_group_order_button(String expectedAddress) throws InterruptedException {
           foodOrderPage.orderPageAddressValidation(expectedAddress);
    }
        @Then("The user validates the header {string} and description {string}")
        public void the_user_validates_the_header_and_description( String expectedHeader, String expectedDescription){
        foodOrderPage.orderPageValidations(expectedHeader,expectedDescription);

    }


}
