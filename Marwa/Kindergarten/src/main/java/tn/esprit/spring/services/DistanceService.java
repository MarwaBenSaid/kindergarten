package tn.esprit.spring.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import au.com.bytecode.opencsv.CSVReader;
import tn.esprit.spring.entities.LatLong;

public class DistanceService {

	public static final String CODES_FILE_NAME = "Kindergartencodes.csv";
	public final static double AVERAGE_RADIUS_OF_EARTH_KM = 6371;
	

	public static HashMap<String, LatLong> readDistanceCSV(String srcCode,String destCode) throws FileNotFoundException, IOException {
		final int CODE_INDEX = 4, LAT_INDEX = 6, LNG_INDEX = 7;
		HashMap<String, LatLong> map = new HashMap<>();
		Resource resource = new ClassPathResource(CODES_FILE_NAME);
		CSVReader csvReader = new CSVReader(new InputStreamReader(resource.getInputStream())); 
        String[] nextRecord; 
       
        while ((nextRecord = csvReader.readNext()) != null) { 
        	//If both the kindergarten are already in hashmap, break
        	if(map.size()==2)
        		break;
        	
        	if(srcCode.equals(nextRecord[CODE_INDEX]) || destCode.equals(nextRecord[CODE_INDEX])) 
        		map.put(nextRecord[CODE_INDEX], new LatLong(Double.parseDouble(nextRecord[LAT_INDEX]),Double.parseDouble(nextRecord[LNG_INDEX])));
        	    
        } 

		return map;
	}
	
	
	
	public static int calculateDistanceInKilometer(double srcLat, double srcLng,double dstLat, double dstLng) {
        double latDistance = Math.toRadians(srcLat - dstLat);
        double lngDistance = Math.toRadians(srcLng - dstLng);

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
          + Math.cos(Math.toRadians(srcLat)) * Math.cos(Math.toRadians(dstLat))
          * Math.sin(lngDistance / 2) * Math.sin(lngDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return (int) (Math.round(AVERAGE_RADIUS_OF_EARTH_KM * c));
	 }

}
