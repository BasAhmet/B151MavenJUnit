package techproed.day07_MavenJUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import techproed.Util;


public class C01_ClassWork {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver =  Util.chromeDriver(15);

        // http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        // Signin buttonuna tiklayin
        WebElement signinButton = driver.findElement(By.cssSelector("button[id]"));
        signinButton.click();

        // Login alanine "username" yazdirin.
        // Password alanına "password" yazdirin
        // Sign in buttonuna tiklayin
        WebElement login = driver.findElement(By.xpath("//*[@id='user_login']"));
        login.sendKeys("username", Keys.TAB,"password",Keys.ENTER);
        Thread.sleep(2000);
        driver.navigate().back();

        // Online Banking altında Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//*[@id='online-banking']")).click();
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();

        // amount kismina yatirmak istediginiz herhangi bir miktari yazin
        // tarih kismina "2020-09-10" yazdirin
        // Pay buttonuna tiklayin
        driver.findElement(By.xpath("//*[@id='sp_amount']")).sendKeys("1000",Keys.TAB,
                "2020-09-10",Keys.TAB,Keys.TAB,Keys.ENTER);

        // "The payment was successfully submitted." mesajinin ciktigini control edin
        String actualMessage = driver.findElement(By.xpath("//*[@id='alert_content']/span")).getText();
        if(actualMessage.equals("The payment was successfully submitted.")){
            System.out.println("Test PASSED.");
        }else{
            System.out.println("Test FAILED : " + actualMessage);
        }

        // sayfayı kapatınız
        driver.close();
    }
}
