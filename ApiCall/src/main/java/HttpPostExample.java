package httpClientExample;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpPostExample {
    public static void main(String[] args) {
        try {
            HttpPostExample hce = new HttpPostExample();
            String body = hce.post("http://httpbin.org/post", "data=test data");
            System.out.println(body);

            JSONObject jsonObjectResponse = hce.string2Json(body);
            JSONObject jsonObject_form = (JSONObject) jsonObjectResponse.get("form");
            System.out.println("form ="+jsonObject_form.get("data"));

        } catch(IOException | ParseException ioe) {
            ioe.printStackTrace();
        }

//        JSONObject jsonObject = MyJson.string2Json(body);
    }

    private JSONObject string2Json(String body) throws ParseException {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(body);
        return jsonObject;

    }

    public String post(String postUrl, String data) throws IOException {
        URL url = new URL(postUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");

        con.setDoOutput(true);

        this.sendData(con, data);

        return this.read(con.getInputStream());
    }

    protected void sendData(HttpURLConnection con, String data) throws IOException {
        DataOutputStream wr = null;
        try {
            wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(data);
            wr.flush();
            wr.close();
        } catch(IOException exception) {
            throw exception;
        } finally {
            this.closeQuietly(wr);
        }
    }

    private String read(InputStream is) throws IOException {
        BufferedReader in = null;
        String inputLine;
        StringBuilder body;
        try {
            in = new BufferedReader(new InputStreamReader(is));

            body = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                body.append(inputLine);
            }
            in.close();

            return body.toString();
        } catch(IOException ioe) {
            throw ioe;
        } finally {
            this.closeQuietly(in);
        }
    }

    protected void closeQuietly(Closeable closeable) {
        try {
            if( closeable != null ) {
                closeable.close();
            }
        } catch(IOException ex) {

        }
    }
}
