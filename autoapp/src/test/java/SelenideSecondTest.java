import Pages.MainPage;
import Pages.ResultPage;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SelenideSecondTest {

    private final static String from = "Кемерово проспект Ленина";
    private final static String to = "Кемерово Бакинский переулок";
    private final static String when = "среда";

    private static ResultPage resultPage;

    @BeforeAll
    public static void setup() {
        MainPage mainPage = new MainPage();
        mainPage.setFromField(from);
        mainPage.setToField(to);
        mainPage.setWhen(when);
        resultPage = mainPage.submit();
    }

    @Test
    public void not_found_flight_test() {
        resultPage.getErrorElement().shouldHave(
                Condition.matchesText("Пункт прибытия не найден. Проверьте правильность написания или выберите другой город."));
    }
}
