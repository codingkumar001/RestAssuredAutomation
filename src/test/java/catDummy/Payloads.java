package catDummy;

import java.util.HashMap;
import java.util.Map;

public class Payloads {
    public static String laptopPayloads(String name, String year, String price, String CPUModel, String HardDiskSize){
        String payload="{\n" +
                "   \"name\": "+name+",\n" +
                "   \"data\": {\n" +
                "      \"year\": "+year+",\n" +
                "      \"price\": "+price+",\n" +
                "      \"CPU model\": "+CPUModel+",\n" +
                "      \"Hard disk size\": "+HardDiskSize+"\n" +
                "   }\n" +
                "}";
        return payload;
    }

    public static Map<String, Object> laptopPayloadsMap(String name, String year, String price, String CPUModel, String HardDiskSize) {

            // Outer map
            Map<String, Object> payload = new HashMap<>();
            payload.put("name", name);

            // Inner map (data)
            Map<String, String> dataMap = new HashMap<>();
            dataMap.put("year", year);
            dataMap.put("price", price);
            dataMap.put("CPU model", CPUModel);
            dataMap.put("Hard disk size", HardDiskSize);

            payload.put("data", dataMap);

            return payload;

    }

}
