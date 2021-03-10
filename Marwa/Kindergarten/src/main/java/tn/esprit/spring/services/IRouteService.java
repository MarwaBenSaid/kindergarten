package tn.esprit.spring.services;
import java.util.List;

import tn.esprit.spring.entities.Route;
public interface IRouteService {
	
	
List<Route> listAll();
RouteRs findMinimumCost(String source, String destination);

}
