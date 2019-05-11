import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class SecondTestList {

    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        final String from = "Кемерово проспект Ленина";
        final String to = "Кемерово Бакинский переулок";
        final String when = "среда";

        driver = Utils.createChromeDriverAtRasp(from, to, when, true);
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.className("ErrorPageSearchForm__title")));
    }

    @AfterClass
    public static void after() {
        if (driver != null) {
            driver.close();
        }
    }

    @Test
    public void not_found_flight_test() {
        assertEquals("Пункт прибытия не найден. Проверьте правильность написания или выберите другой город.",
                driver.findElement(By.cssSelector(".ErrorPageSearchForm__title:last-child")).getText());
    }
}
