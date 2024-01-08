package dfs;

import java.util.*;

/*
 * Depth-first search or DFS iterative
 */
public class DepthFirstSearchV1 {
    public static void main(String[] args) {
        Graph graph = Graph.populate();
        new DepthFirstSearchV1().dfs(graph);
    }

    public void dfs(Graph graph) {
        boolean[] visited = new boolean[graph.getVertices()]; // memory to remember visited
        Stack<Integer> stack = new Stack<>();

        stack.push(0); // first vertex to start, can be any number

        while (!stack.isEmpty()) {
            int currentVertex = stack.pop(); // get and remove the top of stack

            if (!visited[currentVertex]) {
                System.out.print(currentVertex + " ");
                visited[currentVertex] = true;
            }

            // add all adjacents to the stack
            for (int adjacent : graph.getAdjacents().get(currentVertex)) {
                if (!visited[adjacent]) {
                    stack.push(adjacent);
                }
            }
        }
    }
}
