package catDummy;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddObjects {
    String id = "";

    @Test
    public void addNewObject() {
        RestAssured.baseURI = "https://api.restful-api.dev/objects";
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "   \"name\": \"Apple MacBook Pro 16\",\n" +
                        "   \"data\": {\n" +
                        "      \"year\": 2019,\n" +
                        "      \"price\": 1849.99,\n" +
                        "      \"CPU model\": \"Intel Core i9\",\n" +
                        "      \"Hard disk size\": \"1 TB\"\n" +
                        "   }\n" +
                        "}")
                .post()
                .then().log().all().extract().response();
        Assert.assertEquals(response.statusCode(), 200);

        JsonPath jsonPath = response.jsonPath();
        id = jsonPath.getString("id");

        System.out.println("ID from POST response: " + id);
    }

    @Test
    public void getNewlyCreatedObject(){
        RestAssured.baseURI="https://api.restful-api.dev/objects/"+id+"";
        Response response=RestAssured.given()
                .contentType(ContentType.JSON)
                .get()
                .then().log().all().extract().response();
        Assert.assertEquals(response.statusCode(), 200);
    }

}
