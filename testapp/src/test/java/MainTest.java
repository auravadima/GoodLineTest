import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class MainTest{

    @Test
    void carriers_multiple_result_by_one_iata() {
        given().
                
                contentType(ContentType.JSON).
                header("Authorization",Constants.KEY.getValue()).
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
                
                contentType(ContentType.JSON).
                header("Authorization",Constants.KEY.getValue()).
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
                
                contentType(ContentType.JSON).
                header("Authorization",Constants.KEY.getValue()).
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
                
                contentType(ContentType.JSON).
                header("Authorization",Constants.KEY.getValue()).
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
