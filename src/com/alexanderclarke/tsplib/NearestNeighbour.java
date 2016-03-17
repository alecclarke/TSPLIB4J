package com.alexanderclarke.tsplib;

import org.moeaframework.problem.tsplib.DistanceTable;
import org.moeaframework.problem.tsplib.TSPInstance;
import org.moeaframework.problem.tsplib.Tour;

import java.util.ArrayList;

/**
 * Created by alexanderclarke on 2016-03-15.
 */
public class NearestNeighbour {
    /**
     * The traveling salesman problem instance.
     */
    private final TSPInstance instance;

    /**
     * Constructs a new Nearest Neighbour tour for the specified traveling salesman
     * problem instance.
     *
     * @param instance the traveling salesman problem instance
     */
    public NearestNeighbour(TSPInstance instance) {
        this.instance = instance;
    }

    /**
     * Applies the Nearest Neighbour to the specified tour starting at the first node.
     */
    public Tour apply() {
        DistanceTable distanceTable = instance.getDistanceTable();
        int[] nodes = distanceTable.listNodes();
        int size = nodes.length;
        int node = nodes[0];
        ArrayList<Integer> availableNodes = TourHelper.toArrayList(nodes);
        ArrayList<Integer> path = new ArrayList<Integer>();
        path.add(node);
        availableNodes.remove(new Integer(node));

        for(int i = 0; i<size-1; i++){
            int minNode = availableNodes.get(0);
            double min = distanceTable.getDistanceBetween(node, minNode);
            for (int neighbour:availableNodes) {
                if (distanceTable.getDistanceBetween(node,neighbour)<min){
                    min = distanceTable.getDistanceBetween(node, neighbour);
                    minNode = neighbour;
                }
            }
            node = minNode;
            path.add(minNode);
            availableNodes.remove(new Integer(minNode));
        }
        //complete tour
        path.add(distanceTable.listNodes()[0]);
        //return tour
        return new Tour().createTour(TourHelper.toArray(path));
    }
}
