package techproed.day18_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import techproed.Utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_TakeFullScreenShot extends TestBase {
    @Test
    public void test01() throws IOException {
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com/");

        //Çıkan reklamı kapatalım
        Actions actions = new Actions(driver);
        pause(3);
        actions.sendKeys(Keys.ENTER).perform();

        //Ve ekran görüntüsünü alalım
        String pathSS = "src/test/java/techproed/day18_ScreenShot/fullScreenShot/screenShot.png";
        TakesScreenshot tss = (TakesScreenshot) driver;
        FileUtils.copyFile(tss.getScreenshotAs(OutputType.FILE),new File(pathSS));
    }

    @Test
    public void test02() throws IOException {
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com/");

        //Çıkan reklamı kapatalım
        Actions actions = new Actions(driver);
        pause(3);
        actions.sendKeys(Keys.ENTER).perform();

        //Ve ekran görüntüsünü alalım
        TakesScreenshot tss = (TakesScreenshot) driver;
        FileUtils.copyFile(tss.getScreenshotAs(OutputType.FILE),new File("techproed/ss/screenShot.jpg"));
    }

    @Test
    public void test03() throws IOException {
        /*
        Kaydettiğimiz ekran resmini her seferinde aynı dosya üzerine yazmaması için dosya isminden sonra
        String bir değişkene tarih formatı atayabiliriz.
         */
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com/");

        //Çıkan reklamı kapatalım
        Actions actions = new Actions(driver);
        pause(3);
        actions.sendKeys(Keys.ENTER).perform();

        //Ve ekran görüntüsünü alalım
        String date = new SimpleDateFormat("[dd.MM.yyyy][hh;mm;ss]").format(new Date());
        TakesScreenshot tss = (TakesScreenshot) driver;
        FileUtils.copyFile(tss.getScreenshotAs(OutputType.FILE),new File("src/test/java/techproed/day18_ScreenShot/fullScreenShot/screenShot"+date+".jpg"));
    }
    @Test
    public void test04() {
        /*
        Kaydettiğimiz ekran resmini her seferinde aynı dosya üzerine yazmaması için dosya isminden sonra
        String bir değişkene tarih formatı atayabiliriz.
         */
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com/");

        //Çıkan reklamı kapatalım
        Actions actions = new Actions(driver);
        pause(3);
        actions.sendKeys(Keys.ENTER).perform();

        //Ve ekran görüntüsünü alalım
        fullScreenShot();
    }
}
