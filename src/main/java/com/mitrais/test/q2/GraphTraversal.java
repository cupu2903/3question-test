package com.mitrais.test.q2;

import java.util.*;

/**
 * this class represent of DFS and BFS approach
 * @author Achmad Yusuf Ramadhan cupu2903@gmail.com
 * @version 0.4
 * @since 19/09/2019
 */
public class GraphTraversal {

    /**
     * this method using depth first traversal to collect all path from root
     * in the simplest way go deeper to the last edge first and found a path for all connected vertex
     * @param graph the graph collection
     * @param adj the neighboor of vertex
     * @param root root vertex
     * @return
     */
    static LinkedHashSet<Set<String>> depthFirstTraversal(Graph graph, String adj, String root) {
        LinkedHashSet<Set<String>> paths = new LinkedHashSet<>();
        Set<String> visited = new LinkedHashSet<String>();
        Stack<String> stack = new Stack<String>();
        stack.push(adj);
        visited.add(root);
        while (!stack.isEmpty()) {
            String vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                for (Graph.Vertex v : graph.getAdjVertices(vertex)) {
                    stack.push(v.label);
                }
                paths.add(visited);
            }
        }
        return paths;
    }

    /**
     * this method using breadth first traversal, so we will collect all nodes directed to root
     * @param graph
     * @param root
     * @return
     */

    static LinkedHashSet<Set<String>> breadthFirstTraversal(Graph graph, String root) {
        LinkedHashSet<Set<String>> paths = new LinkedHashSet<>();
        Queue<String> queue = new LinkedList<String>();
        queue.add(root);
        while (!queue.isEmpty()) {
            String vertex = queue.poll();
            for (Graph.Vertex v : graph.getAdjVertices(vertex)) {
                paths.addAll(depthFirstTraversal(graph, v.label, root));
            }
        }
        return paths;
    }
}
