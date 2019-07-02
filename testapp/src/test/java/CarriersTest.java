import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.hasItems;

class CarriersTest extends YandexTest {

    private static Map<String, Object> params;

    @BeforeAll
    static void setupParams() {
        params = new HashMap<String, Object>() {{
            put("code", "TK");
            put("format", "json");
            put("lang", "ru_RU");
            put("system", "iata");
        }};
    }

    @Test
    void carriers_multiple_result_by_one_iata() {
        given().
                params(params).
        when().
                get("/carrier").
        then().
                statusCode(200).
                body("carriers.code", hasItems(5483, 680));
    }

    @Test
    void carriers_without_code() {
        params.remove("code");
        given().
                params(params).
                when().
                get("/carrier").
                then().
                statusCode(400).
                body("error.text", equalTo("code: Код перевозчика не указан."));
    }

    @Test
    void carriers_unknown_code() {
        params.replace("code", "qwerty");
        given().
                params(params).
                when().
                get("/carrier").
                then().
                statusCode(404).
                body("error.text", containsString("Не нашли компании по коду"));
    }
}
