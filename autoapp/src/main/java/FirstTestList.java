import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class FirstTestList {

    private static WebDriver driver;
    private static List<WebElement> flights;

    @BeforeClass
    public static void setup() throws InterruptedException {
        final String from = "Кемерово";
        final String to = "Москва";
        final String when = "7 июля";
        driver = Utils.createChromeDriverAtRasp(from, to, when, false);
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().startsWith(String.format("Расписание транспорта %s — %s", from, to));
            }
        });
        Thread.sleep(100);
        flights = driver.findElements(By.className("SearchSegment"));
    }

    @AfterClass
    public static void after() {
        if (driver != null) {
            driver.close();
        }
    }

    @Test
    public void flight_name_test() {
        boolean isNameExists = true;
        for (WebElement flight :
                flights) {
            if (!flight.findElement(By.className("SegmentTitle__header")).getText().contains("Кемерово — Москва")) {
                isNameExists = false;
                break;
            }
        }
        assertTrue(isNameExists);
    }

    @Test
    public void flight_count_test() {
        Assert.assertEquals(4, flights.size());
    }

    @Test
    public void flight_icon_test() {
        boolean isIconExist = true;
        for (WebElement flight :
                flights) {
            if (flight.findElement(By.className("TransportIcon__icon")) == null) {
                isIconExist = false;
                break;
            }
        }
        assertTrue(isIconExist);
    }

    @Test
    public void flight_time_test() {
        boolean isTimeExist = true;
        for (WebElement flight :
                flights) {
            WebElement flightDuration = flight.findElement(By.className("SearchSegment__duration"));
            if (flightDuration.getText() == null || flight.getText().length() == 0) {
                System.out.println(flightDuration.getText());
                isTimeExist = false;
                break;
            }
        }
        assertTrue(isTimeExist);
    }
}
