import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.hasItems;

class CarriersTest {

    private Map<String, Object> params;
    static {
        RestAssured.baseURI = Constants.YANDEXURL.getValue();
    }

    @BeforeEach
    void setupParams() {
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
                contentType(ContentType.JSON).
                header("Authorization",Constants.KEY.getValue()).
                params(params).
        when().
                get("/carrier").
        then().
                statusCode(200).
                body("carriers.code", hasItems(5483, 680));
    }

    @Test
    void carriers_unknown_code() {
        params.replace("code", "qwerty");
        given().
                contentType(ContentType.JSON).
                header("Authorization",Constants.KEY.getValue()).
                params(params).
        when().
                get("/carrier").
        then().
                statusCode(404).
                body("error.text", containsString("Не нашли компании по коду"));
    }

    @Test
    void carriers_without_code() {
        params.remove("code");
        given().
                contentType(ContentType.JSON).
                header("Authorization",Constants.KEY.getValue()).
                params(params).
        when().
                get("/carrier").
        then().
                statusCode(400).
                body("error.text", equalTo("code: Код перевозчика не указан."));
    }
}
