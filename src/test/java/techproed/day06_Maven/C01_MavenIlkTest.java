package techproed.day06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import techproed.Util;

import java.util.List;

public class C01_MavenIlkTest {
    public static void main(String[] args) {
        WebDriver driver = Util.chromDriver(15);

        // https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");

        // arama kutusunu locate edelim
        WebElement searchBox = driver.findElement(By.cssSelector("input#twotabsearchtextbox"));

        // “Samsung headphones” ile arama yapalim
        searchBox.sendKeys("Samsung headphones", Keys.ENTER);

        // Bulunan sonuc sayisini yazdiralim
        WebElement resultText = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        String[] resultSayisi = resultText.getText().split(" ");
        System.out.println("Sonuç Sayısı : " + resultSayisi[2]);

        // Ilk urunu tiklayalim
        WebElement firstProduct = driver.findElement(By.xpath("(//h2//a)[1]"));
        firstProduct.click();

        // Sayfadaki tum basliklari yazdiralim
        List<WebElement> headers = driver.findElements(By.xpath("//h1|//h2|//h3|//h4|//h5"));
        int count = 1 ;
        for (WebElement w : headers) {
            if(!w.getText().equals("")) {
                System.out.println(count + ". Başlık : " + w.getText());
                count++;
            }
        }
        System.out.println(headers.size());

    }
}
