package techproed.day19_ExtentReport_WebTable;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;
import techproed.Utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ExtentReport extends TestBase {
    /*
    EXTENTREPORT;
       1- ExtentReport(aventstack) kullanabilmek için öncelikle mvn adresinden 4.0.9 versiyon numaralı
    dependency'i pom.xml dosyamıza ekleriz.
       2- ExtentReports class'ından class seviyeninde obje oluştururuz
       3- ExtentHtmlReporter class'ından class seviyeninde obje oluştururuz
       4- ExtentTest class'ından class seviyeninde obje oluştururuz
     */
    ExtentReports extentReports;//--> Raporlamayı başlatmak için kullanılan class.
    ExtentHtmlReporter extentHtmlReporter;//--> raporu html formatında düzenler.
    ExtentTest extentTest;//--> Test adımlarına eklemek istediğimiz bilgileri bu class ile oluştururuz.
    @Test
    public void test01() {
        extentReports = new ExtentReports();
        String date = new SimpleDateFormat("_dd.MM.yyyy_hh;mm;ss_").format(new Date());
        String filePath = "src/test/java/techproed/day19_ExtentReport_WebTable/" + date + ".html";
        extentHtmlReporter = new ExtentHtmlReporter(filePath);
        extentReports.attachReporter(extentHtmlReporter);//--> Html formatında raporlamayı başlatacak

        //Raporda gözükmesini istediğimiz bilgiler için
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Tester","Ahmet");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("Smoke Test Raporu");

        extentTest = extentReports.createTest("ExtendTest","Test Raporu");

        //amazon sayfasına gidelim
        driver.get("https://www.amazon.com");
        extentTest.info("Amazon sayfasına gidildi.");

        //başlığın Amazon içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("Amazon"));
        extentTest.info("Başlığın 'Amazon' içerdiği test edildi.");

        //arama kutusunda iphone aratalım
        xpath("//*[@id='twotabsearchtextbox']").sendKeys("iphone", Keys.ENTER);
        extentTest.info("Arama kutusunda 'iphone' aratıldı.");

        //sonuc yazını konsola yazdıralım
        System.out.println(xpath("(//*[@class='sg-col-inner'])[1]").getText());
        extentTest.info("Sonuç yazısı konsola yazdırıldı.");
        extentTest.pass("Sayfa kapatıldı.");
        /*
            extentTest objesi ile info() methodunu kullanarak her step'de ne yaptığımızla alakalı bilgi yazabiliriz
        testimizin en sonunda testin bittiğini ifade eden pass() methodu ile testimiz ile alakalı son bilgiyi
        ekleyebiliriz.
            Ve son olarak actions daki perform methodu gibi extentReport objesi ile flush() methodu kullanarak
        raporu sonlandırırız
         */
        extentReports.flush();


    }
}
