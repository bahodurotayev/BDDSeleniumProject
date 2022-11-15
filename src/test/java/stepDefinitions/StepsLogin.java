package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.LoginPage;

public class StepsLogin {

    public WebDriver driver;
    public LoginPage loginPage;

    @Given("User Launch Chrome browser")
    public void user_launch_chrome_browser() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);

    }

    @When("User open nopCommerce URL {string}")
    public void user_open_nop_commerce_url(String string)  {
            driver.get(string);
    }

    @And("User enters valid credentials as email {string} password {string}")
    public void user_enters_valid_credentials_as_email_password(String email, String password) throws InterruptedException {
        Thread.sleep(2000);
        loginPage.setUsername(email);
        Thread.sleep(2000);
        loginPage.setPassword(password);
    }

    @And("User click Login")
    public void user_click_login() {
        loginPage.clickLogin();
    }

    @Then("Page title should be {string}")
    public void page_title_should_be(String string) throws InterruptedException {
        Thread.sleep(2000);
       if(driver.getPageSource().contains("Login was unsuccessful.")){
           driver.close();
           Assert.assertTrue(false);
       }else {
           Assert.assertEquals(string, driver.getTitle());
       }
    }

    @When("User click on Log out link")
    public void user_click_on_log_out_link() throws InterruptedException {
        Thread.sleep(3000);
        loginPage.clickLogout();
    }

    @Then("close browser")
    public void close_browser() {
        driver.close();
    }

}
