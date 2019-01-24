package pl.aj.uamproject.hairdresser;

import com.google.gson.JsonObject;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ClientRestFulTest {

    @BeforeEach
    void before() throws IOException {
        deleteAll();
    }

    @AfterEach
    void after() throws IOException {
        deleteAll();
    }


    private void deleteAll() throws IOException {
        for (int id = 1; id <= 100; id++) {
            delete(id);
        }
    }

    private void delete(int id) throws IOException {
//given - prepare html request
        HttpDelete postRequest = new HttpDelete("http://localhost:8080/war/client/" + id);

        //when make rest call
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(postRequest);
        ((CloseableHttpResponse) httpResponse).close();
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test()
    void shouldDeleteClient() throws IOException {
        exception.expect(IOException.class);
        JsonElement jsonElement = post("http://localhost:8080/war/client", "client/client-test.json");
        int id = jsonElement.getAsJsonObject().get("id").getAsInt();
        delete(id);

        JsonElement none = get("http://localhost:8080/war/client/" + id, 400);
    }

    @Test
    void shouldCreateNewClient() throws IOException {
        JsonElement jsonElement = post("http://localhost:8080/war/client", "client/client-test.json");
        JsonObject client = jsonElement.getAsJsonObject();
        assertEquals("jankowal@vp.pl", client.get("email").getAsString());
        assertEquals("Jan", client.get("firstName").getAsString());
        assertEquals("Kowalski", client.get("lastName").getAsString());
        assertEquals("698488394", client.get("phoneNumber").getAsString());
    }

    @Test
    void shouldReturnClientInfo() throws IOException {
        JsonElement jsonElement = post("http://localhost:8080/war/client", "client/1.json");
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        int clientId = asJsonObject.get("id").getAsInt();
        JsonElement client = get("http://localhost:8080/war/client/" + clientId, 200);
        JsonObject clientObj = client.getAsJsonObject();
        int clientIdRet = clientObj.get("id").getAsInt();
        assertEquals(clientId, clientIdRet);
        assertEquals(asJsonObject.get("email").getAsString(), clientObj.get("email").getAsString());
        assertEquals(asJsonObject.get("firstName").getAsString(), clientObj.get("firstName").getAsString());
        assertEquals(asJsonObject.get("lastName").getAsString(), clientObj.get("lastName").getAsString());
        assertEquals(asJsonObject.get("phoneNumber").getAsString(), clientObj.get("phoneNumber").getAsString());
    }

    @Test
    public void shouldReturnAllIClientInfo() throws IOException {
        get("http://localhost:8080/war/client", 200);
    }

    private JsonElement post(String aRestUrl, String aPreparedFilePath) throws IOException {
        //given - prepare html request
        HttpPost postRequest = new HttpPost(aRestUrl);
        postRequest.setHeader("Content-type", "application/json");

        //given - prepare expected result
        JsonParser parser = new JsonParser();
        FileReader preparedFile = new FileReader(
                getClass().getClassLoader().getResource(aPreparedFilePath).getFile());
        JsonElement expected = parser.parse(preparedFile);
        StringEntity stringEntity = new StringEntity(expected.toString());
        postRequest.getRequestLine();
        postRequest.setEntity(stringEntity);

        //when make rest call
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(postRequest);
        String content = EntityUtils.toString(httpResponse.getEntity());

        //then
        return parser.parse(content);

    }

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

    private JsonElement get(String aRestUrl, int expectedStatus) throws IOException {
        //given - prepare html request
        HttpGet getRequest = new HttpGet(aRestUrl);
        //given - prepare expected result
        JsonParser parser = new JsonParser();

        //when make rest call
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(getRequest);
        String content = EntityUtils.toString(httpResponse.getEntity());

        //then
        assertEquals(expectedStatus, httpResponse.getStatusLine().getStatusCode());
        return parser.parse(content);
    }
}
