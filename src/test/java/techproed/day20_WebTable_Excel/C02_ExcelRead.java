package techproed.day20_WebTable_Excel;


import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ExcelRead {
    /*
    EXCEL dosyasından veri okuyabilmemiz için öncelikle pom.xml dosyamıza poi ve poi.ooxml dependency'lerini
yüklememiz gerekir.
    Sonra üzerinde çalışacağımız excel dosyasını projemizde src>test>java>techpoed>resources package'i içine
kayarız.
 */
    @Test
    public void test01() throws IOException {
        //1. - Dosya yolunu alırız
        String filePath = "src/test/java/techproed/resources/Capitals.xlsx";

        //2. - Dosyayı okuyabilmemiz için javada akışa almamız gerekir
        FileInputStream fis = new FileInputStream(filePath);

        //3. - Javada bir excel dosyaysı oluşturabilmemiz için
        Workbook workbook = WorkbookFactory.create(fis);//Akışa aldığımız dosyayı okuyoruz

        //4. - Oluşturduğumuz excel'den sayfa(sheet) seçmemiz gerekir
        Sheet sheet = workbook.getSheet("Sheet1");

        //5. - Belirttiğimiz sayfadaki satır bilgisini  belirtmemiz gerekir
        Row row = sheet.getRow(0);

        //6. - Belirttiğimiz satırdaki hücreyi(cell) seçmemiz gerekir
        Cell cell = row.getCell(0);

        //Artık sout ile yazdırabiliriz --> 1. satır 1. hücre
        System.out.println(cell);
    }

    @Test
    public void test02() throws IOException {
        //DAHA PRATİK BİR YOL
        //1. Satır 1. Sütun daki bilgileri yazdıralım
        FileInputStream fis = new FileInputStream("src/test/java/techproed/resources/Capitals.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);

        String bireBir = workbook.getSheet("Sheet1").getRow(0).getCell(0).toString();
        System.out.println(bireBir);
    }

    @Test
    public void test03() throws IOException {
        //Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
        FileInputStream fis = new FileInputStream("src/test/java/techproed/resources/Capitals.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);

        String bireIki = workbook.getSheet("Sheet1").getRow(0).getCell(1).toString();
        System.out.println(bireIki);

        //3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
        String uceBir = workbook.getSheet("Sheet1").getRow(2).getCell(0).toString();
        Assert.assertEquals("France", uceBir);

        //Kullanılan satır sayısın bulun
        int rowNumber = workbook.getSheet("Sheet1").getPhysicalNumberOfRows();
        System.out.println(rowNumber);
        //NOT:getPhysicalNumberOfRows() methodu kullanılan yani içi dolu olan satırların sayısını verir.
        // Index 1 den başlar

        //Sayfadaki satır sayısını yazdırınız
        int lastRowNumber = workbook.getSheet("Sheet1").getLastRowNum();
        System.out.println("Satır sayısı : " + (lastRowNumber + 1));//index 0 dan başlar

        //Ülke-Başkent şeklinde verileri yazdırın
        for (int i = 0; i < rowNumber; i++) {
            System.out.print(workbook.getSheet("Sheet1").getRow(i).getCell(0).toString() + "\t");
            System.out.print(workbook.getSheet("Sheet1").getRow(i).getCell(1).toString());
            System.out.println();
        }

    }
}
