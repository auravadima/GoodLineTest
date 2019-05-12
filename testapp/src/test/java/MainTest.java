import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class MainTest{

    private final  String yandexHtml = "https://api.rasp.yandex.net/v3.0";
    private final String key = "47578f4e-0b00-45d2-be0d-2b263e9b5c04";

    // Nearest settlement tests
    @Test
    void nearest_settlement_standart_request() {
        given().
                baseUri(yandexHtml).
                contentType(ContentType.JSON).
                header("Authorization", key).
                param("format", "json").
                param("lat", 40).
                param("lng", 20).
                param("lang", "ru_RU").
                param("distance", 50).
                when().
                get("/nearest_settlement").
                then().
                statusCode(200).
                body("title", equalTo("Керкира"));
    }

    @Test
    void nearest_settlement_standart_request_uk() {
        given().
                baseUri(yandexHtml).
                contentType(ContentType.JSON).
                header("Authorization", key).
                param("format", "json").
                param("lat", 40).
                param("lng", 20).
                param("lang", "uk_UA").
                param("distance", 50).
                when().
                get("/nearest_settlement").
                then().
                statusCode(200).
                body("title", equalTo("Коркіра"));
    }

    @Test
    void nearest_settlement_distance_above_maximum() {
        given().
                baseUri(yandexHtml).
                contentType(ContentType.JSON).
                header("Authorization", key).
                param("format", "json").
                param("lat", 40).
                param("lng", 20).
                param("lang", "ru_RU").
                param("distance", 100).
                when().
                get("/nearest_settlement").
                then().
                statusCode(400).
                body("error.text", equalTo("distance: Параметр distance должен быть числом от 0 до 50, по умолчанию 10"));
    }

    // API тест не проходит, пишет, что сервис временно недоступен, хотя это не так!
    @Test
    void nearest_settlement_distance_equal_zero() {
        given().
                baseUri(yandexHtml).
                contentType(ContentType.JSON).
                header("Authorization", key).
                param("format", "json").
                param("lat", 40).
                param("lng", 20).
                param("lang", "ru_RU").
                param("distance", 0).
                when().
                get("/nearest_settlement").
                then().
                statusCode(400).
                body("error.text", equalTo("distance: Параметр distance должен быть числом от 0 до 50, по умолчанию 10"));
    }

    @Test
    void nearest_settlement_lat_above_maximum() {
        given().
                baseUri(yandexHtml).
                contentType(ContentType.JSON).
                header("Authorization", key).
                param("format", "json").
                param("lat", 91).
                param("lng", 20).
                param("lang", "ru_RU").
                param("distance", 50).
                when().
                get("/nearest_settlement").
                then().
                statusCode(400).
                body("error.text", equalTo("lat: Параметр lat должен быть числом в диапазоне от -90 до 90"));
    }

    @Test
    void nearest_settlement_lat_below_minimum() {
        given().
                baseUri(yandexHtml).
                contentType(ContentType.JSON).
                header("Authorization", key).
                param("format", "json").
                param("lat", -91).
                param("lng", 20).
                param("lang", "ru_RU").
                param("distance", 50).
                when().
                get("/nearest_settlement").
                then().
                statusCode(400).
                body("error.text", equalTo("lat: Параметр lat должен быть числом в диапазоне от -90 до 90"));
    }

    @Test
    void nearest_settlement_lng_below_minimum() {
        given().
                baseUri(yandexHtml).
                contentType(ContentType.JSON).
                header("Authorization", key).
                param("format", "json").
                param("lat", 40).
                param("lng", -181).
                param("lang", "ru_RU").
                param("distance", 50).
                when().
                get("/nearest_settlement").
                then().
                statusCode(400).
                body("error.text", equalTo("lng: Параметр lng должен быть числом в диапазоне от -180 до 180"));
    }

    @Test
    void nearest_settlement_lng_above_maximum() {
        given().
                baseUri(yandexHtml).
                contentType(ContentType.JSON).
                header("Authorization", key).
                param("format", "json").
                param("lat", 40).
                param("lng", 181).
                param("lang", "ru_RU").
                param("distance", 50).
                when().
                get("/nearest_settlement").
                then().
                statusCode(400).
                body("error.text", equalTo("lng: Параметр lng должен быть числом в диапазоне от -180 до 180"));
    }

    @Test
    void nearest_settlement_without_Lang() {
        given().
                baseUri(yandexHtml).
                contentType(ContentType.JSON).
                header("Authorization", key).
                param("format", "json").
                param("lat", 40).
                param("lng", 20).
                param("distance", 50).
                when().
                get("/nearest_settlement").
                then().
                statusCode(200).
                body("title", equalTo("Керкира"));
    }

    @Test
    void nearest_settlement_without_format() {
        given().
                baseUri(yandexHtml).
                contentType(ContentType.JSON).
                header("Authorization", key).
                param("lat", 40).
                param("lng", 20).
                param("lang", "ru_RU").
                param("distance", 50).
                when().
                get("/nearest_settlement").
                then().
                statusCode(200).
                body("title", equalTo("Керкира"));
    }

    @Test
    void nearest_settlement_without_lat() {
        given().
                baseUri(yandexHtml).
                contentType(ContentType.JSON).
                header("Authorization", key).
                param("format", "json").
                param("lng", 20).
                param("lang", "ru_RU").
                param("distance", 50).
                when().
                get("/nearest_settlement").
                then().
                statusCode(400).
                body("error.text", equalTo("lat: Не указан параметр lat."));
    }

    @Test
    void nearest_settlement_without_lng() {
        given().
                baseUri(yandexHtml).
                contentType(ContentType.JSON).
                header("Authorization", key).
                param("format", "json").
                param("lat", 40).
                param("lang", "ru_RU").
                param("distance", 50).
                when().
                get("/nearest_settlement").
                then().
                statusCode(400).
                body("error.text", equalTo("lng: Не указан параметр lng."));
    }

    @Test
    void nearest_settlement_without_distance() {
        given().
                baseUri(yandexHtml).
                contentType(ContentType.JSON).
                header("Authorization", key).
                param("format", "json").
                param("lat", 39.9).
                param("lng", 30.4).
                param("distance", 50).
                param("lang", "ru_RU").
                when().
                get("/nearest_settlement").
                then().
                statusCode(200).
                body("title", equalTo("Тепебашы"));
    }

    @Test
    void nearest_settlement_without_key() {
        given().
                baseUri(yandexHtml).
                contentType(ContentType.JSON).
                param("format", "json").
                param("lat", 40).
                param("lng", 20).
                param("lang", "ru_RU").
                param("distance", 50).
                when().
                get("/nearest_settlement").
                then().
                statusCode(400).
                body("error.text", equalTo("Не указан ключ"));
    }

    @Test
    void nearest_settlement_xml_test() {
        given().
                baseUri(yandexHtml).
                contentType(ContentType.XML).
                header("Authorization", key).
                param("format", "xml").
                param("lat", 40).
                param("lng", 20).
                param("lang", "ru_RU").
                param("distance", 50).
                when().
                get("/nearest_settlement").
                then().
                statusCode(200).
                body("response.short_title", equalTo("Керкира"));
    }

    // Carriers
    @Test
    void carriers_multiple_result_by_one_iata() {
        given().
                baseUri(yandexHtml).
                contentType(ContentType.JSON).
                header("Authorization", key).
                param("code", "TK").
                param("format", "json").
                param("lang", "ru_RU").
                param("system", "iata").
                when().
                get("/carrier").
                then().
                statusCode(200).
                body("carriers.code", hasItems(5483, 680));
    }

    @Test
    void carriers_unknown_code() {
        given().
                baseUri(yandexHtml).
                contentType(ContentType.JSON).
                header("Authorization", key).
                param("code", "qwerty").
                param("format", "json").
                param("lang", "ru_RU").
                param("system", "iata").
                when().
                get("/carrier").
                then().
                statusCode(404).
                body("error.text", containsString("Не нашли компании по коду"));
    }

    @Test
    void carriers_without_code() {
        given().
                baseUri(yandexHtml).
                contentType(ContentType.JSON).
                header("Authorization", key).
                param("format", "json").
                param("lang", "ru_RU").
                param("system", "iata").
                when().
                get("/carrier").
                then().
                statusCode(400).
                body("error.text", equalTo("code: Код перевозчика не указан."));
    }

    @Test
    void carriers_multiple_codes() {
        given().
                baseUri(yandexHtml).
                contentType(ContentType.JSON).
                header("Authorization", key).
                param("code", "SCH").
                param("code", "TK").
                param("format", "json").
                param("lang", "ru_RU").
                param("system", "iata").
                when().
                get("/carrier").
                then().
                statusCode(200).
                body("carriers.code", hasItems(5483, 680));
    }


    // Copyright
    @Test
    void threads_standart() {
        given().
                baseUri(yandexHtml).
                contentType(ContentType.JSON).
                header("Authorization", key).
                param("format", "json").
                when().
                get("/copyright").
                then().
                statusCode(200).
                body("copyright.text", equalTo("Данные предоставлены сервисом Яндекс.Расписания"));
    }
}
