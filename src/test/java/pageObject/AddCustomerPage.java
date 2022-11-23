package pageObject;

import io.cucumber.java.eo.Se;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {

    public WebDriver ldriver;

    public AddCustomerPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(ldriver, this);
    }

    By customer_menu = By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/a");
    By customerMenu_customer = By.xpath("//a[@href='/Admin/Customer/List']/p");
    By addNew = By.xpath("//a[@class='btn btn-primary']");
    By textEmail = By.xpath("//input[@id='Email']");
    By txtPassword = By.xpath("//input[@name='Password']");
    By textFirstName = By.xpath("//input[@name='FirstName']");
    By textLastName = By.xpath("//input[@name='LastName']");

    By male_Gender = By.xpath("//input[@id='Gender_Male']");
    By female_Gender = By.xpath("//input[@id='Gender_Female']");

    By date_of_birth = By.xpath("//input[@id='DateOfBirth']");
    By company_name = By.xpath("//input[@id='Company']");
    By is_tax_exempt = By.xpath("//input[@id='IsTaxExempt']");

    By news_letter = By.xpath("//select[@name='SelectedNewsletterSubscriptionStoreIds']");


    By select_customer_role = By.cssSelector("select#SelectedCustomerRoleIds");
    By customer_role_administrations = By.xpath("//select[@id='SelectedCustomerRoleIds']//option[@value='1']");
    By customer_role_forum_moderate = By.xpath("//select[@id='SelectedCustomerRoleIds']//option[@value='2']");
    By customer_role_registered = By.xpath("//select[@id='SelectedCustomerRoleIds']//option[@value='3']");
    By customer_role_guest = By.xpath("//select[@id='SelectedCustomerRoleIds']//option[@value='4']");
    By customer_role_vendors = By.xpath("//select[@id='SelectedCustomerRoleIds']//option[@value='5']");

    By select_manager_vendorp_dropDown = By.id("VendorId");
    By active = By.id("Active");
    By admin_comment = By.id("AdminComment");

    By button_save = By.xpath("//button[@name='save']");
    By button_save_continueEdit = By.xpath("//button[@name='save-continue']");

    public void clickCustomerMenu(){
        ldriver.findElement(customer_menu).click();
    }
    public void click_customerMenu_customer(){
        ldriver.findElement(customerMenu_customer).click();
    }
    public void click_addNew(){
        ldriver.findElement(addNew).click();
    }
    public void setEmail(String email){
        ldriver.findElement(textEmail).sendKeys(email);
    }
    public void setPassword(String password){
        ldriver.findElement(txtPassword).sendKeys(password);
    }

    public void setTextFirstName(String firstName){
        ldriver.findElement(textFirstName).sendKeys(firstName);
    }
    public void setTextLastName(String lastName){
        ldriver.findElement(textLastName).sendKeys(lastName);
    }

    public void selectGender(String gender){
    if (gender.equals("Male")){
        ldriver.findElement(male_Gender).click();
    }else if (gender.equals("Female")){
        ldriver.findElement(female_Gender).click();
        }
    }
    public void selectDOB(String dateOfBirth){
        ldriver.findElement(date_of_birth).sendKeys(dateOfBirth);
    }
    public void setCompanyName(String companyName){
        ldriver.findElement(company_name).sendKeys(companyName);
    }
    public void selectIsTaxExempt(){
        ldriver.findElement(is_tax_exempt).click();
    }
    public void setCustomerRole(){

        Select selectCustomerRoleDropDown = new Select((WebElement) select_customer_role);
        selectCustomerRoleDropDown.selectByIndex(3);
    }

    public void selectManagerVendor(String value){
        Select managerVendorDropDown = new Select(ldriver.findElement(select_manager_vendorp_dropDown));
        managerVendorDropDown.selectByVisibleText(value);
    }

    public void selectActive(){
        ldriver.findElement(active).click();
    }
    public void setAdminComment(String comment){
        ldriver.findElement(admin_comment).sendKeys(comment);
    }
    public void clickSaveButton(){
        ldriver.findElement(button_save).click();
    }
    public void clickSaveContinueButton(){
        ldriver.findElement(button_save_continueEdit).click();
    }
    public String getPageTitle(){
        return ldriver.getTitle();
    }
    public void clickNewsLetter() throws InterruptedException {
        Thread.sleep(1000);
        Select selectNewsLetter = new Select(ldriver.findElement(By.xpath("//select[@name='SelectedNewsletterSubscriptionStoreIds']")));
        Thread.sleep(1000);
        selectNewsLetter.selectByIndex(1);
        }
}
