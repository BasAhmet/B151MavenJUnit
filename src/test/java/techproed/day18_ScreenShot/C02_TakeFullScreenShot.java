package techproed.day18_ScreenShot;

import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import techproed.Utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C02_TakeFullScreenShot extends TestBase {
    @Test
    public void test01() throws IOException {
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");

        pause(2);

        //Ve ekran görüntüsünü alalım

        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "src/test/java/techproed/day18_ScreenShot/fullScreenShot/screenShot" + tarih + ".jpeg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        Files.write(Paths.get(dosyaYolu),ts.getScreenshotAs(OutputType.BYTES));
    }

}
