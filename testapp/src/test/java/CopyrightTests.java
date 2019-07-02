import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class CopyrightTests {

    static {
        RestAssured.baseURI = Constants.YANDEXURL.getValue();
    }

    @Test
    void threads_standart() {
        given().

                contentType(ContentType.JSON).
                header("Authorization",Constants.KEY.getValue()).
                param("format", "json").
                when().
                get("/copyright").
                then().
                statusCode(200).
                body("copyright.text", equalTo("Данные предоставлены сервисом Яндекс.Расписания"));
    }
}
