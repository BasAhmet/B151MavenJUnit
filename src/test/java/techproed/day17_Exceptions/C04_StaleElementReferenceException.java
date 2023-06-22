package techproed.day17_Exceptions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techproed.Utilities.TestBase;

public class C04_StaleElementReferenceException extends TestBase {
        /*
        STALE_ELEMENT_REFERENCE_EXCEPTION
            Bir webelementin sayfayı refreh(yenileme) yada back-forward yapma sonucundan eskimesi(bayatlaması)
         durumunda bu exception'ı alırız. Yani driver sayfayı yeniden oluşturduğunda elementin locate'i aynı
         olmasına rağmen tekrar o elementin locatini almamızı ister. Almadığımız takdirde locate'i eskimis olarak görür ve
         staleelementrefenceexception hatası verir.
         */

    @Test
    public void test01() {
        //techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        pause(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        //arama kutusunda qa aratalım
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='search']"));

        driver.navigate().refresh();
        /*
        org.openqa.selenium.StaleElementReferenceException hatası aldık çünkü refresh yaptıktan sonra
        tekrar locate almadık. Dolayısıyla bu hatayı handle edebilmek için refresh yaptıktan sonra
        tekrar locate almalıyız.
         */

        aramaKutusu.sendKeys("qa", Keys.ENTER);

        //sayfa başlığının qa içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("qa"));
    }
}
