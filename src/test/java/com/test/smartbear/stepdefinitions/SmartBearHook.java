package com.test.smartbear.stepdefinitions;

import io.cucumber.java.Scenario;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.DriverHelper;

public class SmartBearHook {

    WebDriver driver = DriverHelper.getDriver();

    @Before
    public void setup() {
//        driver.get(ConfigReader.readProperty("QA_smartBear_url"));
//        driver.get(ConfigReader.readProperty("googlewebsite"));
        driver.get("https://www.google.com");
    }

    @After
    public void tearDown(Scenario scenario) {
        BrowserUtils.getScreenShotForCucumber(driver, scenario);

        //driver.quit();
    }
}
