import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

class CopyrightTest extends YandexTest {

    @Test
    void threads_standart() {
        given().
                param("format", "json").
        when().
                get("/copyright").
        then().
                statusCode(200).
                body("copyright.text", equalTo("Данные предоставлены сервисом Яндекс.Расписания"));
    }
}
