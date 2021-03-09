package graph;

import java.util.LinkedList;
import java.util.List;;

public class City {
	private String name;     
	private boolean known;    
	private double distance;  
	private City prev;        
	private List<Edge> adjacentEdges; 
	
	
	public City(String name) {
		this.setName(name);
		setAdjacentEdges(new LinkedList<Edge>());
		setPrev(null);
	}


	public int hashCode() {
		
		return getName().hashCode();
	}


	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null) {
			return false;
		}
		if (!(o instanceof City)) {
			return false;
		}
		City oCityNext = (City) o;

		return getName().equals(oCityNext.getName());
	}

	public void addEdge(Edge edge) {
		getAdjacentEdges().add(edge);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public City getPrev() {
		return prev;
	}

	public void setPrev(City prev) {
		this.prev = prev;
	}

	public double getDistance() {
		return distance;
	}

	void setDistance(double distance) {
		this.distance = distance;
	}

	List<Edge> getAdjacentEdges() {
		return adjacentEdges;
	}

	public void setAdjacentEdges(List<Edge> adjacentEdges) {
		this.adjacentEdges = adjacentEdges;
	}

	public boolean isKnown() {
		return known;
	}

	public void setKnown(boolean known) {
		this.known = known;
	}

	@Override
	public String toString() {
		return name;
	}

}
