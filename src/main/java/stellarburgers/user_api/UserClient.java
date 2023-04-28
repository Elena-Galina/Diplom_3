package stellarburgers.user_api;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.*;
import static org.hamcrest.CoreMatchers.*;

import static stellarburgers.user_api.BaseSpecApi.*;

public class UserClient {
    static String userAccessToken;

    @Step("Передать запрос на создание пользователя (\"api/auth/register\")")
    public static Response newUserCreate(User user) {
        return given()
                .spec(getBaseSpecification())
                .body(user)
                .when()
                .post(PATH_USER);
    }

    @Step("Получить accessToken созданного пользователя.")
    public static String getUserAccessToken(Response newUser) {
        String accessToken =
                newUser.then()
                        .extract()
                        .path("accessToken");
        String[] accessTokenWithoutBearer = accessToken.split(" ");
        userAccessToken = accessTokenWithoutBearer[1];
        return userAccessToken;
    }

    @Step("Удалить тестовые данные пользователя после выполнения теста(\"api/auth/user\")")
    public static void userDelete(String userAccessToken) {
        given()
                .spec(getBaseSpecification())
                .auth().oauth2(userAccessToken)
                .when()
                .delete(PATH_DELETE_USER)
                .then().assertThat()
                .statusCode(SC_ACCEPTED)
                .and()
                .body("success", equalTo(true));
    }
}
