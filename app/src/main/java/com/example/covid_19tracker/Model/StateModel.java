package com.example.covid_19tracker.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StateModel {

        @SerializedName("cases_time_series")
        @Expose
        private List<CasesTimeSeries> casesTimeSeries = null;
        @SerializedName("statewise")
        @Expose
        private List<Statewise> statewise = null;

        public List<CasesTimeSeries> getCasesTimeSeries() {
            return casesTimeSeries;
        }

        public void setCasesTimeSeries(List<CasesTimeSeries> casesTimeSeries) {
            this.casesTimeSeries = casesTimeSeries;
        }

        public List<Statewise> getStatewise() {
            return statewise;
        }

        public void setStatewise(List<Statewise> statewise) {
            this.statewise = statewise;
        }


    public class CasesTimeSeries {

        @SerializedName("dailyconfirmed")
        @Expose
        private String dailyconfirmed;
        @SerializedName("dailydeceased")
        @Expose
        private String dailydeceased;
        @SerializedName("dailyrecovered")
        @Expose
        private String dailyrecovered;
        @SerializedName("date")
        @Expose
        private String date;
        @SerializedName("totalconfirmed")
        @Expose
        private String totalconfirmed;
        @SerializedName("totaldeceased")
        @Expose
        private String totaldeceased;
        @SerializedName("totalrecovered")
        @Expose
        private String totalrecovered;

        public String getDailyconfirmed() {
            return dailyconfirmed;
        }

        public void setDailyconfirmed(String dailyconfirmed) {
            this.dailyconfirmed = dailyconfirmed;
        }

        public String getDailydeceased() {
            return dailydeceased;
        }

        public void setDailydeceased(String dailydeceased) {
            this.dailydeceased = dailydeceased;
        }

        public String getDailyrecovered() {
            return dailyrecovered;
        }

        public void setDailyrecovered(String dailyrecovered) {
            this.dailyrecovered = dailyrecovered;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTotalconfirmed() {
            return totalconfirmed;
        }

        public void setTotalconfirmed(String totalconfirmed) {
            this.totalconfirmed = totalconfirmed;
        }

        public String getTotaldeceased() {
            return totaldeceased;
        }

        public void setTotaldeceased(String totaldeceased) {
            this.totaldeceased = totaldeceased;
        }

        public String getTotalrecovered() {
            return totalrecovered;
        }

        public void setTotalrecovered(String totalrecovered) {
            this.totalrecovered = totalrecovered;
        }

    }



    public class Statewise {

        @SerializedName("active")
        @Expose
        private String active;
        @SerializedName("confirmed")
        @Expose
        private String confirmed;
        @SerializedName("deaths")
        @Expose
        private String deaths;
        @SerializedName("deltaconfirmed")
        @Expose
        private String deltaconfirmed;
        @SerializedName("deltadeaths")
        @Expose
        private String deltadeaths;
        @SerializedName("deltarecovered")
        @Expose
        private String deltarecovered;
        @SerializedName("lastupdatedtime")
        @Expose
        private String lastupdatedtime;
        @SerializedName("recovered")
        @Expose
        private String recovered;
        @SerializedName("state")
        @Expose
        private String state;
        @SerializedName("statecode")
        @Expose
        private String statecode;
        @SerializedName("statenotes")
        @Expose
        private String statenotes;

        public String getActive() {
            return active;
        }

        public void setActive(String active) {
            this.active = active;
        }

        public String getConfirmed() {
            return confirmed;
        }

        public void setConfirmed(String confirmed) {
            this.confirmed = confirmed;
        }

        public String getDeaths() {
            return deaths;
        }

        public void setDeaths(String deaths) {
            this.deaths = deaths;
        }

        public String getDeltaconfirmed() {
            return deltaconfirmed;
        }

        public void setDeltaconfirmed(String deltaconfirmed) {
            this.deltaconfirmed = deltaconfirmed;
        }

        public String getDeltadeaths() {
            return deltadeaths;
        }

        public void setDeltadeaths(String deltadeaths) {
            this.deltadeaths = deltadeaths;
        }

        public String getDeltarecovered() {
            return deltarecovered;
        }

        public void setDeltarecovered(String deltarecovered) {
            this.deltarecovered = deltarecovered;
        }

        public String getLastupdatedtime() {
            return lastupdatedtime;
        }

        public void setLastupdatedtime(String lastupdatedtime) {
            this.lastupdatedtime = lastupdatedtime;
        }

        public String getRecovered() {
            return recovered;
        }

        public void setRecovered(String recovered) {
            this.recovered = recovered;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getStatecode() {
            return statecode;
        }

        public void setStatecode(String statecode) {
            this.statecode = statecode;
        }

        public String getStatenotes() {
            return statenotes;
        }

        public void setStatenotes(String statenotes) {
            this.statenotes = statenotes;
        }

    }

}
