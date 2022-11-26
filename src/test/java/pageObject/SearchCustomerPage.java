package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitHelper;

import java.util.List;

public class SearchCustomerPage {
    public WebDriver ldriver;
    public WaitHelper waitHelper;

    public SearchCustomerPage(WebDriver rdriver){
        ldriver = rdriver;
        PageFactory.initElements(ldriver,this);
        waitHelper = new WaitHelper(ldriver);
    }

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Search')]")
    @CacheLookup
    WebElement search;

    @FindBy(how = How.CSS, using = "input#SearchEmail")
    @CacheLookup
    WebElement emailSearch;

    @FindBy(how = How.CSS, using = "input#SearchFirstName")
    @CacheLookup
    WebElement nameSearch;

    @FindBy(how = How.CSS, using ="input#SearchLastName")
    @CacheLookup
    WebElement lastNameSearch;

    @FindBy(how = How.CSS, using = "button#search-customers")
    @CacheLookup
    WebElement buttonSearch;

    @FindBy(how = How.XPATH, using = "//table[@role='grid']")
    @CacheLookup
    WebElement tblSearchResults;

    @FindBy(how = How.XPATH, using = "//table[@id='customers-grid']")
    @CacheLookup
    WebElement table;

    @FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody/tr")
    @CacheLookup
    List<WebElement> tableRows;

    @FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody/tr/td")
    @CacheLookup
    List<WebElement> tableColumns;

    public void setEmail(String email){
        waitHelper.waitForElement(emailSearch, 50);
        emailSearch.clear();
        emailSearch.sendKeys(email);
    }
    public void setNameSearch(String name){
        waitHelper.waitForElement(nameSearch, 50);
        nameSearch.clear();
        nameSearch.sendKeys(name);
    }
    public void setLastNameSearch(String lastName){
        waitHelper.waitForElement(lastNameSearch, 50);
        lastNameSearch.clear();
        lastNameSearch.sendKeys(lastName);
    }
    public void clickSearch(){
        waitHelper.waitForElement(buttonSearch,30);
        buttonSearch.click();
    }
    public int getNumberOfRows(){
        return (tableRows.size());
    }
    public int getNumberOfColumns(){
        return (tableColumns.size());
    }

    public boolean searchCustomerByEmail(String email){
        boolean flag = false;
        for (int i = 0; i < getNumberOfRows(); i++) {
            String emailId = table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr[" + i + "]/td[2]")).getText();
            System.out.println(emailId);
            if (emailId.equals(email)){
                flag = true;
            }
        }
        return flag;
    }

}
