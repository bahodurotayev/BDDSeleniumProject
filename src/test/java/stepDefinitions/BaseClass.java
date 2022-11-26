package stepDefinitions;

import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import pageObject.AddCustomerPage;
import pageObject.LoginPage;
import pageObject.SearchCustomerPage;

import java.util.Random;

public class BaseClass {
    public WebDriver driver;
    public LoginPage loginPage;
    public AddCustomerPage addCustomer;
    public SearchCustomerPage searchCustomer;

    public static String randomString(){
        String generateStr = RandomStringUtils.randomAlphabetic(5);
        return generateStr + "@bo.com";
    }
}
