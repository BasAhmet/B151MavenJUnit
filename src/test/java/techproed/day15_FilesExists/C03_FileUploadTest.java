package techproed.day15_FilesExists;

import org.junit.Assert;
import org.junit.Test;
import techproed.Utilities.TestBase;

import java.nio.file.Files;

public class C03_FileUploadTest extends TestBase {
    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalim

        //*******************************************************\\
        //xpath("//*[@id='file-upload']")//.click();
        //*******************************************************\\

        /*
        Eğer dosya seç butonuna basmamız istenirse ve otomasyon ile click yapılamıyorsa,
        direk uplad yapılacak dosyanın yolunu sendkeys ile upload yapabiliriz.
         */

        pause(2);
        xpath("//*[@id='file-upload']").sendKeys("C:/Users/ahba8/Desktop/upload.txt");
        pause(2);

        //Yuklemek istediginiz dosyayi secelim.

        //Upload butonuna basalim.
        xpath("//*[@id='file-submit']").click();
        pause(2);

        //"File Uploaded!" textinin goruntulendigini test edelim.
        Assert.assertTrue(xpath("//h3").isDisplayed());
    }
}
