package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.Utilities.TestBase;

public class C03_KeyDownKeyUp extends TestBase {
    @Test
    public void test01() {
        //Google anasayfasına gidelim
        driver.get("https://www.google.com");

        //arama kutusunda shift tusuna basılı olarak selenium yazdıralım ve shift tuşunu serbest bırakarak java yazdıralım
        WebElement searchBox = xpath("//*[@id='APjFqb']");
        Actions actions = new Actions(driver);
        actions.keyDown(searchBox,Keys.SHIFT).sendKeys("selenium").keyUp(Keys.SHIFT).sendKeys("java").perform();

    }
    @Test
    public void test02() {
        //Google anasayfasına gidelim
        driver.get("https://www.google.com");

        //arama kutusunda shift tusuna basılı olarak selenium yazdıralım ve shift tuşunu serbest bırakarak java yazdıralım
        WebElement searchBox = xpath("//*[@id='APjFqb']");
        searchBox.sendKeys(Keys.SHIFT,"selenium",Keys.SHIFT,"java");
    }

    @Test
    public void test03() {
        //google sayfasına gidelim
        driver.get("https://www.google.com");

        // Arama kutusuna "Selenium" yazın ve Enter tuşuna basın
        WebElement searchBox = xpath("//*[@id='APjFqb']");
        searchBox.sendKeys("Selenium",Keys.ENTER);

        // Sayfayı bekleyin
        pause(4);

        // Arattığımız kelimeyi arama kutusundan ctrl+x ile keselim
        searchBox = xpath("//*[@id='APjFqb']");
        searchBox.sendKeys(Keys.CONTROL,"a","x");
        pause(2);

        //Tekrar google sayfasına gidip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım
        driver.get("https://www.google.com");
        pause(2);
        searchBox = xpath("//*[@id='APjFqb']");
        searchBox.sendKeys(Keys.CONTROL,"v",Keys.ENTER);
    }
}
