package dfs;

import java.util.*;

public class Graph {
    private final int vertices;
    private final List<List<Integer>> adjacents;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjacents = new ArrayList<>(vertices);

        for (int i = 0; i < vertices; i++) {
            adjacents.add(new ArrayList<>());
        }
    }

    public void addEdge(int vertex, int value) {
        adjacents.get(vertex).add(value);
    }

    public int getVertices() {
        return vertices;
    }

    public List<List<Integer>> getAdjacents() {
        return adjacents;
    }

    public static Graph populate() {
        Graph graph = new Graph(8);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);
        graph.addEdge(3, 7);

        return graph;
    }
}
