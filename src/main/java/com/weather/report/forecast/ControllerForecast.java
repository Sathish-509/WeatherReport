package com.weather.report.forecast;

import com.weather.report.repositories.ForecastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class ControllerForecast {

    @Value("${welcome.message}")
    private String message;

    @Autowired
    ServiceForecast serviceForecast;

    @Autowired
    private ForecastRepository repository;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("message", message);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
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
                ModelDailyForecast responseObj = repository.findByCreatedDateAndPlace(formatter.format(date), k);
                if(responseObj == null) {
                    responseObj  = serviceForecast.getWeatherReport(k, v);
                    if(responseObj != null) {
                        repository.save(responseObj);
                    }
                }
                if(responseObj != null) {
                    response.put(k, responseObj);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        model.addAttribute("report", response);
        return "welcome"; //view
    }
}
