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

public class GraphQL {

    public static List<Report> queryReports() throws Exception {
        final String requestBody = "{\"query\": \"query { listReports { items { datetime x y } } }\"}";
        String API_ENDPOINT = "";
        String JWT = GlobalState.getInstance().getJWT();

        try {
            Properties properties = new Properties();
            properties.load(
                    new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/local.properties"));

            API_ENDPOINT = properties.getProperty("API_ENDPOINT");
        } catch (IOException e) {
            throw (new FileNotFoundException("The config file for the API endpoints and keys was not found"));
        }

        try {
            URI uri = new URIBuilder(API_ENDPOINT).build();

            System.out.println("Bearer " + JWT);

            HttpPost httpPost = new HttpPost(uri);
            httpPost.setHeader("Content-Type", "application/json");
            httpPost.setHeader("Authorization", "Bearer " + JWT);
            httpPost.setEntity(new StringEntity(requestBody, ContentType.APPLICATION_JSON));

            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpEntity responseEntity = httpClient.execute(httpPost).getEntity();
            String responseString = "";
            if (responseEntity != null) {
                responseString = EntityUtils.toString(responseEntity, StandardCharsets.UTF_8);
            }
            System.out.println(responseString);

            return new Gson().fromJson(responseString, GraphqlResponse.class).getData().getListReports().getItems();

        } catch (Exception e) {
            e.printStackTrace();
            throw (new Exception("Error in queryReports method."));
        }
    }

    public static boolean createReport(Report report) throws Exception {

        final String requestBody = String.format(
                "{\"query\": \"mutation { createReports(input: {datetime: \\\"%s\\\", x: %f, y: %f }) { id datetime x y } }\"}",
                report.getDatetime(), report.getX(), report.getY());

        String API_ENDPOINT = "";
        String JWT = GlobalState.getInstance().getJWT();

        try {
            Properties properties = new Properties();
            properties.load(
                    new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/local.properties"));

            API_ENDPOINT = properties.getProperty("API_ENDPOINT");
        } catch (IOException e) {
            throw (new FileNotFoundException("The config file for the API endpoints and keys was not found"));
        }

        try {
            URI uri = new URIBuilder(API_ENDPOINT).build();

            HttpPost httpPost = new HttpPost(uri);
            httpPost.setHeader("Content-Type", "application/json");
            httpPost.setHeader("Bearer", JWT);
            httpPost.setEntity(new StringEntity(requestBody, ContentType.APPLICATION_JSON));

            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpEntity responseEntity = httpClient.execute(httpPost).getEntity();
            if (responseEntity != null) {
                String responseString = EntityUtils.toString(responseEntity);
                System.out.println(responseString);
                return true;
            }
            System.out.println("Report creation returned no response");
            return false;

        } catch (Exception e) {
            throw (new Exception("Error in createReports method."));
        }
    }
}
