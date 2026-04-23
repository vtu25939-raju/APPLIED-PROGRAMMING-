import java.util.*;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // 1. Edge Case: If source is destination, a path already exists
        if (source == destination) return true;

        // 2. Build the Adjacency List
        // Using List of Lists for better performance than Map in competitive programming
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        // 3. BFS Setup
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        queue.offer(source);
        visited[source] = true;

        // 4. Traverse the Graph
        while (!queue.isEmpty()) {
            int current = queue.poll();

            // If we find the destination, we're done!
            if (current == destination) return true;

            for (int neighbor : graph[current]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }

        return false;
    }
}