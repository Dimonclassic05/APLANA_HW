import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;
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

import java.util.List;

/**
 * Created by Дмитрй on 28.02.2018.
 */
public class yanTest {

    private WebDriver driver;


    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.yandex.ru/");
    }

    @After
    public void tearDown(){driver.close();}

    @Test
    public void testyan(){

        driver.findElement(By.xpath(".//a[contains(text(), 'Маркет')]")).click();
        driver.findElement(By.xpath(".//a[contains(text(), 'Электроника')]")).click();
        driver.findElement(By.xpath(".//div[contains(@class,'catalog-menu__list')]/a[text()='Телевизоры']")).click();
        driver.findElement(By.xpath(".//input[@name='glf-pricefrom-var']")).sendKeys("20000");
        driver.findElement(By.xpath(".//label[text()='LG']")).click();
        WebElement element = driver.findElement(By.xpath(".//label[text()='Samsung']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false);", element);
        driver.findElement(By.xpath(".//label[text()='Samsung']")).click();
        element = driver.findElement(By.xpath(".//div[@class='n-filter-panel-aside__apply']/button"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false);", element);
        element.click();
        List<WebElement> element2 = driver.findElements(By.xpath(".//div[contains(@class,'n-snippet-card2__title')]"));
        int kolvo=element2.size();

        WebElement element3 = driver.findElement(By.xpath(".//div[contains(@class,'title')]/a"));
        String element4 = element3.getText();
        driver.findElement(By.xpath(".//input[@id='header-search']")).sendKeys(element4);
        driver.findElement(By.xpath(".//button")).click();
        WebElement element5 = driver.findElement(By.xpath(".//h1"));
        String element6 = element5.getText();
        Assert.assertEquals("Не верный поиск",element4,element6);


    }
}
