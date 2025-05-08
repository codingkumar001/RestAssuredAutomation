package catDummy;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.RestUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LaptopTest extends LaptopAPI {
    @Test
    public void getLaptopDetails() throws IOException {
        Map payload=Payloads.laptopPayloadsMap("Samsung", "2025", "400 Euros", "M40","500 GB");
                Response response= createLaptopDetails(payload);
        Assert.assertEquals(response.statusCode(), 200);

    }


}
