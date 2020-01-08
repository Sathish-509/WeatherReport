package com.weather.report.forecast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ModelDailyData  implements Serializable {
    private static final long serialVersionUID = 1L;
    private String time;
    private String icon;
    private String summary;
    private String sunriseTime;
    private String temperatureHigh;
    private String temperatureLow;
    private String humidity;
    private String pressure;
    private String windSpeed;

    public ModelDailyData() {

    }

    public ModelDailyData(String time, String icon, String summary, String sunriseTime,
                              String temperatureHigh, String temperatureLow, String humidity, String pressure, String windSpeed) {
        this.time = time;
        this.icon = icon;
        this.summary = summary;
        this.sunriseTime = sunriseTime;
        this.temperatureHigh = temperatureHigh;
        this.temperatureLow = temperatureLow;
        this.humidity = humidity;
        this.pressure = pressure;
        this.windSpeed = windSpeed;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSunriseTime() {
        return sunriseTime;
    }

    public void setSunriseTime(String sunriseTime) {
        this.sunriseTime = sunriseTime;
    }

    public String getTemperatureHigh() {
        return temperatureHigh;
    }

    public void setTemperatureHigh(String temperatureHigh) {
        this.temperatureHigh = temperatureHigh;
    }

    public String getTemperatureLow() {
        return temperatureLow;
    }

    public void setTemperatureLow(String temperatureLow) {
        this.temperatureLow = temperatureLow;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    private static class ModelDailyDataBuilder {
        private String time;
        private String icon;
        private String summary;
        private String sunriseTime;
        private String temperatureHigh;
        private String temperatureLow;
        private String humidity;
        private String pressure;
        private String windSpeed;

        public ModelDailyDataBuilder setTime(String time) {
            this.time = time;
            return this;
        }

        public ModelDailyDataBuilder setIcon(String icon) {
            this.icon = icon;
            return this;
        }

        public ModelDailyDataBuilder setSummary(String summary) {
            this.summary = summary;
            return this;
        }

        public ModelDailyDataBuilder setSunriseTime(String sunriseTime) {
            this.sunriseTime = sunriseTime;
            return this;
        }

        public ModelDailyDataBuilder setTemperatureHigh(String temperatureHigh) {
            this.temperatureHigh = temperatureHigh;
            return this;
        }

        public ModelDailyDataBuilder setTemperatureLow(String temperatureLow) {
            this.temperatureLow = temperatureLow;
            return this;
        }

        public ModelDailyDataBuilder setHumidity(String humidity) {
            this.humidity = humidity;
            return this;
        }

        public ModelDailyDataBuilder setPressure(String pressure) {
            this.pressure = pressure;
            return this;
        }

        public ModelDailyDataBuilder setWindSpeed(String windSpeed) {
            this.windSpeed = windSpeed;
            return this;
        }

        public ModelDailyData build() {
            return new ModelDailyData(time, icon, summary, sunriseTime, temperatureHigh, temperatureLow,
                    humidity, pressure, windSpeed);
        }
    }
    public static ModelDailyDataBuilder newBuilder() {
        return new ModelDailyDataBuilder();
    }
}
