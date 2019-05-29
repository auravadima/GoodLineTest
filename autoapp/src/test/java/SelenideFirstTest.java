import Pages.MainPage;
import Pages.ResultPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SelenideFirstTest {

    private static ResultPage resultPage;

    private final static String from = "Кемерово";
    private final static String to = "Москва";
    private final static String when = "7 июля";

    @BeforeAll
    public static void setup() {
        MainPage mainPage = new MainPage();
        mainPage.setFromField(from);
        mainPage.setToField(to);
        mainPage.setWhen(when);
        resultPage = mainPage.submit();
    }

    @Test
    public void flight_name_test() {
        resultPage.getNames().shouldHaveSize(3);
//        $$(By.className("SegmentTitle__title")).shouldHaveSize(3);
    }

    @Test
    public void flight_count_test() {
        resultPage.getFlights().shouldHaveSize(3);
//        $$(By.className("SearchSegment")).shouldHaveSize(3);
    }

    @Test
    public void flight_icon_test() {
        resultPage.getIcons().shouldHaveSize(3);
//        $$(By.className("TransportIcon__icon")).shouldHaveSize(3);
    }
}
