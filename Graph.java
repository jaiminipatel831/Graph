package graph;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph {
	
		private Map<String, City> cityNames;

		
		public Graph() {
			cityNames = new HashMap<String, City>();
		}

		public void addCity(City v) {
			cityNames.put(v.getName(), v);
		}

		
		public Collection<City> getCities() {
			return cityNames.values();
		}

		
		public City getCity(String name) {
			return cityNames.get(name);
		}

		
		public void addEdge(City sourceCity, City destinationCity, Double distance) {
			Edge newEdge = new Edge(sourceCity, destinationCity, distance);
			sourceCity.addEdge(newEdge);
		}

		public void addUndirectedEdge(City source, City destination, double distance) {
			addEdge(source, destination, distance);
			addEdge(source, destination, distance);
		}

		
		public List<Edge> findPath(String s, String d) {

			List<Edge> edgesList = new LinkedList<>();

			
			for (Map.Entry<String, City> entry : cityNames.entrySet()) {
				City city = entry.getValue();
				city.setKnown(false);
				city.setPrev(null);
				city.setDistance(-1);
			}

			
			City destCity = cityNames.get(d);

			
			City source = cityNames.get(s);

			if (source == null || destCity == null) {
				return edgesList;
			}

			boolean found = false; 
			source.setDistance(0);

			
			while (true) {

				
				City nextCity = null;
				
				for (Map.Entry<String, City> entry : cityNames.entrySet()) {
					City city = entry.getValue();
					if (!city.isKnown()) { 
						if (city.getDistance() != -1) { 
							if (nextCity == null || city.getDistance() < nextCity.getDistance()) {
								nextCity = city;
							}
						}
					}
				}

				
				if (nextCity == null) {
					break;
				}

			
				if (nextCity == destCity) {
					found = true;
					break;
				}

				
				nextCity.setKnown(true);

				
				List<Edge> edges = nextCity.getAdjacentEdges();

				
				for (Edge edge : edges) {

					
					City destination = edge.getDestination();

				
					if (destination.isKnown()) {
						continue;
					}

					
					if (destination.getDistance() == -1
							|| destination.getDistance() > nextCity.getDistance() + edge.getDistance()) {
						destination.setDistance(nextCity.getDistance() + edge.getDistance()); 
																								
						destination.setPrev(nextCity); 
					}
				}
			}

			
			if (found) { 

				City current = destCity;

				
				while (current != null && current != source) {

					City prev = current.getPrev();

					
					for (Edge edge : prev.getAdjacentEdges()) {
						if (edge.getDestination() == current) {
							edgesList.add(edge);
							break;
						}
					}

					current = prev; 
				}
			}

			return edgesList;
		}

}
