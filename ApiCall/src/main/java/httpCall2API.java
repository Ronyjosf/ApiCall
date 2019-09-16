import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

class HttpCall2API {
    URL url;
    private String get_post;

    public HttpCall2API(String url_address, String method) throws MalformedURLException {
        url = new URL (url_address);
        get_post = method;
    }


    public HttpCall2API connect() throws IOException {


        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod(get_post);
        con.connect();

        if (con.getResponseCode() !=200) {
            System.out.println("got response code: " + con.getResponseCode());
            return null;
        }
        return this;
    }

    public String getResponse() throws IOException {
        Scanner scanner = new Scanner(url.openStream());
        return null;
    }

    public String readStringResponse() throws IOException{
        String inline = null;
        Scanner sc = new Scanner(url.openStream());
        // get content into lines
        while (sc.hasNext()) inline += sc.nextLine();
        sc.close();
        return inline;

    }
}
