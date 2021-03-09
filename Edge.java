package graph;

public class Edge {
	private double distance; // distance between 2 cities
	private City source; // Start city
	private City destination; // End city


	public Edge(City source, City destination, double distance) {
		this.source = source;
		this.destination = destination;
		this.setDistance(distance);
	}

	public String toString() {
		return source + " - " + getDestination();
	}

	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null) {
			return false;
		}
		if (!(o instanceof Edge)) {
			return false;
		}
		Edge oEdge = (Edge) o;

		return (source.equals(oEdge.source) && getDestination().equals(oEdge.getDestination())
				&& getDistance() == oEdge.getDistance())
				|| (source.equals(oEdge.getDestination()) && getDestination().equals(oEdge.source)
						&& getDistance() == oEdge.getDistance());
	}

	double getDistance() {
		return distance;
	}

	void setDistance(double distance) {
		this.distance = distance;
	}

	City getDestination() {
		return destination;
	}

	void setDestination(City destination) {
		this.destination = destination;
	}

}
