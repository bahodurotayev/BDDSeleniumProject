package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitHelper;

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

    @FindBy(how = How.XPATH, using = "//table[@id='customer-grid']")
    @CacheLookup
    WebElement tblSearchResults;
}
