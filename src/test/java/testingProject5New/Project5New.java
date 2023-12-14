package testingProject5New;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BaseDriverParameter;

public class Project5New extends BaseDriverParameter {


   @Test(priority = 1)
    public void loginTest() {

        driver.get("https://admin-demo.nopcommerce.com/login?");

       // paralel testlerde element class'inin objesi her test icerisinde ayri ayri olusturulmali. bu sekilde yapmayinca
       //driverlar karisiyor
        Project5NewElements elements = new Project5NewElements(driver);

        elements.username.clear();
        elements.username.sendKeys("admin@yourstore.com");

        elements.password.clear();
        elements.password.sendKeys("admin");

        elements.loginButton.click();

        Assert.assertTrue(elements.logoutLink.isDisplayed());
    }


    @Test(priority = 2,dependsOnMethods = "loginTest")
    public void checkLeftNavMenu(){
       // paralel testlerde element class'inin objesi her test icerisinde ayri ayri olusturulmali
       Project5NewElements elements = new Project5NewElements(driver);
        JavascriptExecutor js=(JavascriptExecutor) driver;

        /* Test Case 2: Check LeftNaw Menu
➢ Dashboardun altındaki menülere tek tek tıklatın.
➢ Menülerin açılıp açılmadığını doğrulayın.
➢ Açılan menünün altındaki elemanların olduğunu doğrulayın. */

        wait.until(ExpectedConditions.visibilityOfAllElements(elements.leftNavMenu));
        for (int i = 1; i < elements.leftNavMenu.size(); i++) {
            wait.until(ExpectedConditions.visibilityOf(elements.leftNavMenu.get(i)));
            js.executeScript("arguments[0].scrollIntoView(true);", elements.leftNavMenu.get(i));
            wait.until(ExpectedConditions.elementToBeClickable(elements.leftNavMenu.get(i))).click();
            Assert.assertTrue(elements.leftNavMenu.get(i).isEnabled());
            Assert.assertTrue(elements.leftNavMenu.get(i).isDisplayed());
        }
    }

@Test(priority = 3,dependsOnMethods = "loginTest")
    public void createCustomer(){
       /* Test Case 3: Create Customer
➢ Customers menusunun altındaki Customers’a tıklatınız.
➢ Açılan sayfada Add new Butonuna tıklatınız.
➢ Açılan formu doldurunuz ve save butonuna tıklatınız.
➢ Başarılı bir şekilde Customer oluşturduğunuzu doğrulayınız. */



    Project5NewElements elements= new Project5NewElements(driver);

    wait.until(ExpectedConditions.visibilityOfAllElements(elements.leftNavMenu));
   // wait.until(ExpectedConditions.visibilityOf(elements.leftNavMenu.get(3))).click();
    wait.until(ExpectedConditions.elementToBeClickable(elements.leftNavMenu.get(3))).click();
    wait.until(ExpectedConditions.elementToBeClickable(elements.customerLink)).click();
    wait.until(ExpectedConditions.elementToBeClickable(elements.addNewCustomer)).click();

    Actions actions= new Actions(driver);
    Action action= actions.moveToElement(elements.customerEmail)
            .click()
                    .sendKeys(randomGenerator.internet().emailAddress())
            .sendKeys(Keys.TAB)
            .sendKeys(randomGenerator.internet().password())
            .sendKeys(Keys.TAB)
            .sendKeys(randomGenerator.name().firstName())
            .sendKeys(Keys.TAB)
            .sendKeys(randomGenerator.name().lastName())
            .sendKeys(Keys.TAB)
            .build();
    action.perform();

    wait.until(ExpectedConditions.visibilityOfAllElements(elements.genders));
    elements.genders.get(0).click();



}

}


