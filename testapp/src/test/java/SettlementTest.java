import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

class SettlementTest extends YandexTest {

    private static Map<String, Object> params;

    @BeforeAll
    static void setupParams() {
        params = new HashMap<String, Object>() {{
            put("format", "json");
            put("lat", 40);
            put("lng", 20);
            put("lang", "ru_RU");
            put("distance", 50);
        }};
    }

    @Test
    void nearest_settlement_standart_request() {
        given().
                params(params).
        when().
                get("/nearest_settlement").
        then().
                statusCode(200).
                body("title", equalTo("Керкира"));
    }

    @Test
    void nearest_settlement_standart_request_uk() {
        params.replace("lang", "uk_UA");
        given().
                params(params).
        when().
                get("/nearest_settlement").
        then().
                statusCode(200).
                body("title", equalTo("Коркіра"));
    }

    @Test
    void nearest_settlement_xml_test() {
        params.replace("format", "xml");
        given().
                params(params).
        when().
                get("/nearest_settlement").
        then().
                statusCode(200).
                body("response.short_title", equalTo("Керкира"));
    }

    @Test
    void nearest_settlement_distance_above_maximum() {
        params.replace("distance", 100);
        given().
                params(params).
                when().
                get("/nearest_settlement").
                then().
                statusCode(400).
                body("error.text", equalTo("distance: Параметр distance должен быть числом от 0 до 50, по умолчанию 10"));
    }

    // API тест не проходит, пишет, что сервис временно недоступен, хотя это не так!
    @Test
    void nearest_settlement_distance_equal_zero() {
        params.replace("distance", 0);
        given().
                params(params).
                when().
                get("/nearest_settlement").
                then().
                statusCode(400).
                body("error.text", equalTo("distance: Параметр distance должен быть числом от 0 до 50, по умолчанию 10"));
    }

    @Test
    void nearest_settlement_lat_above_maximum() {
        params.replace("lat", 91);
        given().
                params(params).
                when().
                get("/nearest_settlement").
                then().
                statusCode(400).
                body("error.text", equalTo("lat: Параметр lat должен быть числом в диапазоне от -90 до 90"));
    }

    @Test
    void nearest_settlement_lat_below_minimum() {
        params.replace("lat", -91);
        given().
                params(params).
                when().
                get("/nearest_settlement").
                then().
                statusCode(400).
                body("error.text", equalTo("lat: Параметр lat должен быть числом в диапазоне от -90 до 90"));
    }

    @Test
    void nearest_settlement_lng_below_minimum() {
        params.replace("lng", -181);
        given().
                params(params).
                when().
                get("/nearest_settlement").
                then().
                statusCode(400).
                body("error.text", equalTo("lng: Параметр lng должен быть числом в диапазоне от -180 до 180"));
    }

    @Test
    void nearest_settlement_lng_above_maximum() {
        params.replace("lng", 181);
        given().
                params(params).
                when().
                get("/nearest_settlement").
                then().
                statusCode(400).
                body("error.text", equalTo("lng: Параметр lng должен быть числом в диапазоне от -180 до 180"));
    }

    @Test
    void nearest_settlement_without_Lang() {
        params.remove("lang");
        given().
                params(params).
                when().
                get("/nearest_settlement").
                then().
                statusCode(200).
                body("title", equalTo("Керкира"));
    }

    @Test
    void nearest_settlement_without_format() {
        params.remove("format");
        given().
                params(params).
                when().
                get("/nearest_settlement").
                then().
                statusCode(200).
                body("title", equalTo("Керкира"));
    }

    @Test
    void nearest_settlement_without_lat() {
        params.remove("lat");
        given().
                params(params).
                when().
                get("/nearest_settlement").
                then().
                statusCode(400).
                body("error.text", equalTo("lat: Не указан параметр lat."));
    }

    @Test
    void nearest_settlement_without_lng() {
        params.remove("lng");
        given().
                params(params).
                when().
                get("/nearest_settlement").
                then().
                statusCode(400).
                body("error.text", equalTo("lng: Не указан параметр lng."));
    }

    @Test
    void nearest_settlement_without_distance() {
        params.remove("distance");
        params.replace("lat", 56);
        params.replace("lng", 93);
        given().
                params(params).
                when().
                get("/nearest_settlement").
                then().
                statusCode(200).
                body("title", equalTo("Красноярск"));
    }
}
