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
public class FindIntArrayBreadthFirstSearch {
    public static void main(String[] args) {
        int[][] matriz = {
                {0, 1, 1, 0, 0, 0, 0}, // 0: 1, 2
                {1, 0, 0, 1, 1, 0, 0}, // 1: 0, 3, 4
                {1, 0, 0, 0, 0, 1, 1}, // 2: 0, 5, 6 *
                {0, 1, 0, 0, 0, 0, 0}, // 3: 1
                {0, 1, 0, 0, 0, 0, 0}, // 4: 1
                {0, 0, 5, 0, 0, 0, 0}, // 5: 2 *
                {0, 0, 1, 0, 0, 0, 0}  // 6: 2
        };

        bfsFind(matriz, 0, 5);
    }

    private static void bfsFind(int[][] matriz, int startNode, int targetValue) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(startNode);
        queue.offer(startNode);

        while (!queue.isEmpty()) {
            int nodeValue = queue.poll();

            if (nodeValue == targetValue) {
                System.out.println("Found: " + nodeValue);
                return;
            }

            for (int i = 0; i < matriz.length; i++) {
                if (matriz[nodeValue][i] == 1 && !visited.contains(i)) {
                    visited.add(i);
                    queue.offer(i);
                }
            }
        }

        System.out.println("Didn't found the value");
    }
}
