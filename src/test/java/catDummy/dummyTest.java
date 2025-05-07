package catDummy;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.JsonUtils;
import utils.RestUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class dummyTest {
    @Test
    public void getLaptopDetails() throws IOException {
        System.out.println("Test Environment: " +System.getProperty("env"));
        String env=System.getProperty("env")==null? "dev":System.getProperty("env");
        Map<String, String> data= JsonUtils.getJsonDataAsMap(""+env+"/laptopConfig.json");
        String endpoint=data.get("laptopEndpoint");
        System.out.println("Print"+endpoint);
//        String payload=Payloads.laptopPayloads("Apple", "2025", "400 Euros", "M40","500 GB");
        Map payload=Payloads.laptopPayloadsMap("Apple", "2025", "200 Euros", "M40","500 GB");
                Response response= RestUtils.performPost(endpoint,payload, new HashMap<String, String>());
        Assert.assertEquals(response.statusCode(), 200);

    }


}
