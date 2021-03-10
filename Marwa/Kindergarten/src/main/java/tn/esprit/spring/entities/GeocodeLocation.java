package tn.esprit.spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeocodeLocation {
   @JsonProperty("lat")
   private String latitude;
   @JsonProperty("lng")
   private String longitude;
   public GeocodeLocation() {
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
}
