package day2;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

public class WaysToCreatePostRequestBody {

    //1. Post request body using HashMap
//    @Test(priority=1)
//    void testPostusingHashMap(){
//        HashMap data =new HashMap();
//        String courseArray[] = {"C","C++"};
//
//        data.put("name","Scott");
//        data.put("age","18");
//        data.put("grade","12th");
//        data.put("subjects",courseArray);
//
//
//        given()
//                .contentType("application/json")
//                        .body(data)
//                .when()
//                        .post("http://localhost:3000/students")
//                .then()
//                        .statusCode(201)
//                        .body("name",equalTo("Scott"))
//                        .body("age",equalTo("18"))
//                        .body("grade",equalTo("12th"))
//                        .body("subjects[0]",equalTo("C"))
//                        .body("subjects[1]",equalTo("C++"))
//                        .header("Content-Type","application/json")
//                        .log().all();
//    }



//    //POST request using org.json library
//    @Test(priority=1)
//    void testPostusingJsonLibrary(){
//        JSONObject data = new JSONObject();
//        String courseArray[] = {"C","C++"};
//
//        data.put("name","Scott");
//        data.put("age","18");
//        data.put("grade","12th");
//        data.put("subjects",courseArray);
//
//
//        given()
//                .contentType("application/json")
//                .body(data.toString())
//                .when()
//                .post("http://localhost:3000/students")
//                .then()
//                .statusCode(201)
//                .body("name",equalTo("Scott"))
//                .body("age",equalTo("18"))
//                .body("grade",equalTo("12th"))
//                .body("subjects[0]",equalTo("C"))
//                .body("subjects[1]",equalTo("C++"))
//                .header("Content-Type","application/json")
//                .log().all();
//    }


//    //POST request using POJO class
//    @Test(priority=1)
//    void testPostusingPOJOClass(){
//        String [] courseArray = {"C","C++"};
//        POJO_PostRequest data = new POJO_PostRequest();
//        data.setName("Scott");
//        data.setAge("18");
//        data.setGrade("12th");
//        data.setSubjects(courseArray);
//
//
//        given()
//                .contentType("application/json")
//                .body(data)
//                .when()
//                .post("http://localhost:3000/students")
//                .then()
//                .statusCode(201)
//                .body("name",equalTo("Scott"))
//                .body("age",equalTo("18"))
//                .body("grade",equalTo("12th"))
//                .body("subjects[0]",equalTo("C"))
//                .body("subjects[1]",equalTo("C++"))
//                .header("Content-Type","application/json")
//                .log().all();
//    }

    //POST request using External JSON file
    @Test(priority=1)
    void testPostusingPOJOClass() throws FileNotFoundException {
        File f = new File(".\\body.json");

        FileReader fr = new FileReader(f);
        JSONTokener jt = new JSONTokener(fr);

        JSONObject data = new JSONObject(jt);


        given()
                .contentType("application/json")
                .body(data.toString())
                .when()
                .post("http://localhost:3000/students")
                .then()
                .statusCode(201)
                .body("name",equalTo("Scott"))
                .body("age",equalTo("18"))
                .body("grade",equalTo("12th"))
                .body("subjects[0]",equalTo("C"))
                .body("subjects[1]",equalTo("C++"))
                .header("Content-Type","application/json")
                .log().all();
    }


    @Test(priority=2)
    void testDelete(){
        given()
                .when()
                .delete("http://localhost:3000/students/4")

                .then()
                .statusCode(404 );
    }


}
