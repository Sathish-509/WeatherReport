package com.weather.report.forecast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ModelDailyObject implements Serializable {
    private static final long serialVersionUID = 1L;
    private String summary;
    private String icon;
    private List<ModelDailyData> data;

    public ModelDailyObject() {

    }

    public ModelDailyObject(String summary, String icon, List<ModelDailyData> data) {
        this.summary = summary;
        this.icon = icon;
        this.data = data;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<ModelDailyData> getData() {
        return data;
    }

    public void setData(List<ModelDailyData> data) {
        this.data = data;
    }

    private static class ModelDailyObjectBuilder {
        private String summary;
        private String icon;
        private List<ModelDailyData> data;

        public ModelDailyObjectBuilder setSummary(String summary) {
            this.summary = summary;
            return this;
        }

        public ModelDailyObjectBuilder setIcon(String icon) {
            this.icon = icon;
            return this;
        }

        public ModelDailyObjectBuilder setData(List<ModelDailyData> data) {
            this.data = data;
            return this;
        }
        public ModelDailyObject build() {
            return new ModelDailyObject(summary, icon, data);
        }
    }
    public static ModelDailyObjectBuilder newBuilder() {
        return new ModelDailyObjectBuilder();
    }
}
