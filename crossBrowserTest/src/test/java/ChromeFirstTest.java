import Pages.MainPage;
import Pages.ResultPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChromeFirstTest {

    private static WebDriver driver;

    private static ResultPage resultPage;

    @BeforeAll
    public static void setup() throws InterruptedException {
        final String from = "Кемерово";
        final String to = "Москва";
        final String when = "7 июля";
        driver = Utils.createChromeDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.setFromField(from);
        mainPage.setToField(to);
        mainPage.setWhen(when);
        resultPage = mainPage.submit();
        (new WebDriverWait(driver, 10)).until((ExpectedCondition<Boolean>) d ->
                d.getTitle().startsWith(String.format("Расписание транспорта %s — %s", from, to)));
        Thread.sleep(1000);
    }

    @AfterAll
    public static void after() {
        if (driver != null) {
            driver.close();
        }
    }

    @Test
    public void flight_name_test() {
        assertEquals(4, resultPage.getNames().size());
    }

    @Test
    public void flight_count_test() {
        assertEquals(4, resultPage.getFlights().size());
    }

    @Test
    public void flight_icon_test() {
        assertEquals(4, resultPage.getIcons().size());
    }

    @Test
    public void flight_time_test() {
        assertEquals(4, resultPage.getDurations().size());
    }
}
