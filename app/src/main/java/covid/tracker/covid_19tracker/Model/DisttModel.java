package covid.tracker.covid_19tracker.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DisttModel {

    @Override
    public String toString() {
        return "DisttModel{" +
                "state='" + state + '\'' +
                ", statecode='" + statecode + '\'' +
                ", districtData=" + districtData +
                '}';
    }



    @SerializedName("state")
        @Expose
        private String state;
        @SerializedName("statecode")
        @Expose
        private String statecode;
        @SerializedName("districtData")
        @Expose
        private List<DistrictDatum> districtData = null;

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

        public List<DistrictDatum> getDistrictData() {
            return districtData;
        }

        public void setDistrictData(List<DistrictDatum> districtData) {
            this.districtData = districtData;
        }


    public class Delta {

        @Override
        public String toString() {
            return "Delta{" +
                    "confirmed=" + confirmed +
                    ", deceased=" + deceased +
                    ", recovered=" + recovered +
                    '}';
        }

        @SerializedName("confirmed")
        @Expose
        private Long confirmed;
        @SerializedName("deceased")
        @Expose
        private Long deceased;
        @SerializedName("recovered")
        @Expose
        private Long recovered;

        public Long getConfirmed() {
            return confirmed;
        }

        public void setConfirmed(Long confirmed) {
            this.confirmed = confirmed;
        }

        public Long getDeceased() {
            return deceased;
        }

        public void setDeceased(Long deceased) {
            this.deceased = deceased;
        }

        public Long getRecovered() {
            return recovered;
        }

        public void setRecovered(Long recovered) {
            this.recovered = recovered;
        }

    }
    public class DistrictDatum {

        @Override
        public String toString() {
            return "DistrictDatum{" +
                    "district='" + district + '\'' +
                    ", notes='" + notes + '\'' +
                    ", active=" + active +
                    ", confirmed=" + confirmed +
                    ", deceased=" + deceased +
                    ", recovered=" + recovered +
                    ", delta=" + delta +
                    '}';
        }

        private int id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @SerializedName("district")
        @Expose
        private String district;
        @SerializedName("notes")
        @Expose
        private String notes;
        @SerializedName("active")
        @Expose
        private Long active;
        @SerializedName("confirmed")
        @Expose
        private Long confirmed;
        @SerializedName("deceased")
        @Expose
        private Long deceased;
        @SerializedName("recovered")
        @Expose
        private Long recovered;
        @SerializedName("delta")
        @Expose
        private Delta delta;

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public String getNotes() {
            return notes;
        }

        public void setNotes(String notes) {
            this.notes = notes;
        }

        public Long getActive() {
            return active;
        }

        public void setActive(Long active) {
            this.active = active;
        }

        public Long getConfirmed() {
            return confirmed;
        }

        public void setConfirmed(Long confirmed) {
            this.confirmed = confirmed;
        }

        public Long getDeceased() {
            return deceased;
        }

        public void setDeceased(Long deceased) {
            this.deceased = deceased;
        }

        public Long getRecovered() {
            return recovered;
        }

        public void setRecovered(Long recovered) {
            this.recovered = recovered;
        }

        public Delta getDelta() {
            return delta;
        }

        public void setDelta(Delta delta) {
            this.delta = delta;
        }

    }


}
