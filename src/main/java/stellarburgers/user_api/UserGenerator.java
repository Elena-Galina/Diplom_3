package stellarburgers.user_api;

import net.datafaker.Faker;
import java.util.Locale;

public class UserGenerator {
    public static User randomeUser() {
        return new User()
                .setName(randomName())
                .setEmail(randomEmail())
                .setPassword(randomPassword());
    }

    public static String randomName() {
        Faker faker = new Faker(new Locale("en-US"));
        return faker.name().firstName();
    }

    public static String randomPassword() {
        Faker faker = new Faker();
        return faker.text().text(6, 10);
    }

    public static String randomInvalidPassword() {
        Faker faker = new Faker();
        return faker.text().text(2, 4);
    }

    public static String randomEmail() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }
}
