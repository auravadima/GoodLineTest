import Pages.MainPage;
import Pages.ResultPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirefoxSecondTest {

    private static WebDriver driver;
    private static ResultPage resultPage;

    @BeforeAll
    public static void setup() {
        final String from = "Кемерово проспект Ленина";
        final String to = "Кемерово Бакинский переулок";
        final String when = "среда";

        driver = Utils.createFirefoxDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.setFromField(from);
        mainPage.setToField(to);
        mainPage.setWhen(when);
        resultPage = mainPage.submit();
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.className("ErrorPageSearchForm__title")));
    }

    @AfterAll
    public static void after() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    @Test
    public void not_found_flight_test() {
        assertEquals("Пункт прибытия не найден. Проверьте правильность написания или выберите другой город.",
                resultPage.getErrorElement().getText());
    }
}
