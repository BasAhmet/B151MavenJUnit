package techproed.day20_WebTable_Excel;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.Utilities.TestBase;

public class C01_WebTables extends TestBase {
    /*
    WEBTABLE;
        <table> tagi ile baslar
            <thead> basliklar icin bu tag ile devam eder
                <tr>
                    <th> table head
                        <td>
                            basliktaki veriler
                        </td>
                    </th>
                </tr>
                    <tbody> basliklar altindaki verileri temsil eder
                            <tr> table row(satir)
                                <td>
                                    table data(tablodaki veri)
                                </td>
                            </tr>
                    </tbody>
 */
    @Test
    public void test01() {
        extentReport("Chrome","WebTable");
        extentTest = extentReports.createTest("WebTable","Test Raporu");

        //    https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");
        extentTest.info("https://the-internet.herokuapp.com/tables sayfasına gidildi.");

        //    Task 1 : Table1’i yazdırın
        System.out.println(xpath("(//table)[1]").getText());
        System.out.println("************************************");
        extentTest.info("Table 1 yazdırıldı.");

        //    Task 2 : 3. Satır verilerini yazdırın
        System.out.println(xpath("(//tbody)[1]//tr[3]").getText());
        System.out.println("************************************");
        extentTest.info("3. satır veriileri yazdırıldı.");

        //    Task 3 : Son satırın verilerini yazdırın
        int tableDataCount = xpaths("(//tbody)[1]//tr").size();//Tabloda kaç satır var bulduk.
        System.out.println(xpath("(//tbody)[1]//tr[" + tableDataCount + "]").getText());
        System.out.println("************************************");
        extentTest.info("Son satır verileri yazdırıldı.");

        //    Task 4 : 5. Sütun verilerini yazdırın
        for (int i = 0; i < tableDataCount; i++) {
            System.out.println(xpath("(//tbody)[1]//tr[" + (i + 1) + "]/td[5]").getText());
        }
        System.out.println("************************************");
        extentTest.info("5. sütun verileri yazdırıldı.");
        System.out.println(printData(1, 3));
        extentTest.info("Method ile 1. satır 3. sütun yazdırıldı.");
        System.out.println(printData(3, 4));
        extentTest.info("Method ile 3. satır 4. sütun yazdırıldı.");

        //3. satir 2. sütun bilgisinin Jack olup olmadığını doğrulayın
        System.out.println(printData(3, 2));
        String actualData = printData(3,2);
        String expectedData = "Jack";
        Assert.assertNotEquals(expectedData,actualData);
        extentTest.fail("3. satir 2. Sütun bilgisinin Jason olduğu görüldü");

        extentTest.pass("Sayfa kapatıldı");
        extentReports.flush();
    }
        //    Task 5 : Iki parametreli bir Java metodu oluşturalım: printData
        //    Parameter 1 = satır numarası
        //    Parameter 2 = sütun numarası
        //    printData(2,3);  => 2. satır, 3. sütundaki veriyi yazdırsın.
        private String printData(int satir, int sutun) {
            WebElement satirSutun = driver.findElement(By.xpath("(//tbody)[1]//tr["+satir+"]//td["+sutun+"]"));
            return satirSutun.getText();
        }




}




