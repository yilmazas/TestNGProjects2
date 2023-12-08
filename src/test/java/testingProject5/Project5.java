package testingProject5;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BaseDriverParameter;
import utilities.MyFunction;

public class Project5 extends BaseDriverParameter {

    Project5Elements elements= new Project5Elements(driver);

    JavascriptExecutor js= ( JavascriptExecutor) driver;

    @Test(priority = 1)
    public void loginTest(){

        System.out.println("The login test was inserted into the BaseDriverParameter class");
        // The login test was inserted into the BaseDriverParameter class
    }

    @Test
    public void checkLeftNavMenu(){
        /* Test Case 2: Check LeftNaw Menu
➢ Dashboardun altındaki menülere tek tek tıklatın.
➢ Menülerin açılıp açılmadığını doğrulayın.
➢ Açılan menünün altındaki elemanların olduğunu doğrulayın. */
        wait.until(ExpectedConditions.urlToBe("https://admin-demo.nopcommerce.com/admin/"));
        System.out.println("elements.leftNavMenu = " + elements.leftNavMenu);
        for (int i = 1; i < 10; i++) {
            wait.until(ExpectedConditions.visibilityOfAllElements(elements.leftNavMenu));
            js.executeScript("arguments[0].scrollIntoView(true);", elements.leftNavMenu.get(i));
            elements.leftNavMenu.get(i).click();
            Assert.assertTrue(elements.leftNavMenu.get(0).isEnabled());
            Assert.assertTrue(elements.leftNavMenu.get(0).isDisplayed());
        }

//        wait.until(ExpectedConditions.visibilityOfAllElements(elements.leftNavMenu));
//        for (int i = 1; i < elements.leftNavMenu.size(); i++) {
//            wait.until(ExpectedConditions.elementToBeClickable(elements.leftNavMenu.get(i)));
//            elements.leftNavMenu.get(i).click();
//        }


    }

}
