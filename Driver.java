package graph;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Driver {
	private static Scanner keyboard = new Scanner(System.in);


	public static void main(String[] args) {
		
		Graph graph = new Graph();

		// city data initialization
		City Ashland = new City("Ashland");
		City Mason = new City("Mason");
		City Exeland = new City("Exeland");
		City Hurley = new City("Hurley");
		City Mellen = new City("Mellen");
		City Winter = new City("Winter");
		City Hayward = new City("Hayward");
		City Phillips = new City("Phillips");
		City Buttemut = new City("Buttemut");
		City Couderay = new City("Couderay");
		
		graph.addCity(Ashland);
		graph.addCity(Mason);
		graph.addCity(Exeland);
		graph.addCity(Hurley);
		graph.addCity(Mellen);
		graph.addCity(Winter);
		graph.addCity(Hayward);
		graph.addCity(Phillips);
		graph.addCity(Buttemut);
		graph.addCity(Couderay);

		// distance between two cities
		graph.addEdge(Ashland, Mason, 18.6);
		graph.addEdge(Exeland, Ashland, 95.6);
		graph.addEdge(Hurley, Ashland, 37.9);
		graph.addEdge(Ashland, Mellen, 24.1);
		graph.addEdge(Winter, Mellen, 57.5);
		graph.addEdge(Ashland, Mellen, 24.1);
		graph.addEdge(Hayward, Mellen, 52.7);
		graph.addEdge(Phillips, Couderay, 15.9);
		graph.addEdge(Hayward, Phillips, 72.8);
		graph.addEdge(Buttemut, Hayward, 62.0);
		graph.addEdge(Hurley, Exeland, 96.5);
		graph.addEdge(Couderay, Mason, 58.3);
		graph.addEdge(Mellen, Buttemut, 26.1);
		graph.addEdge(Winter, Buttemut, 37.7);
		graph.addEdge(Buttemut, Phillips, 25.2);
		graph.addEdge(Exeland, Phillips, 55.1);
		graph.addEdge(Hayward, Exeland, 34.1);
		graph.addEdge(Couderay, Exeland, 10.8);
		graph.addEdge(Winter, Exeland, 20.2);
		graph.addEdge(Mellen, Hurley, 25.7);
		graph.addEdge(Mason, Hayward, 41.3);
		graph.addEdge(Buttemut, Hurley, 51.1);
		
		String startCity = "";
		String endCity = "";
		
		
		System.out.println("Please enter the start city:");
		startCity = keyboard.nextLine();
		
		System.out.println("Please enter the destination city:");
		endCity = keyboard.nextLine();
		

		
		List<Edge> path = graph.findPath(startCity, endCity);
		
		
		Collections.reverse(path);

		System.out.print("Shortest path between " + startCity + " and " + endCity + ": ");
		System.out.println(path);

	}

}
