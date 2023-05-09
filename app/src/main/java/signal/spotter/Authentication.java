package signal.spotter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import org.json.JSONObject;

public class Authentication {

    private static final String API_ENDPOINT = "https://cognito-idp.us-east-1.amazonaws.com/";

    public static boolean isAuthenticated = false;

    public static boolean Authenticate(String username, String password) throws Exception {

        String COGNITO_CLIENT_ID = "";

        try {
            Properties properties = new Properties();
            properties.load(
                    new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/local.properties"));

            COGNITO_CLIENT_ID = properties.getProperty("COGNITO_CLIENT_ID");
        } catch (IOException e) {
            throw (new FileNotFoundException("The config file for the API endpoints and keys was not found"));
        }

        String body = String.format(
                "{\"AuthParameters\": { \"USERNAME\": \"%s\", \"PASSWORD\": \"%s\"}, \"AuthFlow\": \"USER_PASSWORD_AUTH\", \"ClientId\": \"%s\"}",
                username,
                password,
                COGNITO_CLIENT_ID);

        try {
            URI uri = new URIBuilder(API_ENDPOINT).build();

            HttpPost httpPost = new HttpPost(uri);
            httpPost.setHeader("Content-Type", "application/x-amz-json-1.1");
            httpPost.setHeader("X-Amz-Target", "AWSCognitoIdentityProviderService.InitiateAuth");

            httpPost.setEntity(new StringEntity(body, ContentType.APPLICATION_JSON));

            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpEntity responseEntity = httpClient.execute(httpPost).getEntity();
            String responseString = "";
            if (responseEntity != null) {
                responseString = EntityUtils.toString(responseEntity, StandardCharsets.UTF_8);
            }

            JSONObject responseObject = new JSONObject(responseString);
            String session = responseObject.getString("Session");

            isAuthenticated = true;

            return session != null;

        } catch (Exception e) {
            throw (new Exception("Error, failed authentication: " + e.getMessage()));
        }

    }
}
