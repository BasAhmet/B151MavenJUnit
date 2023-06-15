package techproed.day12_WindowHandles;

import org.junit.Assert;
import org.junit.Test;
import techproed.Utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C01_WindowHandels extends TestBase {
    @Test
    public void test01() {
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfasının Handle degerini alın yazdırın
        String firstPageHandle = driver.getWindowHandle();
        System.out.println(firstPageHandle);

        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        Assert.assertEquals(xpath("//h3").getText(),"Opening a new window");

        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        Assert.assertEquals(driver.getTitle(),"The Internet");

        //  "Click Here" butonuna tıklayın.
        xpath("(//a)[2]").click();//--> Kontrolümüz dışında Yeni bir sekme açıldı
        bekle(1);

        /*
            Bir button'a click yaptigimizda kontrolumuz disinda yeni bir sekme ya da pencere acilirsa , yeni acilan pencerenin
            handle degerini bilmedigim icin normal getWindowHandle ile driver'imi yeni pencereye geciremem. Bunu getWindowHandles()
            methoduyla acilan tum pencereleri bir Set'e assign edip , ilk actigimiz pencere degilse ikinci acilan yeni penceredir
            mantigiyla bir loop icinde cozebiliriz
         */
        Set<String> windowsHandles = driver.getWindowHandles();
        for (String w : windowsHandles) {
            if (!w.equals(firstPageHandle)){
                driver.switchTo().window(w);
            }
        }

        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        Assert.assertEquals(driver.getTitle(),"New Window");
        bekle(1);
        String secondPageHandle = driver.getWindowHandle();

        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(firstPageHandle);
        Assert.assertEquals(driver.getTitle(),"The Internet");
        bekle(1);

        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(secondPageHandle);
        bekle(1);

        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(firstPageHandle);
        bekle(1);
    }

    @Test
    public void test02() {
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfasının Handle degerini alın yazdırın
        System.out.println(driver.getWindowHandle());

        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        Assert.assertEquals(xpath("//h3").getText(),"Opening a new window");

        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        Assert.assertEquals(driver.getTitle(),"The Internet");

        //  "Click Here" butonuna tıklayın.
        xpath("(//a)[2]").click();//--> Kontrolümüz dışında Yeni bir sekme açıldı
        bekle(1);

        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        List<String> windowsHandles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowsHandles.get(1));
        /*
        getWindowHandles() methodunu kullanarak acilan tum pencerelerin handle degerlerini bir arraylist' e atadık
        Index 0(sifir)'dan basladigi icin kontrolum disinda acilan pencere 1. index de oldugundan
        driver.switchTo().window(pencereler.get(1)); ile yeni acilan pencereye gecis yaptik
         */
        Assert.assertEquals(driver.getTitle(),"New Window");
        bekle(1);

        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        Assert.assertEquals(driver.getTitle(),"The Internet");
        driver.switchTo().window(windowsHandles.get(0));
        bekle(1);

        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(windowsHandles.get(1));
        bekle(1);

        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(windowsHandles.get(0));
        bekle(1);
    }

    @Test
    public void test03() {
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfasının Handle degerini alın yazdırın
        System.out.println(driver.getWindowHandle());

        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        Assert.assertEquals(xpath("//h3").getText(),"Opening a new window");

        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        Assert.assertEquals(driver.getTitle(),"The Internet");

        //  "Click Here" butonuna tıklayın.
        xpath("(//a)[2]").click();//--> Kontrolümüz dışında Yeni bir sekme açıldı
        bekle(1);

        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        Assert.assertEquals(driver.getTitle(),"New Window");
        bekle(1);

        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
        Assert.assertEquals(driver.getTitle(),"The Internet");
        bekle(1);

        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        bekle(1);

        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
        bekle(1);
    }
}
