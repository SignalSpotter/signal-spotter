package signal.spotter;

import java.net.URI;
import java.nio.charset.StandardCharsets;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class App {
    public String queryReports() {
        final String API_ENDPOINT = "https://2hou3tuoenc4tjr5uovpujw4oa.appsync-api.us-east-1.amazonaws.com/graphql";
        final String API_KEY = "da2-puoru6d35vh7lct47ozplajwbm";
        final String requestBody = "{\"query\": \"query { listReports { items { datetime x y } } }\"}";

        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            URI uri = new URIBuilder(API_ENDPOINT).build();

            HttpPost httpPost = new HttpPost(uri);
            httpPost.setHeader("Content-Type", "application/json");
            httpPost.setHeader("x-api-key", API_KEY);
            httpPost.setEntity(new StringEntity(requestBody, ContentType.APPLICATION_JSON));

            HttpEntity responseEntity = httpClient.execute(httpPost).getEntity();
            String responseString = "";
            if (responseEntity != null) {
                responseString = EntityUtils.toString(responseEntity, StandardCharsets.UTF_8);
            }

            return responseString;

        } catch (Exception e) {
            return "failed";
        }
    }

    public static void main(String[] args) {
        System.out.println(new App().queryReports());
    }
}
