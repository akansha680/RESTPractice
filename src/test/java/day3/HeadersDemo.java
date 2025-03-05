package day3;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class HeadersDemo {

//    @Test(priority = 1)
    void testHeaders(){
        given()

                .when()
                    .get("https://google.com")
                .then()
                    .header("Content-Type","text/html; charset=ISO-8859-1")
                    .header("Content-Encoding","gzip")
                .log().all();
    }

    @Test(priority = 2)
    void getHeaders(){
        Response res = given()

                .when()
                .get("https://google.com");

//        //get single header value
//        String headerValue = res.getHeader("Content-Type");
//
//        System.out.println("HeaderVale: "+headerValue);

        //get all headers
        Headers myheaders = res.getHeaders();
        for(Header hd:myheaders){
            System.out.println(hd.getName()+"    "+hd.getValue());
        }
    }
}
