package stepDefinitions;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pageObject.AddCustomerPage;
import pageObject.LoginPage;
import pageObject.SearchCustomerPage;

import java.util.Properties;


public class BaseClass {
    public WebDriver driver;
    public LoginPage loginPage;
    public AddCustomerPage addCustomer;
    public SearchCustomerPage searchCustomer;
    public static Logger logger;
    public Properties config;

    public static String randomString(){
        String generateStr = RandomStringUtils.randomAlphabetic(5);
        return generateStr + "@bo.com";
    }
}
