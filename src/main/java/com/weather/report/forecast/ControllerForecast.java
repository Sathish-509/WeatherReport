package com.weather.report.forecast;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class ControllerForecast {

    @Value("${welcome.message}")
    private String message;

    @Autowired
    ServiceForecast serviceForecast;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("message", message);
        try {
            Map<String, ModelDailyForecast> report = serviceForecast.getWeatherReport();
            model.addAttribute("report", report);
        } catch (Exception e){
            e.printStackTrace();
        }
        return "welcome"; //view
    }
}
