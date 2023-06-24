package techproed.day19_ExtentReport_WebTable;

import org.junit.Test;
import org.openqa.selenium.Keys;
import techproed.Utilities.TestBase;

public class C02_ExtentReport extends TestBase {
    @Test
    public void test01() {
        extentReport("Chrome","Amazon Testi");
        extentTest = extentReports.createTest("Extent Test","Test Raporu");

        //amazon sayfasına gidiniz
        driver.get("https://amazon.com");
        extentTest.info("Amazon sayfasına gidildi");

        //sayfanın resmini alınız
        fullScreenShot();
        extentTest.info("Sayfanın resmi alındı.");

        //arama kutusunda iphone aratınız
        xpath("//*[@id='twotabsearchtextbox']").sendKeys("iphone", Keys.ENTER);
        extentTest.info("Arama kutusunda 'iphone' aratıldı.");
        extentTest.pass("Sayfa kapatıldı.");

    }
}
