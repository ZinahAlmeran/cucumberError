package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverHelper {
    private static WebDriver driver;

    private DriverHelper(){};
    //I make my constructor private because I don't want anyone to create an object and manipulate my driver
    // from this class

    public static WebDriver getDriver(){

        if(driver == null || ((RemoteWebDriver) driver).getSessionId() == null){

           // String browser ="chrome";

            switch (ConfigReader.readProperty("browser")){

                case "chrome" :
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions option = new ChromeOptions();
                    option.addArguments("--remote-allow-origins=*");
                    driver = new ChromeDriver(option);
                    break;

                case "firefox" :
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                case "edge" :
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;

            }
            driver.manage().window().maximize();
           // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().deleteAllCookies();

        }
        return driver;
    }
}
