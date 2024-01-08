package dfs;

/*
 * Depth-first search or DFS recursive
 */
public class DepthFirstSearchV2 {
    public static void main(String[] args) {
        Graph graph = Graph.populate();
        new DepthFirstSearchV2().search(graph);
    }

    public void search(Graph graph) {
        boolean[] visited = new boolean[graph.getVertices()];
        dfs(graph, 0, visited);
    }

    private void dfs(Graph graph, int vertex, boolean[] visited) {
        if (!visited[vertex]) {
            System.out.print(vertex + " ");
            visited[vertex] = true;
        }

        for (int adjacent : graph.getAdjacents().get(vertex)) {
            if (!visited[adjacent]) {
                dfs(graph, adjacent, visited);
            }
        }
    }
}
