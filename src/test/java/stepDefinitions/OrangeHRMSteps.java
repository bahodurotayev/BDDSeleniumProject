package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRMSteps {
    WebDriver driver;

    @Given("I launch chrome browser")
    public void i_launch_chrome_browser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tjkba\\OneDrive\\Desktop\\drivers\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @When("I open orangeHRM homepage")
    public void i_open_orange_hrm_homepage() {
        driver.get("https://opensource-demo.orangehrmlive.com");
    }

    @Then("I verify the logo is present")
    public void i_verify_the_logo_is_present() throws InterruptedException {
        Thread.sleep(2000);
        boolean displayed = driver.findElement(By.className("orangehrm-login-logo")).isDisplayed();
        Assert.assertEquals(true, displayed);

    }

    @And("Close browser")
    public void close_browser() {
        driver.close();
    }
}
