package com.example.covid_19tracker.Model;

import java.io.Serializable;

public class CountryModel implements Serializable {

    private String country,cases,todayCases,deaths,todayDeaths,recovered,active,critical;
    private CountryInfo countryInfo;

    @Override
    public String toString() {
        return "CountryModel{" +
                ", country='" + country + '\'' +
                ", cases='" + cases + '\'' +
                ", todayCases='" + todayCases + '\'' +
                ", deaths='" + deaths + '\'' +
                ", todayDeaths='" + todayDeaths + '\'' +
                ", recovered='" + recovered + '\'' +
                ", active='" + active + '\'' +
                ", critical='" + critical + '\'' +
                '}';
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCases() {
        return cases;
    }

    public void setCases(String cases) {
        this.cases = cases;
    }

    public String getTodayCases() {
        return todayCases;
    }

    public void setTodayCases(String todayCases) {
        this.todayCases = todayCases;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getTodayDeaths() {
        return todayDeaths;
    }

    public void setTodayDeaths(String todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getCritical() {
        return critical;
    }

    public void setCritical(String critical) {
        this.critical = critical;
    }

    public CountryInfo getCountryInfo() {
        return countryInfo;
    }

    public void setCountryInfo(CountryInfo countryInfo) {
        this.countryInfo = countryInfo;
    }

    public class CountryInfo implements Serializable{

        String flag;

        @Override
        public String toString() {
            return "countryInfo{" +
                    "flag='" + flag + '\'' +
                    '}';
        }

        public String getFlag() {
            return flag;
        }

        public void setFlag(String flag) {
            this.flag = flag;
        }
    }

}
