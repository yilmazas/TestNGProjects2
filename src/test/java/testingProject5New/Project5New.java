package testingProject5New;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.BaseDriverParameter;
import utilities.MyFunction;

public class Project5New extends BaseDriverParameter {

    String email, name, lastName;


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


    @Test(priority = 2, dependsOnMethods = "loginTest")
    public void checkLeftNavMenu() {
        // paralel testlerde element class'inin objesi her test icerisinde ayri ayri olusturulmali
        Project5NewElements elements = new Project5NewElements(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        /* Test Case 2: Check LeftNaw Menu
➢ Dashboardun altındaki menülere tek tek tıklatın.
➢ Menülerin açılıp açılmadığını doğrulayın.
➢ Açılan menünün altındaki elemanların olduğunu doğrulayın. */

        wait.until(ExpectedConditions.visibilityOfAllElements(elements.leftNavMenu));
        for (int i = 1; i < elements.leftNavMenu.size(); i++) {
            wait.until(ExpectedConditions.visibilityOf(elements.leftNavMenu.get(i)));
            js.executeScript("arguments[0].scrollIntoView(true);", elements.leftNavMenu.get(i));
            js.executeScript("arguments[0].click();", elements.leftNavMenu.get(i));
            //wait.until(ExpectedConditions.elementToBeClickable(elements.leftNavMenu.get(i))).click();
            Assert.assertTrue(elements.leftNavMenu.get(i).isEnabled());
            Assert.assertTrue(elements.leftNavMenu.get(i).isDisplayed());
        }
    }


    @Test(priority = 3, dependsOnMethods = "loginTest")


    public void createCustomer() {
       /* Test Case 3: Create Customer
➢ Customers menusunun altındaki Customers’a tıklatınız.
➢ Açılan sayfada Add new Butonuna tıklatınız.
➢ Açılan formu doldurunuz ve save butonuna tıklatınız.
➢ Başarılı bir şekilde Customer oluşturduğunuzu doğrulayınız. */


        Project5NewElements elements = new Project5NewElements(driver);

        wait.until(ExpectedConditions.visibilityOfAllElements(elements.leftNavMenu));
        // wait.until(ExpectedConditions.visibilityOf(elements.leftNavMenu.get(3))).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.leftNavMenu.get(3))).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.customerLink)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.addNewCustomer)).click();

        email = randomGenerator.internet().emailAddress();
        name = randomGenerator.name().firstName();
        lastName = randomGenerator.name().lastName();

        MyFunction.wait(5);
        Actions actions = new Actions(driver);
        MyFunction.wait(5);
        Action action = actions.moveToElement(elements.customerEmail)
                .click()
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(randomGenerator.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(name)
                .sendKeys(Keys.TAB)
                .sendKeys(lastName)
                .sendKeys(Keys.TAB)
                .build();
        action.perform();


        wait.until(ExpectedConditions.visibilityOfAllElements(elements.genders));
        elements.genders.get(0).click();

        wait.until(ExpectedConditions.elementToBeClickable(elements.dateOfBirth));
        elements.dateOfBirth.sendKeys("11.12.1985");

        wait.until(ExpectedConditions.elementToBeClickable(elements.companyName));
        elements.companyName.sendKeys(randomGenerator.company().name());

        wait.until(ExpectedConditions.elementToBeClickable(elements.taxExemption));
        elements.taxExemption.click();

        wait.until(ExpectedConditions.elementToBeClickable(elements.newsletter));
        elements.newsletter.click();

        wait.until(ExpectedConditions.elementToBeClickable(elements.customerCreateInputs.get(8)));
        elements.customerCreateInputs.get(8).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.customerCreateNewsletters.get(0)));
        elements.customerCreateNewsletters.get(0).click();


//    wait.until(ExpectedConditions.elementToBeClickable(elements.customerCreateInputs.get(9)));
//    elements.customerCreateInputs.get(9).click();
//
//    wait.until(ExpectedConditions.visibilityOfAllElements(elements.customerRolesChoices));
//    elements.customerRolesChoices.get(0).click();

        elements.adminComment.sendKeys(randomGenerator.chuckNorris().fact());
        elements.saveButton.click();

        Assert.assertTrue(elements.successMessage.getText().contains("success"));


    }


