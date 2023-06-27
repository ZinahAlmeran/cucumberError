package com.test.smartbear.stepdefinitions;
import com.test.smartbear.pages.SmartBearLoginPage;
import com.test.smartbear.pages.SmartBearMainPage;
import com.test.smartbear.pages.SmartBearOrderPage;
import com.test.smartbear.pages.SmartBearViewAllOrdersPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class SmartBearOrderPageStepDef {

    WebDriver driver= DriverHelper.getDriver();
    SmartBearLoginPage smartBearLogin=new SmartBearLoginPage(driver);
    SmartBearMainPage smartBearMainPage=new SmartBearMainPage(driver);
    SmartBearOrderPage smartBearOrderPage=new SmartBearOrderPage(driver);
    SmartBearViewAllOrdersPage smartBearViewAllOrdersPage = new SmartBearViewAllOrdersPage(driver);

    @Given("User provides login information of username and password for SmartBear login")
    public void user_provides_login_information_of_username_and_password_for_smart_bear_login()  {
        smartBearLogin.smartBearLoginPage(ConfigReader.readProperty("QA_smartBear_username"),ConfigReader.readProperty("QA_smartBear_password"));
    }
    @When("User clicks order button and selects the product {string} and Quantity {string} for Product Information")
    public void user_clicks_order_button_and_selects_the_product_and_quantity_for_product_information(String product, String Quantity) {
        smartBearMainPage.orderTabClick();
        smartBearOrderPage.productInformation(product,Quantity);

    }
    @When("User provides Customer Name {string},Street {string}, city {string}, state {string} and zipCode {string} for addressInformation")
    public void user_provides_customer_name_street_city_state_and_zip_code_for_address_information(String name, String street, String city, String state, String zipCode) {
        smartBearOrderPage.addressInformation(name, street, city, state, zipCode);
    }

    @When("User selects the card Type {string}, provides the card Number {string} and expiration date {string} for payment information")
    public void user_selects_the_card_type_provides_the_card_number_and_expiration_date_for_payment_information(String cardType, String cardNumber, String expiration) {
        smartBearOrderPage.paymentInformation(cardType, cardNumber, expiration);

    }
    @When("User clicks the Process button")
    public void user_clicks_the_process_button() {
        smartBearOrderPage.processButton();

    }
    @Then("User validates the confirmation Message {string} and clicks view all orders")
    public void user_validates_the_confirmation_message_and_clicks_view_all_orders (String expectedMessage) {
        smartBearOrderPage.confirmationValidation(expectedMessage);
        smartBearMainPage.viewAllOrdersTabClick();

    }

    @Then("User validated order information name {string}, product {string}, quantity {string}, date {string}, street {string}, city {string}, state {string}, zipCode {string}, card {string}, card number {string} and expiration {string}")
    public void user_validated_order_information_name_product_quantity_date_street_city_state_zip_code_card_card_number_and_expiration(String name, String product, String quantity, String date,
                                                                                                                                       String street, String city, String state, String zipCode, String card,
                                                                                                                                       String cardNumber, String expiration) {
        smartBearViewAllOrdersPage.orderInfoConfirmation(name, product, quantity, date, street, city, state, zipCode, card, cardNumber, expiration);
    }

}
