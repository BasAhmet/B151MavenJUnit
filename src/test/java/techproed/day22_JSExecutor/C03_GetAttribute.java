package techproed.day22_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import techproed.Utilities.TestBase;

public class C03_GetAttribute extends TestBase {
    @Test
    public void test01() {
        //  https://www.carettahotel.com/ a gidiniz
        driver.get("https://www.carettahotel.com/");
        pause(2);
        xpath("//*[@id='details-button']").click();
        pause(2);
        xpath("//*[@id='proceed-link']").click();
        pause(2);

        //  Tarih kısmını JS ile locate ediniz.
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement date = (WebElement) js.executeScript("return document.getElementById('checkin_date')");

        /*
        Java Script kodlarıyla yazılmış webelementleri bizim bildiğimiz findElement() methoduyla locate edemeyebiliriz.
        js executor kullanarak ister html ister java script ile yazılmış olsun bir webelementin locatini js executor
        ile alabiliriz. Yukarıdaki örnekte sayfadaki tarih webelementini js executor ile locate ettik.
         */
        date.clear();
        date.sendKeys("5/25/2023");

        //  Yazili metinleri alıp ve yazdırınız
        System.out.println(date.getAttribute("id"));
    }

    @Test
    public void test02() {
        //https://www.priceline.com/ adresine gidiniz

        //Submit butonunun rengini Kirmizi yazınız
    }
}
