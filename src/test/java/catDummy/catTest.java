package catDummy;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class catTest {
    @Test
    public void getCatDetails(){
        Response response=RestAssured.given()
                .baseUri("https://catfact.ninja/fact")
                .contentType(ContentType.JSON)
                .get()
                .then().log().all().extract().response();
        Assert.assertEquals(response.statusCode(), 200);
    }
}
