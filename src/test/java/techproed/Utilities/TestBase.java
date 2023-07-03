package techproed.Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class TestBase {
    /*
     TestBase class'indan obje olusturmanin onune gecmek icin bu class'i abstract yapabiliriz
     TestBase testBase new = TestBase(); yani bu sekilde obje olusturmanin onune gecmis oluruz
     Bu class'a extends yaptigimiz test class'larindan ulabiliriz
 */
    protected WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        extentReports = new ExtentReports();
        //driver.quit();
    }
    //Hard Wait
    public void pause(float second){
        try {
            Thread.sleep((long) (second*1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Selenium Wait/Explicit Wait
    //visibiltyOf(element)
    public void visibleWait(WebElement element,int second){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(second));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    //visibilityOfElementLocated(locator)
    public void visibleWait(By locator,int second){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(second));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    //AlertWait
    public void alertWait(int second){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(second));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    //FluentWait
    public void visibleFluentWait(WebElement element,int second,int millis){
        new FluentWait<>(driver).
                withTimeout(Duration.ofSeconds(second)).
                pollingEvery(Duration.ofMillis(millis)).
                until(ExpectedConditions.visibilityOf(element));
    }


    //AcceptAlert
    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }
    //DissmisAlert
    public void dissmisAlert(){
        driver.switchTo().alert().dismiss();
    }
    //getTextAlert
    public String getTextAlert(){
        return driver.switchTo().alert().getText();
    }
    //sendKeysAlert
    public void sendKeysAlert(String text){
        driver.switchTo().alert().sendKeys(text);
    }
    //DropDown VisibleText
    public void selectVisibleText(WebElement ddm,String text){
        Select select = new Select(ddm);
        select.selectByVisibleText(text);
    }
    //DropDown Index
    public void selectIndex(WebElement ddm,int index){
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }
    //DropDown Value
    public void selectValue(WebElement ddm,String value){
        Select select = new Select(ddm);
        select.selectByValue(value);
    }
    //xpath
    public WebElement xpath(String xpath){
        return driver.findElement(By.xpath(xpath));
    }
    //xpaths
    public List<WebElement> xpaths(String xpath){
        return driver.findElements(By.xpath(xpath));
    }
    //switchToWindow
    public void switchToWindow(int index){
        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(index));
    }
    //FullScreenShot
    public void fullScreenShot(){
        String date = new SimpleDateFormat("_dd.MM.yyyy_hh;mm;ss]").format(new Date());
        TakesScreenshot tss = (TakesScreenshot) driver;
        String path = "src/test/java/techproed/fullScreenShot/screenShot";
        try {
            FileUtils.copyFile(tss.getScreenshotAs(OutputType.FILE),new File( path + date + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    //WebElement Screen shot
    public void webElementScreenShot(WebElement element){
        String date = new SimpleDateFormat("[dd.MM.yyyy][hh;mm;ss]").format(new Date());
        String path = "src/test/java/techproed/webElementScreenShot/screenShot" + date + ".png";
        try {
            FileUtils.copyFile(element.getScreenshotAs(OutputType.FILE),new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //UploadFile Robot Class
    public void uploadFilePath(String filePath) {
        try {
            pause(3);
            StringSelection stringSelection = new StringSelection(filePath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            pause(3);
            robot.keyPress(KeyEvent.VK_V);
            pause(3);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            pause(3);
            robot.keyRelease(KeyEvent.VK_V);
            pause(3);
            robot.keyPress(KeyEvent.VK_ENTER);
            pause(3);
            robot.keyRelease(KeyEvent.VK_ENTER);
            pause(3);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }
    //Extent Report Methodu
    protected ExtentReports extentReports;//--> Raporlamayı başlatmak için kullanılan class.
    protected ExtentHtmlReporter extentHtmlReporter;//--> raporu html formatında düzenler.
    protected ExtentTest extentTest;//--> Test adımlarına eklemek istediğimiz bilgileri bu class ile oluştururuz.
    public void extentReport(String browser, String reportName){
        extentReports = new ExtentReports();
        String date = new SimpleDateFormat("_dd.MM.yyyy_hh;mm;ss_").format(new Date());
        String filePath = "src/test/java/techproed/extentReport_WebTable/extentTest" + date + ".html";
        extentHtmlReporter = new ExtentHtmlReporter(filePath);
        extentReports.attachReporter(extentHtmlReporter);//--> Html formatında raporlamayı başlatacak

        //Raporda gözükmesini istediğimiz bilgiler için
        extentReports.setSystemInfo("Browser",browser);
        extentReports.setSystemInfo("Tester","Ahmet");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName(reportName);
    }
    //Click Method
    public void click(WebElement element){
        try {
            element.click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0],click();",element);
        }
    }
}
