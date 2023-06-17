package techproed.day12_WindowHandles;

import org.junit.Assert;
import org.junit.Test;
import techproed.Utilities.TestBase;

public class C02_BasicAuthentication extends TestBase {
    @Test
    public void test01() {
        // Aşağıdaki bilgileri kullanarak authentication yapınız:
        // Url: https://the-internet.herokuapp.com/basic_auth
        driver.get("https://the-internet.herokuapp.com/basic_auth");
        pause(3);
        // Username: admin
        // Password: admin
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        // Başarılı girişi doğrulayın.
        Assert.assertTrue(xpath("//*[@id='content']/div/p").isDisplayed());
    }
}
