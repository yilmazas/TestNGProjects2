package testingProject5New;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Project5NewElements {
    public Project5NewElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "Email")
    public WebElement username;
    @FindBy(id = "Password")
    public WebElement password;
    @FindBy(xpath = "//button[text()='Log in']")
    public WebElement loginButton;
    @FindBy(xpath = "//a[text()='Logout']")
    public WebElement logoutLink;
    @FindBy(xpath = "//ul[@class='nav nav-pills nav-sidebar flex-column nav-legacy']/li")
    public List<WebElement> leftNavMenu;
    @FindBy(xpath = " //p[text()=' Customers']")
    public WebElement customerLink;
    @FindBy(xpath = "/html/body/div[3]/div[1]/form[1]/div/div/a")
    public WebElement addNewCustomer;
    @FindBy(id = "Email")
    public WebElement customerEmail;
    @FindBy(xpath = "(//div[@class='col-md-9'])[5]//input")
    public List<WebElement> genders;
    @FindBy(id = "DateOfBirth")
    public WebElement dateOfBirth;
    @FindBy(id = "Company")
    public WebElement companyName;
    @FindBy(id = "IsTaxExempt")
    public WebElement taxExemption;
    @FindBy(xpath = "(//input[@class='k-input k-readonly'])[1]")
    public WebElement newsletter;
    @FindBy(xpath = "(//select[@id='SelectedNewsletterSubscriptionStoreIds']//option)[1]")
    public WebElement newsletterChoices;
    @FindBy(xpath = "(//input[@class='k-input k-readonly'])[2]")
    public WebElement customerRoles;
    @FindBy(xpath = "//select[@id='SelectedCustomerRoleIds']//option")
    public List<WebElement> customerRolesChoices;
    @FindBy(id = "AdminComment")
    public WebElement adminComment;
    @FindBy(xpath = "(//div[@class='float-right']//button)[1]")
    public WebElement saveButton;
    @FindBy(xpath = "//div[@class='col-md-9']")
    public List<WebElement> customerCreateInputs;
    @FindBy(css = "#SelectedNewsletterSubscriptionStoreIds_listbox>li")
    public List<WebElement> customerCreateNewsletters;
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissable']")
    public WebElement successMessage;
    @FindBy(id = "SearchEmail")
    public WebElement searchEmail;
    @FindBy(id = "SearchLastName")
    public WebElement searchLastName;
    @FindBy(id = "SearchFirstName")
    public WebElement searchFirstname;
    @FindBy(id = "search-customers")
    public WebElement searchCustomerButton;

    @FindBy(xpath = "(//tr[@class='odd']//td)[3]")
    public WebElement searchAssertionCustomerName;

    @FindBy(xpath = "(//table)[2]/tbody/tr/td[3]")
    public List<WebElement> searchAssertionList;

    @FindBy(css = "[class='btn btn-default']")
    public WebElement editCustomerButton;

    @FindBy(id = "FirstName")
    public WebElement firstNameEdit;

    @FindBy(xpath = "//div[@class='content-header clearfix']//span")
    public WebElement deleteButton;

    @FindBy(xpath = "//button[@class='btn btn-danger float-right']")
    public WebElement deleteButtonConfirmation;

    @FindBy(xpath = "//input[@placeholder='Search']")
    public WebElement searchBox;

    @FindBy(xpath = "//strong[@class='tt-highlight']")
    public WebElement searchBoxText;

    @FindBy(xpath = "//h1[@class='float-left']")
    public WebElement shipmentsConfirmation;








}
