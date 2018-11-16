package pl.aj.uamproject.hairdresser;

import org.apache.http.client.methods.HttpGet;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientRestFulTest {

//    @Test
//    public void shouldReturnClientInfoWithId1() throws IOException {
//        restTest("http://localhost:8080/RestAPI-war-1.0.0-SNAPSHOT/client/1", "resources/1.json");
//    }
//
//    @Test
//    public void shouldReturnAllIClientInfo() throws IOException {
//        restTest("http://localhost:8080/RestAPI-war-1.0.0-SNAPSHOT/client", "resources/all.json");
//    }

    private void restTest(String aRestUrl, String aPreparedFilePath) throws IOException {
        //given - prepare html request
        HttpGet getRequest = new HttpGet(aRestUrl);
        //given - prepare expected result
        JsonParser parser = new JsonParser();
        FileReader preparedFile = new FileReader(
                getClass().getClassLoader().getResource(aPreparedFilePath).getFile());
        JsonElement expected = parser.parse(preparedFile);

        //when make rest call
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(getRequest);
        String content = EntityUtils.toString(httpResponse.getEntity());

        //then
        assertEquals(200, httpResponse.getStatusLine().getStatusCode());

        JsonElement result = parser.parse(content);
        assertEquals(expected, result);
    }
}
