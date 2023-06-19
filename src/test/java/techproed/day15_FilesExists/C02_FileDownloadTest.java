package techproed.day15_FilesExists;

import org.junit.Assert;
import org.junit.Test;
import techproed.Utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDownloadTest extends TestBase {
    @Test
    public void test01() throws IOException {
        //https://testcenter.techproeducation.com/index.php?page=file-download adresine gidelim.
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");

        //b10 all test cases dosyasını indirelim
        xpath("(//a)[3]").click();
        pause(3);

        //Dosyanın başarıyla indirilip indirilmediğini test edelim
        Assert.assertTrue(Files.exists(Paths.get("C:/Users/ahba8/Downloads/b10 all test cases, code.docx")));
        pause(2);
        Files.delete(Paths.get("C:/Users/ahba8/Downloads/b10 all test cases, code.docx"));
        pause(1);
        Assert.assertFalse(Files.exists(Paths.get("C:/Users/ahba8/Downloads/b10 all test cases, code.docx")));

    }
}
