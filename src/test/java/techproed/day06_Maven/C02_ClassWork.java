package techproed.day06_Maven;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import techproed.Util;


public class C02_ClassWork {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver =  Util.chromDriver(15);

        // http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        // Signin buttonuna tiklayin
        WebElement signinButton = driver.findElement(By.cssSelector("button[id]"));
        signinButton.click();

        // Login alanine "username" yazdirin. Password alanine "password" yazdirin
        WebElement login = driver.findElement(By.xpath("//*[@id='user_login']"));
        login.sendKeys("username", Keys.TAB,"password");
        Thread.sleep(2000);

        // Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        // Pay Bills sayfasina gidin

        // amount kismina yatirmak istediginiz herhangi bir miktari yazin

        // tarih kismina "2020-09-10" yazdirin

        // Pay buttonuna tiklayin

        // "The payment was successfully submitted." mesajinin ciktigini control edin
    }
}
