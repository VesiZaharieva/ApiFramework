package in.reqrest.tests.registration;

package in.reqres.tests.registration;

import in.reqres.model.request.register.RegistrationRequest;
import in.reqres.test.ApiTestBase;
import in.reqres.utils.ApiUtils;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class RegistrationTests extends ApiTestBase {

    @Test
    public void testSuccessfulRegistration() {

        RegistrationRequest registrationRequest = new RegistrationRequest("eve.holt@reqres.in", "pistol");

        RestAssured.given()
                .spec(ApiUtils.jsonRequestSpec())
                .body(registrationRequest)
                .when()
                .post("/register")
                .then()
                .statusCode(200)
                .body("id", Matchers.notNullValue())
                .body("token", Matchers.notNullValue());
    }

    @Test
    public void testUnsuccessfulRegistration(){
        RegistrationRequest registrationRequest = new RegistrationRequest("eve.holt@reqres.in", null);

        RestAssured.given()
                //  .contentType(ContentType.JSON)
                .spec(ApiUtils.jsonRequestSpec())
                .body(registrationRequest)
                .when()
                .post("/register")
                .then()
                .statusCode(400)
                .body("error", Matchers.equalTo("Missing password"));

    }
}
