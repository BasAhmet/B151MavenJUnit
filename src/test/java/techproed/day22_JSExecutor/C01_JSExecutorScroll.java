package techproed.day22_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import techproed.Utilities.TestBase;

public class C01_JSExecutorScroll extends TestBase {
    /*
    Actions class'ındaki gibi js executor ile de sayfada scroll işlemi yapabiliriz. Bir webelementi locate edip
    o webelement görünür olana kadar scroll yapabiliriz
    "arguments[0].scrollIntoView(true);",Webelement --> Bu script kodu ile belirtmiş olduğumuz webelemente scroll
    yaparız
     */
    @Test
    public void test01() {
        //Techpro education ana sayfasına git
        driver.get("https://www.techproeducation.com");
        pause(2);
        xpath("//i[@class='eicon-close']").click();
        pause(1);

        //"We Offer" elementi görünür olacak şekilde üzerine scroll et ve ekran görüntüsünü al
        WebElement weofferWE = xpath("//*[.='we offer']");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",weofferWE);
        pause(1);
        fullScreenShot();

        //Aynı sayfada "Enroll Free "elementi görünür olacak sekilde scroll et ve ekran görüntüsünü al
        pause(1);
        WebElement enrollFreeWE = xpath("//*[.='Enroll Free Course']");
        js.executeScript("arguments[0].scrollIntoView(true);",enrollFreeWE);
        pause(1);
        fullScreenShot();

        //Aynı sayfada "WHY US?" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        WebElement whyUsWE = xpath("//*[text()='WHY US?']");
        js.executeScript("arguments[0].scrollIntoView(true);",whyUsWE);
        pause(2);
        fullScreenShot();

        //Aynı sayfada tekrar "Enroll Free" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        js.executeScript("arguments[0].scrollIntoView(true);",enrollFreeWE);
        pause(2);
        fullScreenShot();

        //Sayfayi en üste scroll yapalım
        js.executeScript("window.scrollTo(0,0)");
        pause(2);

        //Sayfayı en alta scroll yapalım
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        pause(2);

        //Sayfayi en üste scroll yapalım
        js.executeScript("window.scrollTo(0,0)");
    }
}
