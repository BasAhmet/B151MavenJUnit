package techproed.day11_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.Utilities.TestBase;

public class C02_Iframe extends TestBase {
    @Test
    public void iframe() {
        //https://the-internet.herokuapp.com/iframe sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

        //Kalın yazının "Editor" kelimesini içerdiğini doğrulayınız
        String text01 = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertTrue(text01.contains("Editor"));

        //Textbox içindeki yazıyı siliniz.
        driver.switchTo().frame(0);
        WebElement textBox = driver.findElement(By.xpath("//p"));
        pause(2);
        textBox.clear();
        pause(2);

        //Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
        textBox.sendKeys("Bu textbox iFrame içinde yer almaktadır");
        pause(2);

        //Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.
        driver.switchTo().defaultContent();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='page-footer']//a")).isDisplayed());
    }
}
