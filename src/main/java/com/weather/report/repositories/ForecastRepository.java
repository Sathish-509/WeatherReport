package com.weather.report.repositories;

import com.weather.report.forecast.ModelDailyForecast;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ForecastRepository extends MongoRepository<ModelDailyForecast, String> {
    ModelDailyForecast findBy_id(ObjectId _id);
    List<ModelDailyForecast> findByCreatedDate(String createdDate);
    ModelDailyForecast findByCreatedDateAndPlace(String createdDate, String place);

}