    @Test(priority = 4, dependsOnMethods = "createCustomer")
    public void editCustomer() {

    /*Test Case 4: Edit Customer
➢ Customers’a tıklatınız.
➢ Acilan sayfada search kısmına yukarıda oluşturduğunuz Customer’in email,firstname
    ve lastName’leri giriniz.
➢ Search butonuna tıklatınız.
➢ Oluşturmuş olduğunuz kaydın geldiğini doğrulayınız.
➢ Edit butonuna tıklatınız.
➢ Herhangi bir bilgiyi değiştirip save butonuna tıklatınız.
➢ Başarılı bir şekilde update olduğunu doğrulayınız. */

        Project5NewElements elements = new Project5NewElements(driver);

        wait.until(ExpectedConditions.visibilityOfAllElements(elements.leftNavMenu));

        wait.until(ExpectedConditions.elementToBeClickable(elements.leftNavMenu.get(3))).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.customerLink)).click();

        wait.until(ExpectedConditions.visibilityOf(elements.searchEmail));
        elements.searchEmail.sendKeys(email);

        wait.until(ExpectedConditions.visibilityOf(elements.searchFirstname));
        elements.searchFirstname.sendKeys(name);

        wait.until(ExpectedConditions.visibilityOf(elements.searchLastName));
        elements.searchLastName.sendKeys(lastName);

        wait.until(ExpectedConditions.elementToBeClickable(elements.searchCustomerButton));
        elements.searchCustomerButton.click();

        Assert.assertTrue(elements.searchAssertionCustomerName.getText().contains(name));
        // Assert.assertFalse(elements.searchAssertionList.isEmpty());

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", elements.editCustomerButton);
        js.executeScript("arguments[0].click();", elements.editCustomerButton);

        wait.until(ExpectedConditions.elementToBeClickable(elements.firstNameEdit));
        elements.firstNameEdit.clear();
        elements.firstNameEdit.sendKeys(name + " new ");

        wait.until(ExpectedConditions.elementToBeClickable(elements.saveButton)).click();
        Assert.assertTrue(elements.successMessage.getText().contains("success"));


    }


    @Test(priority = 5, dependsOnMethods = "editCustomer")

    public void deleteCustomer() {
        /* Test Case 5: Delete Customer
➢ Customers’a tıklatınız.
➢ Acilan sayfada search kismina yukarida olusturdugunuz Customer’in email,firstname
ve lastName leri giriniz.
➢ Search butonuna tıklatınız.
> edit butonuna tiklatiniz
➢ Delete butonuna tıklatınız.
➢ Başarılı bir şekilde Customer sildiğinizi doğrulayanız. */
        Project5NewElements elements = new Project5NewElements(driver);

        wait.until(ExpectedConditions.visibilityOfAllElements(elements.leftNavMenu));
        wait.until(ExpectedConditions.elementToBeClickable(elements.leftNavMenu.get(3))).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.customerLink)).click();

        wait.until(ExpectedConditions.visibilityOf(elements.searchEmail));
        elements.searchEmail.sendKeys(email);

        wait.until(ExpectedConditions.visibilityOf(elements.searchFirstname));
        elements.searchFirstname.sendKeys(name);

        wait.until(ExpectedConditions.visibilityOf(elements.searchLastName));
        elements.searchLastName.sendKeys(lastName);

        wait.until(ExpectedConditions.elementToBeClickable(elements.searchCustomerButton));
        elements.searchCustomerButton.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", elements.editCustomerButton);
        js.executeScript("arguments[0].click();", elements.editCustomerButton);

        wait.until(ExpectedConditions.elementToBeClickable(elements.deleteButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.deleteButtonConfirmation)).click();

        Assert.assertTrue(elements.successMessage.getText().contains("success"));

    }


    @Test(priority = 6,dependsOnMethods = "loginTest")
    public void searchTest() {
        /*  Test Case 6: Search Test
➢ Search kısmına “Shipments” textini gönderiniz.
            ➢ Arama sonucuna tıklayınız.
➢ Shipments’e gittiğini doğrulayınız
} */
        Project5NewElements elements = new Project5NewElements(driver);

        wait.until(ExpectedConditions.elementToBeClickable(elements.searchBox));
        elements.searchBox.sendKeys("Shipments");

        wait.until(ExpectedConditions.elementToBeClickable(elements.searchBoxText));
        elements.searchBoxText.click();

        Assert.assertTrue(elements.shipmentsConfirmation.getText().contains("Shipments"));







    }


}



