package bfs;

import java.util.*;

/*
 * Busca em Largura (BFS - Breadth-First search) for array.
 *
 * Time O(n)
 * Space O(n)
 *
 * Matriz used in this example:
 * 0 --- 1 --- 3
 * |     |   / |
 * |     | /   |
 * 2 --- 4     6
 *  \
 *    5
 */
public class ArrayBreadthFirstSearch {
    public static void main(String[] args) {
        // int[][] matriz = new int[5][5];
        // matriz[0][0] = 1;
        int[][] matriz = {
                {0, 1, 1, 0, 0, 0, 0}, // 0: 1, 2
                {1, 0, 0, 1, 1, 0, 0}, // 1: 0, 3, 4
                {1, 0, 0, 0, 0, 1, 1}, // 2: 0, 5, 6
                {0, 1, 0, 0, 0, 0, 0}, // 3: 1
                {0, 1, 0, 0, 0, 0, 0}, // 4: 1
                {0, 0, 1, 0, 0, 0, 0}, // 5: 2
                {0, 0, 1, 0, 0, 0, 0}  // 6: 2
        };

        bfs(0, matriz);
    }

    /*
     * Visite the start node position and yours sub nodes.
     *
     * You can add others conditions into the for.
     */
    private static void bfs(int startNode, int[][] matriz) {
        boolean[] visited = new boolean[matriz.length];
        Queue<Integer> queue = new LinkedList<>();

        visited[startNode] = true;
        queue.add(startNode);
        System.out.println("Start node: " + startNode);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int i = 0; i < matriz[node].length; i++) {
                if (matriz[node][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                    System.out.println("Visited: " + matriz[node][i]);
                }
            }
        }
    }
}
