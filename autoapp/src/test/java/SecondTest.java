import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SecondTest {

    private static WebDriver driver;

    @BeforeAll
    public static void setup() {
        final String from = "Кемерово проспект Ленина";
        final String to = "Кемерово Бакинский переулок";
        final String when = "среда";

        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.className("ErrorPageSearchForm__title")));
    }

    @AfterAll
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
