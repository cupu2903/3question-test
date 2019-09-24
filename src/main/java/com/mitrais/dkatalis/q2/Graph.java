package com.mitrais.dkatalis.q2;


import java.util.*;

/** this class represent of Graph and Vertex
 * Graph manage all connected vertex
 *
 * @author Achmad Yusuf Ramadhan cupu2903@gmail.com
 * @version 0.4
 * @since 19/09/2019
 * @implNote this is using directed acyclic graph. to prevent infinite loop because cycle, just simple add properties 'visited' to Vertex
 * and use it on method depthFirstTraversal for all vertex already visited mark as true and then validate first before stack.push in loop
 */

public class Graph {
    private Map<Vertex, List<Vertex>> adjVertices;
    public static Map<String,Vertex> vertices ;

    Graph() {
        this.adjVertices = new HashMap<>();
        vertices = new HashMap<>();
    }

    /**
     * init vertex
     * @param label
     * @param weight
     * @return
     */
    Vertex addVertex(String label, Integer weight) {
        Vertex v = new Vertex(label, weight);
        vertices.putIfAbsent(label,v);
        adjVertices.putIfAbsent(v, new ArrayList<>());
        return v;
    }

    /**
     * simply just add connected vertex
     * @param v1
     * @param v2
     */
    void addEdge(Vertex v1, Vertex v2) {
        adjVertices.get(v1).add(v2);
    }

    List<Vertex> getAdjVertices(String label) {
        Vertex vertex = vertices.get(label);
        System.out.println(vertex);
        return adjVertices.get(vertex);
    }

    public Map<Vertex, List<Vertex>> getAdjVertices() {
        return adjVertices;
    }

    class Vertex {
        String label;
        int weight;

        Vertex(String label, int weight) {
            this.label = label;
            this.weight = weight;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + getOuterType().hashCode();
            result = prime * result + ((label == null) ? 0 : label.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Vertex other = (Vertex) obj;
            if (!getOuterType().equals(other.getOuterType()))
                return false;
            if (label == null) {
                if (other.label != null)
                    return false;
            } else if (!label.equals(other.label))
                return false;
            return true;
        }

        @Override
        public String toString() {
            return label;
        }


        private Graph getOuterType() {
            return Graph.this;
        }
    }
}
