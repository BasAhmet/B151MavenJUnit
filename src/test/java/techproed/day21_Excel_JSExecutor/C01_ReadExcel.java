package techproed.day21_Excel_JSExecutor;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C01_ReadExcel {
    @Test
    public void readExcel() throws IOException {
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
        System.out.println("******************************");
        for (int i = 0; i < lastRowNumber + 1; i++) {
            for (int j = 0; j < 2; j++) {
                try {
                    System.out.printf("%-15s|",workbook.getSheet("Sheet1").getRow(i).getCell(j).toString());
                }
                catch (Exception e){
                }
            }
            System.out.println();
        }
    }
}
