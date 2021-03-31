package tn.esprit.spring.services;


import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import springfox.documentation.spring.web.json.Json;
import tn.esprit.spring.entities.WeatherAverage;
import tn.esprit.spring.entities.WeatherMap;
import tn.esprit.spring.entities.WeatherMapTime;



@Service
public class WeatherService {
    private final String URI = "http://api.openweathermap.org/data/2.5/weather";
    private final String API_ID = "4580e2c6f04e8849c255969eddb3ba61";

    private final RestTemplate restTemplate;

    public WeatherService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public ResponseEntity<?> weatherForecastAverage(String city) {
        List<WeatherAverage> result = new ArrayList<WeatherAverage>();
        try {
            WeatherMap weatherMap = this.restTemplate.getForObject(this.url(city), WeatherMap.class);

            for (LocalDate reference = LocalDate.now();
                 reference.isBefore(LocalDate.now().plusDays(4));
                 reference = reference.plusDays(1)) {
                final LocalDate ref = reference;
                List<WeatherMapTime> collect = weatherMap.getList().stream()
                        .filter(x -> x.getDt().toLocalDate().equals(ref)).collect(Collectors.toList());
                if (!CollectionUtils.isEmpty(collect)) {
                    result.add(this.average(collect));
                }

            }
        } catch (HttpClientErrorException e) {
            return new ResponseEntity<>(new Json(e.getResponseBodyAsString()), e.getStatusCode());
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    private WeatherAverage average(List<WeatherMapTime> list) {
        WeatherAverage result = new WeatherAverage();

        for (WeatherMapTime item : list) {
            result.setDate(item.getDt().toLocalDate());
            result.plusMap(item);
        }

        result.totalize();

        return result;
    }

    private String url(String city) {
       return String.format(URI.concat("?q=%s").concat("&appid=%s").concat("&units=metric"), city, API_ID);
    }
}
