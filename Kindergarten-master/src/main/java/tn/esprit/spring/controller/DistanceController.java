package tn.esprit.spring.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Distance;
import tn.esprit.spring.entities.LatLong;
import tn.esprit.spring.services.DistanceService;




@RestController
public class DistanceController {


	
	@RequestMapping("/distance")
	public Distance distance(@RequestParam(value="src", defaultValue="") String src,@RequestParam(value="dst", defaultValue="") String dst) throws FileNotFoundException, IOException {

		if(src == "" || dst=="")
			return new Distance("","",-1);
	
		HashMap<String, LatLong> map = DistanceService.readDistanceCSV(src, dst);
		if(map.containsKey(src) && map.containsKey(dst)) {
			int distanceInKm = DistanceService.calculateDistanceInKilometer(map.get(src).getLatitude(),map.get(src).getLongitude(),map.get(dst).getLatitude(),map.get(dst).getLongitude());
			return new Distance(src,dst,distanceInKm);
		}
		return new Distance(src, dst, -1);
	}	
	 

}
