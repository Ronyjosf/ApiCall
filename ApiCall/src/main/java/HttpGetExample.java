package httpClientExample;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpGetExample {

    public static void main(String[] args) {
        try {
            HttpGetExample hce = new HttpGetExample();
            String body = hce.get("http://httpbin.org/get");
            System.out.println(body);
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public String get(String getUrl) throws IOException {
        URL url = new URL(getUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        return this.read(con.getInputStream());
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
