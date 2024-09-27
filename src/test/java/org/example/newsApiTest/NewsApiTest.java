package org.example.newsApiTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.example.dto.NewsApiResponse;
import org.testng.annotations.Test;
import java.util.HashMap;

public class NewsApiTest {
    @Test
    public void GetBooksDetails() {
        // Specify the base URL to the RESTful web service
        HashMap<String,String> queryParam=new HashMap<>();
        queryParam.put("q","tesla");
        queryParam.put("from","2024-05-22");
        queryParam.put("sortBy","publishedAt");
        queryParam.put("apiKey","");
        //https://newsapi.org/v2/everything?q=tesla&from=2024-05-22&sortBy=publishedAt&apiKey=944a34415c914ee19554486671e76177
        RestAssured.baseURI = "https://newsapi.org/v2/everything";
        // Get the RequestSpecification of the request to be sent to the server.
        RequestSpecification httpRequest = RestAssured.given().queryParams(queryParam);
        // specify the method type (GET) and the parameters if any.
        //In this case the request does not take any parameters
        Response response = httpRequest.request(Method.GET, "");
        // Print the status and message body of the response received from the server
        System.out.println("Status received => " + response.getStatusLine());
       // System.out.println("Response=>" + response.prettyPrint());
        //Method 1 of parsing
        NewsApiResponse newsApiResponse1= response.getBody().as(NewsApiResponse.class); //using RestAssured native method .as for Parsing
        System.out.println("My obj response is "+newsApiResponse1.getArticles().get(0));

        //Method 2 of parsing
        ObjectMapper mapper=new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        NewsApiResponse newsApiResponse= new NewsApiResponse();
        try {
            newsApiResponse= mapper.readValue(response.getBody().asString(),NewsApiResponse.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(newsApiResponse.getStatus());

        //Method 3 of parsing

        JsonParser parser = new JsonParser();
        JsonObject o = (JsonObject)parser.parse(response.asString());
        System.out.println(o.get("status"));
    }
}

