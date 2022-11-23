package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.AddCustomerPage;
import pageObject.LoginPage;

public class StepsLogin extends BaseClass{



    @Given("User Launch Chrome browser")
    public void user_launch_chrome_browser() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);

    }

    @When("User open nopCommerce URL {string}")
    public void user_open_nop_commerce_url(String string)  {
            driver.get(string);
            driver.manage().window().maximize();
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


                                                                                             // Customer feature stepsDef

    @Then("User can view Dashboard")
    public void user_can_view_dashboard() {
        addCustomer = new AddCustomerPage(driver);
        String pageTitle = addCustomer.getPageTitle();
        Assert.assertEquals("Dashboard / nopCommerce administration",pageTitle);
    }
    @When("User click on customers Menu")
    public void user_click_on_customers_menu() {
    addCustomer.clickCustomerMenu();
    }
    @And("User click on customers Menu Item")
    public void user_click_on_customers_menu_item() throws InterruptedException {
        Thread.sleep(1000);
    addCustomer.click_customerMenu_customer();
    }
    @And("User click on Add new button")
    public void user_click_on_add_new_button() {
    addCustomer.click_addNew();
    }
    @Then("User can view Add new customer page")
    public void user_can_view_add_new_customer_page() {
    Assert.assertEquals("Add a new customer / nopCommerce administration", addCustomer.getPageTitle());
    }
    @When("User enter customer info")
    public void user_enter_customer_info() throws InterruptedException {
        String email = BaseClass.randomString();

        addCustomer.setEmail(email);
        addCustomer.setPassword("Main123");
        addCustomer.setTextFirstName("Bob");
        addCustomer.setTextLastName("Rayn");
        addCustomer.selectGender("Female");
        addCustomer.selectDOB("07/12/1994");
        addCustomer.setCompanyName("Exelenter");
        addCustomer.selectIsTaxExempt();
        //addCustomer.clickNewsLetter();
        addCustomer.setCustomerRole();


    }
    @And("User click on Save button")
    public void user_click_on_save_button() throws InterruptedException {
        Thread.sleep(2000);
        addCustomer.clickSaveButton();
    }
    @Then("User can view confirmation message {string}")
    public void user_can_view_confirmation_message(String string) {

    }


}
