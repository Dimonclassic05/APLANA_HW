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
        driver.findElement(By.xpath("(.//a[text()='Телевизоры'])[2]")).click();
        driver.findElement(By.xpath("(.//input)[7]")).sendKeys("20000");
        driver.findElement(By.xpath(".//label[text()='LG']")).click();
        WebElement element = driver.findElement(By.xpath(".//label[text()='Samsung']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false);", element);
        element = driver.findElement(By.xpath("(.//button)[12]"));
        driver.findElement(By.xpath(".//label[text()='Samsung']")).click();
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false);", element);
        driver.findElement(By.xpath("(.//button)[12]")).click();
        List<WebElement> element2 = driver.findElements(By.xpath(".//div[contains(@class,'n-snippet-card2__title')]"));
        int kolvo=element2.size();
        if (kolvo==10){
            System.out.println("Действительно 10");
        }
        else{
            System.out.println("Элементов не 10");
        }

        WebElement perviy = driver.findElement(By.xpath(".//a[contains(@class,'link n-link_theme_blue')]"));
        //driver.findElement(By.xpath(".//input[@id='header-search']")).sendKeys(+perviy);


        driver.quit();

    }
}
