package com.weather.report.forecast;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Service
public class ServiceForecast {
    @Autowired
    private RestTemplate restTemplate;

    public Map<String, ModelDailyForecast> getWeatherReport() throws InterruptedException, ExecutionException, TimeoutException {
        Map<String, String> items = new HashMap<>();
        items.put("Campbell", "+37.2872,-121.9500");
        items.put("Omaha", "+41.2565,-95.9345");
        items.put("Austin", "+30.2672,-97.7431");
        items.put("Nesiko", "+42.8048,+140.6874");
        items.put("Nara", "+34.6851,+135.8048");
        items.put("Jakartha", "-6.2088,+106.8456");
        Map<String, ModelDailyForecast> response = new HashMap<>();
        items.forEach((k,v)->{
            try {
                response.put(k, getForecaseFromDarkSky(v).get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return response;
    }

    @Async
    public CompletableFuture<ModelDailyForecast> getForecaseFromDarkSky( String longLat) {
        RestTemplate restTemplate = new RestTemplate();
        String localSlowServiceEndpoint = "https://api.darksky.net/forecast/d137c208b4fbbc92d40d43453e087568/" + longLat + "?exclude=currently,minutely,hourly,alerts,flags";
        ModelDailyForecast responseObj = restTemplate.getForObject(localSlowServiceEndpoint, ModelDailyForecast.class);
        return CompletableFuture.completedFuture(responseObj);
    }

    public static void main(String[] args) {
        ServiceForecast serviceForecast = new ServiceForecast();
        try {
            Map<String, ModelDailyForecast> jsonNode = serviceForecast.getWeatherReport();
            jsonNode.forEach((k,v)->System.out.println("Item : " + k + " Count : " + v));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
