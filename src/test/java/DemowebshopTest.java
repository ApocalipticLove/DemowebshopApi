import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class DemowebshopTest {

        @BeforeAll
        public static void setUp() {
            RestAssured.baseURI = "https://demowebshop.tricentis.com";
        }

        @Test
        void newsletterSubscribetTest() {
                String cookieValue = "5975187981C1130CDB983AA0A71E57D1D0E339EB209E215F00B92D42B018D53EA5FE51"+
                        "F59A20E8992253074ABFBC488D84FBE3EA9F734F1CF44D2D4A585342925FCE82D369FE9761715BCF220"+
                        "82D9D95C1B5D9DD9A6911F23126270A4AD256C5FA221AC744B97BB25BBADC70FF3AD958DF862EAB0B7C"+
                        "A717583EE2A20C73C4EA;",
                        body = "email=123@gmail.com";

                given()
                        .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                        .cookie("NOPCOMMERCE.AUTH", cookieValue)
                        .body(body)
                        .when()
                        .post("/subscribenewsletter")
                        .then()
                        .log().all()
                        .statusCode(200)
                        .body("Success", is(true))
                        .body("Result", is("Thank you for signing up! A verification email has been sent. We appreciate your interest."));
        }
}
