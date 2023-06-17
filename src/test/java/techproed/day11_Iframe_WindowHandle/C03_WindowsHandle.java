package techproed.day11_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import techproed.Utilities.TestBase;

public class C03_WindowsHandle extends TestBase {
    @Test
    public void windowHandle() {
        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");

        //Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        Assert.assertEquals(driver.getTitle(),"Techpro Education | Online It Courses & Bootcamps");
        String techproWindowHandle = driver.getWindowHandle();

        //Window 2'de https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.youtube.com");
        String youtubeWindowHandle = driver.getWindowHandle();

        //Window 3'te https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.linkedin.com");
        String linkdenWindowHandle = driver.getWindowHandle();
        pause(2);

        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(techproWindowHandle);
        pause(2);

        //youtube sayfasına geçiniz:
        driver.switchTo().window(youtubeWindowHandle);
        pause(2);

        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkdenWindowHandle);
        pause(2);
    }
}
