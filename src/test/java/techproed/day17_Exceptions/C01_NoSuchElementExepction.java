package techproed.day17_Exceptions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techproed.Utilities.TestBase;

public class C01_NoSuchElementExepction extends TestBase {
    @Test
    public void test01() {
         /*
    NO_SUCH_ELEMENT_EXCEPTION
        -Bir webelementin locate'ini yanlis aldığımızda, elementi bulamayacağı için bu
        exception'i alırız
     */
        //techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        pause(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        //arama kutusunda qa aratalım
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='ssearch']"));
    /*
    org.openqa.selenium.NoSuchElementException:
      normal locatimiz //*[@type='search'] bu şekilde iken nosuchelementexception alabilmek için locate'i bozduk
    //*[@type='ssearch'] ve exception'ı aldığımızı gördük. Dolayısıyla bu hatayı handle edebilmek için
    düzgün locate almamız gerekiyor
     */

        aramaKutusu.sendKeys("qa", Keys.ENTER);

        //sayfa başlığının qa içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("qa"));


    }
}
