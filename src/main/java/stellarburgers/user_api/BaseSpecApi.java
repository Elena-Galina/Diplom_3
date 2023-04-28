package stellarburgers.user_api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseSpecApi {

    public static String BASE_URI = "https://stellarburgers.nomoreparties.site/";
    public static String PATH_USER = "api/auth/register";
    public static String PATH_DELETE_USER = "api/auth/user";

    public static RequestSpecification getBaseSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setContentType(ContentType.JSON)
                .build();
    }
}
