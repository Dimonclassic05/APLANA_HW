import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ASUS on 02.03.2018.
 */
public class SberTest {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.sberbank.ru/ru/person");
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void TestSber(){
        Wait<WebDriver> wait = new WebDriverWait(driver,10,1000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//span[contains(text(),'Москва')]"))));
        driver.findElement(By.xpath(".//span[contains(text(),'Москва')]")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//a[contains(@data-id,'52')]"))));
        driver.findElement(By.xpath(".//a[contains(@data-id,'52')]")).click();
        WebElement element = driver.findElement(By.xpath(".//a[contains(@class,'region')]"));
        Assert.assertEquals("Выбрана не Нижегородская область", "Нижегородская область", element.getText());
        WebElement scrElement = driver.findElement(By.xpath(".//div[@class='social__wrapper']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false);", scrElement);
        driver.findElement(By.xpath(".//a[@tabindex='0']")).click();
        Assert.assertTrue("Не отображается значок Facebook", driver.findElement(By.xpath(".//span[contains(@class,'fb')]")).isDisplayed());
        Assert.assertTrue("Не отображается значок Twitter", driver.findElement(By.xpath(".//span[contains(@class,'tw')]")).isDisplayed());
        Assert.assertTrue("Не отображается значок YouTube", driver.findElement(By.xpath(".//span[contains(@class,'yt')]")).isDisplayed());
        Assert.assertTrue("Не отображается значок Instagram", driver.findElement(By.xpath(".//span[contains(@class,'ins')]")).isDisplayed());
        Assert.assertTrue("Не отображается значок Vkontakte", driver.findElement(By.xpath(".//span[contains(@class,'vk')]")).isDisplayed());
        Assert.assertTrue("Не отображается значок Odnoklassniki", driver.findElement(By.xpath(".//span[contains(@class,'ok')]")).isDisplayed());



    }

}
