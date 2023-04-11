package signal.spotter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Properties;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

public class Database {

    private String API_ENDPOINT = "";
    private String API_KEY = "";

    public Database() throws FileNotFoundException {
        try {
            Properties properties = new Properties();
            properties.load(
                    new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\local.properties"));

            API_ENDPOINT = properties.getProperty("API_ENDPOINT");
            API_KEY = properties.getProperty("API_KEY");
        } catch (IOException e) {
            throw (new FileNotFoundException("The config file for the API endpoints and keys was not found"));
        }
    }

    public List<Report> queryReports() throws Exception {
        String requestBody = "{\"query\": \"query { listReports { items { datetime x y } } }\"}";

        try {
            URI uri = new URIBuilder(API_ENDPOINT).build();

            HttpPost httpPost = new HttpPost(uri);
            httpPost.setHeader("Content-Type", "application/json");
            httpPost.setHeader("x-api-key", API_KEY);
            httpPost.setEntity(new StringEntity(requestBody, ContentType.APPLICATION_JSON));

            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpEntity responseEntity = httpClient.execute(httpPost).getEntity();
            String responseString = "";
            if (responseEntity != null) {
                responseString = EntityUtils.toString(responseEntity, StandardCharsets.UTF_8);
            }

            return new Gson().fromJson(responseString, GraphqlResponse.class).getData().getListReports().getItems();

        } catch (Exception e) {
            throw (new Exception("Error in queryReports method."));
        }
    }

    public boolean createReport(Report report) throws Exception {

        String requestBody = "{\"query\": \"mutation { createReports(input: {datetime: \\\"2023-04-10T08:15:30.000000Z\\\", x: 0.4, y: 0.3 }) { id datetime x y } }\"}";

        try {
            URI uri = new URIBuilder(API_ENDPOINT).build();

            HttpPost httpPost = new HttpPost(uri);
            httpPost.setHeader("Content-Type", "application/json");
            httpPost.setHeader("x-api-key", API_KEY);
            httpPost.setEntity(new StringEntity(requestBody, ContentType.APPLICATION_JSON));

            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpEntity responseEntity = httpClient.execute(httpPost).getEntity();
            String responseString = "";
            if (responseEntity != null) {
                responseString = EntityUtils.toString(responseEntity, StandardCharsets.UTF_8);
                return false;
            }

            return true;

        } catch (Exception e) {
            throw (new Exception("Error in createReports method."));
        }
    }
}
