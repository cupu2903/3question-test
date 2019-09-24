package com.mitrais.dkatalis.q2;

import java.util.*;

/** The step of using BFS and DFS will consume V+(E^2) time.
 * @author Achmad Yusuf Ramadhan cupu2903@gmail.com
 * @version 0.4
 * @since 19/09/2019
 */
public class Main {
    static Graph createGraph() {
        Graph graph = new Graph();
        Graph.Vertex a = graph.addVertex("A", 1);
        Graph.Vertex b = graph.addVertex("B", 2);
        Graph.Vertex c = graph.addVertex("C", 2);
        graph.addEdge(a, b);
        graph.addEdge(b, c);
        graph.addEdge(a, c);
        return graph;
    }

    public static int getMaxPath(Graph graph){

        System.out.println("---------");
        List<Set<String>> allPossiblePath = findAllPossiblePath(graph);
        System.out.println("---------");
        System.out.println(allPossiblePath);
        int max = Integer.MIN_VALUE;
        for (Set<String> paths : allPossiblePath) {
            int weight = 0;
            for (String vertex : paths) { // sum weight from all of node on path
                Graph.Vertex vertex1 = Graph.vertices.get(vertex);
                weight += vertex1.weight;
            }
            max = Math.max(max, weight);
        }
        return max;
    }

    public static void main(String[] args) {
        Graph graph = createGraph();
        int maxPath = getMaxPath(graph);
        System.out.println("Max Path = "+maxPath);
    }



    /**
     * this method is just simply to find all paths from all nodes
     * @param graph
     * @return
     */
    public static List<Set<String>> findAllPossiblePath(Graph graph) {
        List<Set<String>> sets = new ArrayList<>();
        for (Graph.Vertex v : graph.getAdjVertices().keySet()) {
            System.out.println("Vertex :" + v.label);
            LinkedHashSet<Set<String>> sets1 = GraphTraversal.breadthFirstTraversal(graph, v.label);
            sets.addAll(sets1);
        }
        return sets;
    }
}
