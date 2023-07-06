package techproed.day22_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import techproed.Utilities.TestBase;

public class C02_SetAttribute extends TestBase {
    @Test
    public void test01() {
        //Techpro education ana sayfasina git
        driver.get("https://www.techproeducation.com");
        pause(2);
        xpath("//i[@class='eicon-close']").click();
        pause(1);

        //Arama kutusuna QA yaz

        /*
        <input> tag'ına sahip webelementlere değer gönderirken sendKeys() methodu kullanırız
        sendKeys() methodu ile değer gönderemediğimiz durumlarda js executor ile rahatlıkla
        değer gönderebiliriz.
        <input> taglarında value attributu değeri, arama kutusu içindeki veriyi temsil eder
         */

        WebElement searchBox = xpath("//*[@id='elementor-search-form-9f26725']");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 10; i > 0 ; i--) {
            js.executeScript("arguments[0].value='" + i + "'",searchBox);
            pause(1);
        }
        js.executeScript("arguments[0].value='QA'",searchBox);

    }
}
