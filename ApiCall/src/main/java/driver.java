import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class driver {
    public static void main(String[] args) throws IOException, ParseException {
        MyJson myJson = new MyJson();

        // get response string from api call
        HttpCall2API call =  new HttpCall2API("http://api.openweathermap.org/data/2.5/weather?q=Singapore", "GET");
        String tmp = call.connect()
                .readStringResponse();

        // get json obj from string
        JSONObject jsonObject= MyJson.string2Json(tmp);

        // now that the data is stored in an object, i can get the values
//        {
//            "results":[
//            {
//              "place": "tel_aviv",
//              "type":["local", "abroad"]
//            }]
//        }
        // get the results array:
        JSONArray jsonArray_results = (JSONArray) jsonObject.get("results");
        for (int i=0; i<jsonArray_results.size(); i++){
            JSONObject jsonObject_details = (JSONObject) jsonArray_results.get(i);
            System.out.println("place = "+jsonObject_details.get("place") + "/type = " + jsonObject_details.get("type"));
        }



    }
}
