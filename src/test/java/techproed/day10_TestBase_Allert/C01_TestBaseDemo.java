package techproed.day10_TestBase_Allert;

import org.junit.Assert;
import org.junit.Test;
import techproed.Utilities.TestBase;

public class C01_TestBaseDemo extends TestBase {
    @Test
    public void test01() {
        //Techproeducation sayfasina gidelim
        driver.get("https://www.techproeducation.com");
        bekle(2);

        //Basligin Bootcamp icerdigini test edelim
        Assert.assertTrue(driver.getTitle().contains("Bootcamp"));
        bekle(2);
    }
}
