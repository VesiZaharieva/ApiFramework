package in.reqrest.tests.create;

import in.reqres.model.request.create.UserRequest;
import in.reqres.model.response.create.UserResponse;
import in.reqres.test.ApiTestBase;
import in.reqres.utils.ApiUtils;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

    public class CreateUserTests extends ApiTestBase {

        @Test
        public void testCreateUser() {
            UserRequest request = new UserRequest();
            request.setName("morpheus");
            request.setJob("leader");

            UserResponse userResponse = RestAssured.given()
                    .spec(ApiUtils.jsonRequestSpec())
                    .body(request)
                    .when()
                    .post("/users")
                    .then()
                    .statusCode(201)
                    .extract().as(UserResponse.class);

            assertNotNull(userResponse.getId());
            assertEquals(request.getName(), userResponse.getName());
            assertEquals(request.getJob(), userResponse.getJob());
            assertNotNull(userResponse.getCreatedAt());

        }
    }
}
