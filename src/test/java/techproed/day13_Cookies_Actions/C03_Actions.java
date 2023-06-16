package techproed.day13_Cookies_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.Utilities.TestBase;

import javax.swing.*;

public class C03_Actions extends TestBase {
    @Test
    public void test01() {
        //Amazon a gidelim https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //Sag ust bolumde bulunan "Account & Lists" menüsüne git  "Account" secenegine tikla
        WebElement element = xpath("//*[@id='nav-link-accountList']/span");
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        xpath("//*[@id='nav-al-your-account']/a[1]/span").click();

        //Acilan sayfanin Title in "Your Account" icerdigini dogrula
        Assert.assertTrue(driver.getTitle().equals("Your Account"));

    }
}
