package pl.odynekgithub.TaskScheduling;

import org.json.JSONObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Random;

@Component
public class ScheduledTask
    {

    HttpClient client = HttpClient.newHttpClient();

    //uncomment for jack norris jockes

/*    @Scheduled(fixedRate = 5000)
    public void chuckJoke() throws IOException, InterruptedException
        {
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://api.chucknorris.io/jokes/random")).build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        JSONObject json = new JSONObject(response.body());
        String joke = json.getString("value");
         System.out.println(joke);
            }

 */


    @Scheduled(fixedRate = 3000)
    public void weather() throws IOException, InterruptedException
        {
        String city[] = {"tarnow", "warsaw", "tokio", "nagasaki", "new_york", "berlin"};
        boolean check = false;
        HttpRequest weatherRequest = null;

        for (String cities : city)
            {
            weatherRequest = HttpRequest.newBuilder().uri(URI.create("https://goweather.herokuapp.com/weather/" + cities)).build();
            check = true;
            HttpResponse<String> response = client.send(weatherRequest, HttpResponse.BodyHandlers.ofString());
            JSONObject json = new JSONObject(response.body());
            String temp = json.getString("temperature");
            String wind = json.getString("wind");
            System.out.println("weather in " + cities + ": " + temp + " ," + wind);
            }

        }
    }
