package techproed.day13_Cookies_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import techproed.Utilities.TestBase;

import java.util.Arrays;
import java.util.Set;

public class C01_Cookies extends TestBase {
    @Test
    public void test01() {
        // 1-Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        // 2-tum cookie’leri listeleyin
        /*
            Cookie'leri listelemek istersek
            driver.manage().getCookies() methodu ile bir Set ya da ArraList'e atarak listeyebiliriz
        */

        // Arrays.stream(driver.manage().getCookies().toArray()).forEach(System.out::println);

        Set<Cookie> cookieSet = driver.manage().getCookies();
        int count = 1;
        for (Cookie w : cookieSet) {
            System.out.print(count + ". Cookie : ");
            System.out.println(w.getName());
            count++;
        }


        // 3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Assert.assertTrue(cookieSet.size()>5);

        // 4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        // 1.yol
        /*
        for (Cookie w : cookieSet) {
            if(w.getName().equals("i18n-prefs")){
                Assert.assertTrue(w.getValue().equals("USD"));
            }
        }
        */
        // 2.yol
        String actualCookieValue = driver.manage().getCookieNamed("i18n-prefs").getValue();
        String expectedCookieValue = "USD";
        Assert.assertEquals(expectedCookieValue,actualCookieValue);

        // 5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
        Cookie cookie = new Cookie("en sevdigim cookie", "cikolatali");
        driver.manage().addCookie(cookie);

        // 6-eklediginiz cookie’nin sayfaya eklendigini test edin
        Assert.assertTrue(driver.manage().getCookieNamed("en sevdigim cookie").getValue().equals("cikolatali"));
        cookieSet = driver.manage().getCookies();

        // 7-ismi skin olan cookie’yi silin ve silindigini test edin
        int silinmedenOnce = cookieSet.size();
        System.out.println("Silinmeden Once Cookie Sayisi = "+silinmedenOnce);
        bekle(2);
        driver.manage().deleteCookieNamed("skin");//-->ismi skin olan cookie'yi sildik
        bekle(2);
        cookieSet = driver.manage().getCookies();//Silindikten sonra cookieSet'e yine atama yapiyoruz aksi taktirde fail aliriz
        int silindiktenSonra = cookieSet.size();
        System.out.println("Silindikten Sonra Cookie Sayisi = "+silindiktenSonra);
        Assert.assertEquals(1,(silinmedenOnce-silindiktenSonra));

        // 8-tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cookieSet = driver.manage().getCookies();
        Assert.assertTrue(cookieSet.isEmpty());
    }

}
