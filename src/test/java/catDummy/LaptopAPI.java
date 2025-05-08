package catDummy;

import io.restassured.response.Response;
import utils.RestUtils;

import java.util.HashMap;
import java.util.Map;

public class LaptopAPI {
    public Response createLaptopDetails(Map<String, Object> createLaptopPayload){
        String endpoint= Base.dataFromJsonFile.get("laptopEndpoint").toString();
        return RestUtils.performPost(endpoint,createLaptopPayload, new HashMap<>());
    }
}
