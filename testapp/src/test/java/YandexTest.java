import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;

class YandexTest {
    static {
        RestAssured.requestSpecification = new RequestSpecBuilder().
                setBaseUri("https://api.rasp.yandex.net/v3.0").
                setContentType(ContentType.JSON).
                addHeader("Authorization", "47578f4e-0b00-45d2-be0d-2b263e9b5c04").
                build();
//        RestAssured.responseSpecification = new ResponseSpecBuilder().
//                build().
//                log().body();
//        RestAssured.filters(new AllureRestAssured());
    }
}
