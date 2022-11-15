package StepDefinitions;

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
        System.out.println("Given");
    }

    @When("I open orangeHRM homepage")
    public void i_open_orange_hrm_homepage() {
        System.out.println("When");
    }

    @Then("I verify the logo is present")
    public void i_verify_the_logo_is_present() {
        System.out.println("Then");
    }

    @And("Close browser")
    public void close_browser() {
        System.out.println("And");
    }
}
