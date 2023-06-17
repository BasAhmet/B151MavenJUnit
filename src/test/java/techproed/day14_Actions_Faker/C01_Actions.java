package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import techproed.Utilities.TestBase;

public class C01_Actions extends TestBase {
    @Test
    public void test01() {
        //techpro sayfasina gidelim
        driver.get("https://www.techproeducation.com");
        xpath("//*[@id='elementor-popup-modal-19118']//i").click();

        //sayfanin altina dogru gidelim
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

        //sayfanin ustune dogru gidelim
        actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).perform();

    }

    @Test
    public void test2() {
        //techpro sayfasina gidelim
        driver.get("https://www.techproeducation.com");
        xpath("//*[@id='elementor-popup-modal-19118']//i").click();

        //sayfanin altina dogru gidelim
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END);

        //sayfanin ustune dogru gidelim
        actions.sendKeys(Keys.HOME).build().perform();
        //build() --> methodu action'ları birleştirmek için kullanılan methoddur.Birden fazla oluşturduğumuz action
        //objesini birbirine bağlar
    }
    @Test
    public void test03() {
        driver.get("https://techproeducation.com");
        xpath("//*[@class='eicon-close']").click();
        pause(1);
        //sayfanin altina dogru gidelim
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0,1500).perform();

        //sayfanin ustune dogru gidelim
        actions.scrollByAmount(0,-1500).perform();
    }
}
