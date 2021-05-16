package tn.esprit.spring.controller;

   import com.fasterxml.jackson.databind.ObjectMapper;
   import okhttp3.OkHttpClient;
   import okhttp3.Request;
   import okhttp3.ResponseBody;
   import tn.esprit.spring.entities.GeocodeResult;

import org.springframework.web.bind.annotation.*;
   import java.io.IOException;
   import java.net.URLEncoder;
   @RestController
   public class GeocodeController {
	   /*
	   @RequestMapping(path = "/geocode", method = RequestMethod.GET )
	   public String getGeocode(@RequestParam String address) throws IOException {
	       OkHttpClient client = new OkHttpClient();
	       String encodedAddress = URLEncoder.encode(address, "UTF-8");
	       Request request = new Request.Builder()
	               .url("https://google-maps-geocoding.p.rapidapi.com/geocode/json?language=en&address=" + encodedAddress)
	               .get()
	               .addHeader("x-rapidapi-host", "google-maps-geocoding.p.rapidapi.com")
	               .addHeader("x-rapidapi-key", "0c255946dbmshd3e2ca184a27676p11126ejsn6ea09d7b3561")
	               .build();
	       ResponseBody responseBody = client.newCall(request).execute().body();
	       return responseBody.string();
	   }
	   
	   */
     // @RequestMapping(path = "/geocode", method = RequestMethod.GET )
	   @GetMapping(path = "/geocode")
      public GeocodeResult getGeocode(@RequestParam String address) throws IOException {
          OkHttpClient client = new OkHttpClient();
          String encodedAddress = URLEncoder.encode(address, "UTF-8");
          Request request = new Request.Builder()
                  .url("https://google-maps-geocoding.p.rapidapi.com/geocode/json?language=en&address=" + encodedAddress)
                  .get()
                  .addHeader("x-rapidapi-host", "google-maps-geocoding.p.rapidapi.com")
                  .addHeader("x-rapidapi-key",  "AIzaSyD2Ws0KYSjxNXXgRh8jRBGZgrXqgNHzWbI")
                  .build();
          ResponseBody responseBody = client.newCall(request).execute().body();
          ObjectMapper objectMapper = new ObjectMapper();
          GeocodeResult result = objectMapper.readValue(responseBody.string(), GeocodeResult.class);
          return result;
      }
     
   }

