import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CallBackTest {


    private WebDriver driver;

    @BeforeAll
    public static void setUpAll() {
        System.setProperty("webdriver.chrome.driver", "driver/win/chromedriver.exe");
    }

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
    }


    @AfterEach
    public void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    void webinarValidTestUpgraded() {
        driver.get("http://localhost:9999/");
        List<WebElement> textFields = driver.findElements(By.className("input__control"));
        textFields.get(0).sendKeys("Рафаэль Амброзиус-Кусто");
        textFields.get(1).sendKeys("+88005553535");
        driver.findElement(By.className("checkbox__box")).click();
        driver.findElement(By.tagName("button")).click();
        String actualText = driver.findElement(By.cssSelector("[data-test-id='order-success']")).getText().trim();
        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        assertEquals(expected, actualText);
    }


   //@Test
    //void notValidUserNameTest() {

        //driver.get("http://localhost:9999/");
        //List<WebElement> textFields = driver.findElements(By.className("input__control"));
 //       //textFields.get(0).sendKeys("Rafael Ambrozius-Kusto");
//        textFields.get(1).sendKeys("+88005553535");
  //      driver.findElement(By.className("checkbox__box")).click();
  //      driver.findElement(By.tagName("button")).click();
  //      String actualText = driver.findElement(By.className("input__sub")).getText().trim();
  //      String expected = "Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.";
 //       assertEquals(expected, actualText);

 //   }

 //   @Test
 //   void notValidPhoneNumberWithoutPlusTest() {

  //      driver.get("http://localhost:9999/");
 //       driver.findElement(By.cssSelector("[type ='text']")).sendKeys("Рафаэль Амброзиус-Кусто");
  //      driver.findElement(By.cssSelector("[type ='tel']")).sendKeys("88005553535");
  //      driver.findElement(By.className("checkbox__box")).click();
  //      driver.findElement(By.tagName("button")).click();
  //      String actualText = driver.findElement(By.cssSelector("[data-test-id='phone'].input_invalid.input__sub")).getText().trim();
  //      String expected = "Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.";
  //      assertEquals(expected, actualText);
    }





