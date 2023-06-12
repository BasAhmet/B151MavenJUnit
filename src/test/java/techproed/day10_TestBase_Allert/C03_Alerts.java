package techproed.day10_TestBase_Allert;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.devtools.v111.page.model.AdFrameExplanation;
import techproed.Utilities.TestBase;

public class C03_Alerts extends TestBase {
    @Test
    public void test01() {
        //https://demoqa.com/alerts adresine gidelim
        driver.get("https://demoqa.com/alerts");
        bekle(2);

        //Click Button to see alert karşısındaki butona tıklayalım
        driver.findElement(By.xpath("//*[@id='alertButton']")).click();
        bekle(2);

        //Çıkan Alert'te You clicked a button yazısının çıktığını doğrulayalım
        Assert.assertTrue(getTextAlert().equals("You clicked a button"));
        bekle(2);

        // Ve alert'ü kapatalım
        acceptAlert();
        bekle(2);
    }

    @Test
    public void test02() {
        //https://demoqa.com/alerts adresine gidelim
        driver.get("https://demoqa.com/alerts");
        bekle(2);

        //On button click, confirm box will appear karşısındaki butona tıklayalım.
        driver.findElement(By.xpath("//*[@id='confirmButton']")).click();
        bekle(2);

        //Çıkan alertte iptale basalım.
        dissmisAlert();
        bekle(2);

        // Sonuç yazısında You selected Cancel yazdığını doğrulayalım
        Assert.assertEquals("You selected Cancel", driver.findElement(By.xpath("//*[@id='confirmResult']")).getText());
        bekle(2);
    }

    @Test
    public void test03() {
        //https://demoqa.com/alerts adresine gidelim
        driver.get("https://demoqa.com/alerts");
        bekle(2);

        //On button click, prompt box will appear karşısındaki butona tıklayalım
        driver.findElement(By.xpath("//*[@id='promtButton']")).click();
        bekle(2);

        //çıkan alerte ismimizi girelim
        sendKeysAlert("Ahmet");
        bekle(2);
        acceptAlert();
        bekle(2);

        // ismi girdiğimizi doğrulayalım
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='promptResult']")).getText().contains("Ahmet"));
        bekle(2);
    }
}

