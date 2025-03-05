package day3;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class CookiesDemo {
  //  @Test(priority = 1)
    void testCookies(){
        given()

                .when()
                    .get("https://google.com")
                .then()
                    .cookie("AEC","AVcja2dL9X0W_gDjOLxtMAxhUPJofFB2Jauew70dhN0XNbayctGlcSbFVg; expires=Sun, 31-Aug-2025 15:50:18 GMT; path=/; domain=.google.com; Secure; HttpOnly; SameSite=lax")
                    .log().all();
    }

    @Test(priority = 2)
    void getCookiesInfo(){
       Response res = given()
                .when()
                .get("https://google.com");

//       //get single cookie info
//        String cookie_value = res.getCookie("AEC");
//        System.out.println("Value of cookie is"+cookie_value);

        //get all cookie info
        Map<String,String> cookies_values=res.getCookies();
//        System.out.println(cookies_values.keySet());

        for(String k:cookies_values.keySet()){
            String cookie_value=res.getCookie(k);
            System.out.println(k+"       "+cookie_value);
        }
    }
}
