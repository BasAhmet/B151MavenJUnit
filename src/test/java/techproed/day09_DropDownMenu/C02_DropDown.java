package techproed.day09_DropDownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_DropDown {
    /*
    DROPDOWN --> Altbasliklarin oldugu acilir menu listesidir. Dropdown'u handle(outomate) etmek icin
    1-Dropdoen menu ilk olarak locate ederiz
    2-Select objesi olustururuz
    3-Select objesinin dropdown menu webelementinin icerigine ve seceneklerine erisim saglamasi icin
    SELECT sinifina argumen olarak locate ettigimiz webelement'i koyariz
    SYNTAX:
            Select select - new Select(ddm webelementi)
    4-Select class'i sadece <select> tagi ile olusturulmus dropdown menulere uygulanabilir
    5-Select objesi ddm'yu handle edebilmek icin 3 method kullanir
        -selectByVisibleText() --> Ddm deki elemente gorunur metin ile ulasmak icin kullanilir.
        -selectByIntex() --> Index ile ulasmak icin kullanilir(Index 0(sifir) dan baslar)
        -SelectByValue() --> Elementin degeri ile ulasmak icin kullanilir (option tag'larindaki deger ile)
   6-getoptions() -> Locate ettigimiz ddm'deki tum secenekleri bize verir.(Liste atip for loop ile yazdirabilirz)
   7-getFirstSelectedOption() --> Ddm'deki secili kalan secenegi bize verir. Birden fazla secenek secildigse,
   bu secilenlerin ilkini verir.
     */


    /*
Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
-3 farklı test methodu oluşturalım
    1.Method:
        a. Yil,ay,gün dropdown menu'leri locate ediniz
        b. Select objesi olustur
        c. Select object i kullaarak 3 farkli sekilde secim yapiniz
    2.Method:
        a. Tüm eyalet isimlerini yazdıralım
    3.Method:
        a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim

 */
    static WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @Test
    public void test01() {
        // Yil,ay,gün dropdown menu'leri locate ediniz
        WebElement year = driver.findElement(By.xpath("//*[@id='year']"));
        WebElement month = driver.findElement(By.xpath("//*[@id='month']"));
        WebElement day = driver.findElement(By.xpath("//*[@id='day']"));

        // Select objesi olustur
        Select select1 = new Select(year);
        Select select2 = new Select(month);
        Select select3 = new Select(day);

        // Select object i kullaarak 3 farkli sekilde secim yapiniz
        select1.selectByIndex(5);
        select2.selectByValue("6");
        select3.selectByVisibleText("15");

    }

    @Test
    public void test02() {
        // Tüm eyalet isimlerini yazdıralım
        WebElement states = driver.findElement(By.xpath("//*[@id='state']"));
        Select selectState = new Select(states);
        selectState.getOptions().forEach(w-> System.out.println(w.getText()));
        System.out.println("*******************************************");

        //2.yol
        List<WebElement> eyaletler = driver.findElements(By.xpath("//*[@id='state']"));
        eyaletler.forEach(w-> System.out.println(w.getText()));
    }

    @Test
    public void test03() {
        // State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim
        WebElement state = driver.findElement(By.xpath("//*[@id='state']"));
        Select select = new Select(state);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Select a State");
    }
}
