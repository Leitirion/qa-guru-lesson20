package helpers;

import config.MobileConfig;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;

public class Browserstack {

    static MobileConfig config = ConfigFactory.create(MobileConfig.class, System.getProperties());

    public static String videoUrl(String sessionId) {
        return given()
                .auth().basic(config.getBrowserStackUser(), config.getBrowserStackKey())
                .when()
                .get("https://api-cloud.browserstack.com/app-automate/sessions/" + sessionId +".json")
                .then()
                .statusCode(200)
                .log().body()
                .extract()
                .response()
                .path("automation_session.video_url");

    }
}