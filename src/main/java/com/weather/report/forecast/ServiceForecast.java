package com.weather.report.forecast;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Service
public class ServiceForecast {
    @Autowired
    private RestTemplate restTemplate;

    public ModelDailyForecast getWeatherReport(String place, String longLat) throws InterruptedException, ExecutionException, TimeoutException {
        ModelDailyForecast responseObj = null;
        try {
                responseObj = getForecaseFromDarkSky(longLat).get();
                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                responseObj.setCreatedDate(formatter.format(date));
                responseObj.setPlace(place);
            } catch (Exception e) {
                e.printStackTrace();
            }
        return responseObj;
    }

    @Async
    public CompletableFuture<ModelDailyForecast> getForecaseFromDarkSky( String longLat) {
        RestTemplate restTemplate = new RestTemplate();
        String localSlowServiceEndpoint = "https://api.darksky.net/forecast/d137c208b4fbbc92d40d43453e087568/" + longLat + "?exclude=currently,minutely,hourly,alerts,flags";
        ModelDailyForecast responseObj = restTemplate.getForObject(localSlowServiceEndpoint, ModelDailyForecast.class);
        return CompletableFuture.completedFuture(responseObj);
    }
}
