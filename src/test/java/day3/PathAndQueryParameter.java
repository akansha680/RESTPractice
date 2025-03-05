package day3;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PathAndQueryParameter {

    @Test
    void testQueryAndParameneter(){

        given()
                .pathParams("mypath","users")  //path parameters
                .queryParam("page",2)
                .queryParam("id",5)
                .when()
                     .get("https://reqres.in/api/{mypath}")

                .then()
                     .statusCode(200)
                     .log().all();
    }
}
