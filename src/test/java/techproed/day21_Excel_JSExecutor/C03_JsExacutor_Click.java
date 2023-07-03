package techproed.day21_Excel_JSExecutor;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import techproed.Utilities.TestBase;

public class C03_JsExacutor_Click extends TestBase {
    /*
        Bir web sayfasında bazı webelementler oluşturulurken JAVASCRIPT kodlarıyla oluşturulmuş olabilir.
    Bu webelementleri handle edebilmek için JavaScriptExecutor arayüzünü kullanmamız gerekir.
    Bir webelement JavaScript kodları ile yazılmamış olsada javaScriptExecutor ile o webelementi handle edebiliriz.
    Normal bildiğimiz methodlardan daha yavaş çalışacağı için bildiğimiz methodlar işimizi görüyorsa onları kullanırız.
    <script> tagi ile oluşturulmuş olan web elementleri de js executor ile handle edebiliriz.
     */
    /*
        JS executor ile Webelementin önünde uyarı çıkmasına rağmen webelemente click yaptı çünkü kodlara direk ulaşıyor
        Normal kullandığımız click methodu burda önünde farklı bir element olduğu için ElementClickInterceptedException:
        hatası verdi.Dolayısıyla bu exception ile karşılaştığımızda da js executor ile bunu çözebiliriz
    */
    @Test
    public void test01() {
        //Amazon sayfasina gidiniz
        driver.get("https://www.amazon.com");

        //sell linkinin resmini alalım
        WebElement sellLink = xpath("//*[@id='nav-xshop']/a[5]");
        webElementScreenShot(sellLink);

        //Sell linkine js executor kullanarak tiklayiniz
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",sellLink);

        //Başlığın Sell içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("Sell"));

        //Sayfanın resmini alalım
        fullScreenShot();
    }
    @Test
    public void test02() {
        //Amazon sayfasına gidiniz
        driver.get("https://amazon.com");
        pause(2);
        //sell linkinin resmini alalım
        WebElement sellLinki = xpath("//*[.='Sell']");
        webElementScreenShot(sellLinki);
        //Sell linkine tıklayınız
        sellLinki.click();
        /*
        JS executor ile Webelementin önünde uyarı çıkmasına rağmen webelemente click yaptı çünkü kodlara direk ulaşıyor
        Normal kullandığımız click methodu burda önünde farklı bir element olduğu için ElementClickInterceptedException:
        hatası verdi.Dolayısıyla bu exception ile karşılaştığımızda da js executor ile bunu çözebiliriz
         */
        //Başlığın Sell içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("Sell"));
        //Sayfanın resmini alalım
        fullScreenShot();
    }
    @Test
    public void test03() {
        //Amazon sayfasına gidiniz
        driver.get("https://amazon.com");
        pause(2);
        //sell linkinin resmini alalım
        //driver.findElement(By.xpath("(//*[@class='a-button-inner'])[1]")).click();//-->uyarı kapatıldı
        WebElement sellLinki = xpath("//*[.='Sell']");
        pause(2);
        webElementScreenShot(sellLinki);
        //Sell linkine js executor kullanarak tıklayınız
        click(sellLinki);//-->Click methodu ile normal click yapmayı denedi fakat olmadı js excutor ile click yaptı
        //Başlığın Sell içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("Sell"));
        //Sayfanın resmini alalım
        fullScreenShot();
    }
}
