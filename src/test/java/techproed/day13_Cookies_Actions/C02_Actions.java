package techproed.day13_Cookies_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.Utilities.TestBase;

public class C02_Actions extends TestBase {
    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        pause(2);

        //Kutuya sag tıklayın
        WebElement box = xpath("//*[@id='hot-spot']");
        Actions actions = new Actions(driver);
        actions.contextClick(box).perform();
        pause(2);

        //Alert'te cikan yazinin "You selected a context menu" oldugunu test edin
        Assert.assertEquals("You selected a context menu",driver.switchTo().alert().getText());
        pause(2);

        //Tamam diyerek alert'i kapatın
        driver.switchTo().alert().accept();
        pause(2);
    }
}
