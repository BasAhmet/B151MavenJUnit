package techproed.day17_Exceptions;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class C03_NullPointerException {
        /*
        NULL_POINTER_EXCEPTION
              Obje yada değişken oluşturup bunlara atama yapmadığımız zaman direk oluşturmuş olduğumuz
           obje yada değişkeni kullanmak istersek nullPointerException hatasi alırız.
         */
    WebDriver driver;
    Faker faker;
    Actions actions;
    int sayi;
    String name;
    @Test
    public void test01() {
         /*driver = new ChromeDriver(); normalde bu atamayi yapmamiz gerekir.
         Bu atamayi yapmadigimiz taktirde ya da unuttugumuz zaman NullPointerException hatasi aliriz
         */
        driver.get("https://www.amazon.com");
    }

    @Test
    public void test02() {
        faker.number().digits(11);
    }

    @Test
    public void test03() {
        actions.click().perform();
    }

    @Test
    public void test04() {
        System.out.println(sayi);
    }

    @Test
    public void test05() {
        System.out.println(name);
    }
}
