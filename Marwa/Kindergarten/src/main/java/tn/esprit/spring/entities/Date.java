package tn.esprit.spring.entities;


import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"time"
})
public class Date {

@JsonProperty("time")
private Time time;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();


@JsonProperty("time")
public Time gettime() {
return time;
}

@JsonProperty("time")
public void settime(Time time) {
this.time = time;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

public String toString() {
	StringBuffer buffer = new StringBuffer();	
	buffer.append(gettime());
	return buffer.toString();
}
}
