package com.weather.report.forecast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ModelDailyForecast implements Serializable {
    private static final long serialVersionUID = 1L;
    private String latitude;
    private String longitude;
    private String timezone;
    private ModelDailyObject daily;

    public ModelDailyForecast() {
    }

    public ModelDailyForecast(String latitude, String longitude, String timezone, ModelDailyObject daily) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.timezone = timezone;
        this.daily = daily;
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

    private static class ModelDailyForecastBuilder {
        private String latitude;
        private String longitude;
        private String timezone;
        private ModelDailyObject daily;

        public ModelDailyForecast build() {
            return new ModelDailyForecast(latitude, longitude, timezone, daily);
        }

        public ModelDailyForecastBuilder setLatitude(String latitude) {
            this.latitude = latitude;
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
