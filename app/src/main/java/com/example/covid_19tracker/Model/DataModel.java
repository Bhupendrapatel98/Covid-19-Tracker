package com.example.covid_19tracker.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataModel {

    @Override
    public String toString() {
        return "DataModel{" +
                "updated=" + updated +
                ", cases=" + cases +
                ", todayCases=" + todayCases +
                ", deaths=" + deaths +
                ", todayDeaths=" + todayDeaths +
                ", recovered=" + recovered +
                ", active=" + active +
                ", critical=" + critical +
                ", casesPerOneMillion=" + casesPerOneMillion +
                ", deathsPerOneMillion=" + deathsPerOneMillion +
                ", tests=" + tests +
                ", testsPerOneMillion=" + testsPerOneMillion +
                ", affectedCountries=" + affectedCountries +
                '}';
    }

    @SerializedName("updated")
        @Expose
        private Long updated;
        @SerializedName("cases")
        @Expose
        private Long cases;
        @SerializedName("todayCases")
        @Expose
        private Long todayCases;
        @SerializedName("deaths")
        @Expose
        private Long deaths;
        @SerializedName("todayDeaths")
        @Expose
        private Long todayDeaths;
        @SerializedName("recovered")
        @Expose
        private Long recovered;
        @SerializedName("active")
        @Expose
        private Long active;
        @SerializedName("critical")
        @Expose
        private Long critical;
        @SerializedName("casesPerOneMillion")
        @Expose
        private Long casesPerOneMillion;
        @SerializedName("deathsPerOneMillion")
        @Expose
        private Long deathsPerOneMillion;
        @SerializedName("tests")
        @Expose
        private Long tests;
        @SerializedName("testsPerOneMillion")
        @Expose
        private Double testsPerOneMillion;
        @SerializedName("affectedCountries")
        @Expose
        private Long affectedCountries;

        public Long getUpdated() {
            return updated;
        }

        public void setUpdated(Long updated) {
            this.updated = updated;
        }

        public Long getCases() {
            return cases;
        }

        public void setCases(Long cases) {
            this.cases = cases;
        }

        public Long getTodayCases() {
            return todayCases;
        }

        public void setTodayCases(Long todayCases) {
            this.todayCases = todayCases;
        }

        public Long getDeaths() {
            return deaths;
        }

        public void setDeaths(Long deaths) {
            this.deaths = deaths;
        }

        public Long getTodayDeaths() {
            return todayDeaths;
        }

        public void setTodayDeaths(Long todayDeaths) {
            this.todayDeaths = todayDeaths;
        }

        public Long getRecovered() {
            return recovered;
        }

        public void setRecovered(Long recovered) {
            this.recovered = recovered;
        }

        public Long getActive() {
            return active;
        }

        public void setActive(Long active) {
            this.active = active;
        }

        public Long getCritical() {
            return critical;
        }

        public void setCritical(Long critical) {
            this.critical = critical;
        }

        public Long getCasesPerOneMillion() {
            return casesPerOneMillion;
        }

        public void setCasesPerOneMillion(Long casesPerOneMillion) {
            this.casesPerOneMillion = casesPerOneMillion;
        }

        public Long getDeathsPerOneMillion() {
            return deathsPerOneMillion;
        }

        public void setDeathsPerOneMillion(Long deathsPerOneMillion) {
            this.deathsPerOneMillion = deathsPerOneMillion;
        }

        public Long getTests() {
            return tests;
        }

        public void setTests(Long tests) {
            this.tests = tests;
        }

        public Double getTestsPerOneMillion() {
            return testsPerOneMillion;
        }

        public void setTestsPerOneMillion(Double testsPerOneMillion) {
            this.testsPerOneMillion = testsPerOneMillion;
        }

        public Long getAffectedCountries() {
            return affectedCountries;
        }

        public void setAffectedCountries(Long affectedCountries) {
            this.affectedCountries = affectedCountries;
        }
}
