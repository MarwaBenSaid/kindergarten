package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Route;
import tn.esprit.spring.repositories.RouteRepository;


@Service
public class RouteServiceImpl implements IRouteService {
	 @Autowired
	 private RouteRepository repository;
	@Override
	public List<Route> listAll() {
		List<Route> routes = new ArrayList<>();
		repository.findAll().forEach(routes::add); //fun with Java 8
        return routes;
	}
	@Override
	public RouteRs findMinimumCost(String source, String destination) {
		List<Route> routes = listAll();
		Set<Route> adjacentNodes = new HashSet<>();
		
		Route r = null;
		double cost = 0.0;
		StringBuffer buffer = new StringBuffer();

		adjacentNodes = findAdacentNodes(source, routes);
		r = adjacentNodes.stream().filter(p -> p.getDestination().equals(destination)).findAny().orElse(null);

		if (null == r) {
			r = findMinimumCost(adjacentNodes);
			cost = cost + r.getDistance();
			buffer.append(r.getOrigin() + "->");
			if (r.getDestination().equals(destination)) {

				cost = r.getDistance();
			} else {
				while (adjacentNodes.size() != 0) {
					adjacentNodes = findAdacentNodes(r.getDestination(), routes);
					Route s = adjacentNodes.stream().filter(p -> p.getDestination().equals(destination)).findAny()
							.orElse(null);
					if (null == s) {
						buffer.append(r.getDestination() + "->");
						if (adjacentNodes.size() != 0) {
							r = findMinimumCost(adjacentNodes);
							cost = cost + r.getDistance();
							buffer.append(r.getDestination() + "->");
							if (r.getDestination().equals(destination)) {
								break;
							}

						}
					} else {
						r = findMinimumCost(adjacentNodes);
						cost = cost + r.getDistance();
						break;
					}

				}
			}
		} else {
			cost = r.getDistance();
			buffer.append(r.getOrigin() + "->");
		}

		System.out.println(buffer.toString());
		RouteRs rs = new RouteRs();
		rs.setSource(source);
		rs.setDestination(destination);
		rs.setPath(buffer.toString());
		rs.setTotalCost(cost);
		
		return rs;

	}
	private Route findMinimumCost(Set<Route> adjacentNodes) {
		return adjacentNodes.stream().min(Comparator.comparing(Route::getDistance))
				.orElseThrow(NoSuchElementException::new);
	}

	private Set<Route> findAdacentNodes(String source, List<Route> routes) {
		Set<Route> adjacentNodes = new HashSet<>();
		for (Route route : routes) {
			if (route.getOrigin().equals(source)) {
				adjacentNodes.add(route);
			}
		}
		return adjacentNodes;
	}


}
