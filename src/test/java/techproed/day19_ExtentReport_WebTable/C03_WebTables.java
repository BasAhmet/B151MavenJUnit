package techproed.day19_ExtentReport_WebTable;

import org.junit.Test;
import org.openqa.selenium.By;
import techproed.Utilities.TestBase;

public class C03_WebTables extends TestBase {
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
        //    https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");

        //    Task 1 : Table1’i yazdırın
        System.out.println(xpath("(//table)[1]").getText());
        System.out.println("************************************");

        //    Task 2 : 3. Satır verilerini yazdırın
        System.out.println(xpath("//table[1]//tr[3]").getText());
        System.out.println("************************************");

        //    Task 3 : Son satırın verilerini yazdırın

        //    Task 4 : 5. Sütun verilerini yazdırın

        //    Task 5 : Iki parametreli bir Java metodu oluşturalım: printData

        //    Parameter 1 = satır numarası

        //    Parameter 2 = sütun numarası

        //    printData(2,3);  => 2. satır, 3. sütundaki veriyi yazdırsın.

    }
}
