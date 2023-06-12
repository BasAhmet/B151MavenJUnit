package techproed.day10_TestBase_Allert;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import techproed.Utilities.TestBase;

public class C02_Alerts extends TestBase {
    /*
    Eger bir sayfadaki bir buttona tikladigimizda bir uyari penceresi cikiyorsa ve bu cikan pencereye sag klik yapip
    locate alamiyorsak, bu bir Js Alert'tur.
    Js Alert'u handle edebilmek icin driver'imizi o pencereye gecirmemeiz gerekir. Bunun icin; driver objemizi kullanarak
    swichTo() methoduyla alert() methodunu kullanarak js alert'e gecir yapmis oluruz.
    accept() ya da dismiss() methodlariyla js Alert'u onaylar ya da iptal ederek kapatiriz
     */
    @Test
    public void t01acceptAlert() {
        //Bir metod olusturun: acceptAlert
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //1. butona tıklayın, uyarıdaki OK butonuna tıklayın
        driver.findElement(By.xpath("(//*[@class='btn btn-primary'])[1]")).click();
        bekle(2);
        driver.switchTo().alert().accept();
        bekle(2);

        //result mesajının  “You successfully clicked an alert” oldugunu test edin.
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='result']")).getText().equals("You successfully clicked an alert"));
        bekle(1);

    }

    @Test
    public void t02dismissAlert() {
        //Bir metod olusturun: dismissAlert
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın
        driver.findElement(By.xpath("(//*[@class='btn btn-primary'])[2]")).click();
        bekle(2);
        driver.switchTo().alert().dismiss();
        bekle(2);

        //result mesajının “successfuly” icermedigini test edin.
        Assert.assertFalse(driver.findElement(By.xpath("//*[@id='result']")).getText().contains("successfuly"));
        bekle(1);
    }

    @Test
    public void t03sendKeysAlert() {
        //Bir metod olusturun: sendKeysAlert
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna tıklayın
        driver.findElement(By.xpath("(//*[@class='btn btn-primary'])[3]")).click();
        bekle(2);
        driver.switchTo().alert().sendKeys("Ahmet");
        bekle(2);
        driver.switchTo().alert().accept();
        bekle(2);

        //result mesajında isminizin görüntülendiğini doğrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='result']")).getText().contains("Ahmet"));
        bekle(1);

    }
}
