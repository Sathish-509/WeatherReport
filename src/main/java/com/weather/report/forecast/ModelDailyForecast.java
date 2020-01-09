package com.weather.report.forecast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ModelDailyForecast implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    public ObjectId _id;
    public String createdDate;
    public String place;
    private String latitude;
    private String longitude;
    private String timezone;
    private ModelDailyObject daily;

    public ModelDailyForecast() {
    }

    public ModelDailyForecast(ObjectId _id, String createdDate, String latitude, String longitude, String timezone, ModelDailyObject daily) {
        this._id = _id;
        this.createdDate = createdDate;
        this.latitude = latitude;
        this.longitude = longitude;
        this.timezone = timezone;
        this.daily = daily;
    }

    public ModelDailyForecast(String latitude, String longitude, String timezone, ModelDailyObject daily) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.timezone = timezone;
        this.daily = daily;
    }

    public String get_id() { return _id.toHexString(); }

    public void set_id(ObjectId _id) { this._id = _id; }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public ModelDailyObject getDaily() {
        return daily;
    }

    public void setDaily(ModelDailyObject daily) {
        this.daily = daily;
    }

    public static class ModelDailyForecastBuilder {
        private String latitude;
        private String longitude;
        private String timezone;
        private String createdDate;
        private String place;
        private ModelDailyObject daily;

        public ModelDailyForecast build() {
            return new ModelDailyForecast(latitude, longitude, timezone, daily);
        }

        public ModelDailyForecastBuilder setLatitude(String latitude) {
            this.latitude = latitude;
            return this;
        }

        public ModelDailyForecastBuilder setCreatedDate(String createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public ModelDailyForecastBuilder setPlace(String place) {
            this.place = place;
            return this;
        }

        public ModelDailyForecastBuilder setLongitude(String longitude) {
            this.longitude = longitude;
            return this;
        }

        public ModelDailyForecastBuilder setTimezone(String timezone) {
            this.timezone = timezone;
            return this;
        }

        public ModelDailyForecastBuilder setDaily(ModelDailyObject daily) {
            this.daily = daily;
            return this;
        }
    }
    public static ModelDailyForecastBuilder newBuilder() {
        return new ModelDailyForecastBuilder();
    }
}
