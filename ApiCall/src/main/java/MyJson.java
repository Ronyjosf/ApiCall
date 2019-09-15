import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class MyJson {
    public static JSONObject string2Json(String tmp) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject jobj = (JSONObject) parser.parse(tmp);
        return jobj;
    }
}
