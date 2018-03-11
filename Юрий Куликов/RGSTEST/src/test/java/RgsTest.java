import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;

/**
 * Created by Дмитрй on 05.03.2018.
 */
public class RgsTest {
    private WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.rgs.ru");
    }

    @After
    public void tearDown() {driver.close();}


    @Test
    public void insurance() {
        WebElement navbar = driver.findElement(By.xpath(".//div[contains(@class,'navbar')]"));
        navbar.findElement(By.xpath(".//a[contains(text(),'Страхование')]")).click();
        navbar.findElement(By.xpath(".//a[contains(text(),'ДМС')]")).click();
        Assert.assertEquals("Заголовок ДМС не соответствует", "ДМС 2018 \uD83D\uDE91 Добровольное медицинское страхование, рассчитать стоимость в Росгосстрахе", driver.getTitle());
        Wait<WebDriver> wait = new WebDriverWait(driver,3,100);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//a[contains(text(),'Отправить заявку')]"))).click();
        //String findTitle = driver.findElement(By.xpath(".//b[text()='Заявка на добровольное медицинское страхование']")).getText();
        //Assert.assertEquals("Это не заявка","Заявка на добровольное медицинское страхование", findTitle);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[@class='modal-content']")));
        WebElement window = driver.findElement(By.xpath(".//div[@class='modal-content']"));
        window.findElement(By.xpath(".//label[text()='Фамилия']/following-sibling::input")).sendKeys("Петров");
        window.findElement(By.xpath(".//label[text()='Имя']/following-sibling::input")).sendKeys("Петр");
        window.findElement(By.xpath(".//label[text()='Отчество']/following-sibling::input")).sendKeys("Петрович");
        WebElement element = driver.findElement(By.xpath(".//select"));
        Select select = new Select(element);
        select.selectByVisibleText("Еврейская АО");
        window.findElement(By.xpath(".//label[text()='Телефон']/following-sibling::input")).sendKeys("9999871452");
        window.findElement(By.xpath(".//label[text()='Эл. почта']/following-sibling::input")).sendKeys("qwertyqwerty");
        window.findElement(By.xpath(".//textarea")).sendKeys("Test");
        window.findElement(By.xpath(".//label/input[contains(@class,'checkbox')]")).click();
        window.findElement(By.xpath(".//button[@id='button-m']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Введите адрес электронной почты']")));
        String errorMail = driver.findElement(By.xpath(".//span[text()='Введите адрес электронной почты']")).getText();
        Assert.assertNotEquals("Почта не прошла проверку", "Введите адрес электронной почты", errorMail);









    }



}
