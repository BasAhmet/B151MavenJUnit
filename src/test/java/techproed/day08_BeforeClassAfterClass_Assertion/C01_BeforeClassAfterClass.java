package techproed.day08_BeforeClassAfterClass_Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_BeforeClassAfterClass {
    /*
    @BeforeClass ve @AfterClass methodları static olmalı
    */
    static WebDriver driver;

    @BeforeClass
    public static void beforeClass() throws Exception {
        WebDriverManager.chromedriver();
        driver = new ChromeDriver();
    }

    @AfterClass
    public static void afterClass() throws Exception {
        driver.close();
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Her methoddan önce bir kez çalışır.");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Her methoddan sonra bir kez çalışır.");
    }

    @Test
    public void test1() {
        System.out.println("1.Test methodu çalıştı");
    }

    @Test
    public void test2() {
        System.out.println("2.Test methodu çalıştı");
    }

    @Test
    public void test3() {
        System.out.println("3.Test methodu çalıştı");
    }
}
