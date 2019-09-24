package com.mitrais.dkatalis.q2;

import org.junit.Test;

import java.util.*;
import java.util.stream.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author Achmad Yusuf Ramadhan cupu2903@gmail.com
 * @version 1.0
 * @since 20/09/2019
 */
public class GraphTest {
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

    @Test
    public void findAllGeneratedPathIsInExpectedList() {
        Graph graph = createGraph();
        List<Set<String>> result = new ArrayList<>();
        Set<String> path2 = new HashSet<>(Arrays.asList(new String[]{"B", "C"}));
        Set<String> path3 = new HashSet<>(Arrays.asList(new String[]{"A", "C"}));
        Set<String> path1 = new HashSet<>(Arrays.asList(new String[]{"A", "B", "C"}));

        result.add(path1);
        result.add(path2);
        result.add(path3);

        List<Set<String>> allPossiblePath = Main.findAllPossiblePath(graph);
        IntStream.range(0, allPossiblePath.size()).forEachOrdered(i -> assertThat(allPossiblePath.get(i)).isIn(result));

    }

    @Test
    public void countMaxPath() {
        Graph graph = createGraph();
        int maxPath = Main.getMaxPath(graph);
        assertThat(maxPath).isEqualTo(5);
    }
}
