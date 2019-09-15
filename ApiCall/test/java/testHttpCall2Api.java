import org.junit.Test;

import java.io.IOException;
import java.net.MalformedURLException;

import static org.junit.Assert.assertEquals;

public class testHttpCall2Api {
    HttpCall2API httpCall2API;

    public testHttpCall2Api() throws MalformedURLException {
        httpCall2API  = new HttpCall2API("http://api.openweathermap.org/data/2.5/weather?q=Singapore", "GET");
    }

    @Test
    public void testOneMethod() throws IOException {

        assertEquals("expected to be true", true, httpCall2API.connect()!=null);
        System.out.println("end");



    }
}
