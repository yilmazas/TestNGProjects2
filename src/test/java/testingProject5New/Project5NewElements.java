package testingProject5New;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Project5NewElements {

    public Project5NewElements(WebDriver driver){
        PageFactory.initElements(driver,this);
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

}
