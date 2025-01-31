import java.util.*;

public class BFT {
    public static void bfs(int[][] adj, int val, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(val);
        visited[val] = true;
        while (!q.isEmpty()) {
            int curr = q.poll();
            System.out.print(curr + " ");
            for (int i = 0; i < adj.length; i++) {
                if (adj[curr][i] == 1 && (!visited[i])) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void bft(int[][] adj) {
        boolean[] visited = new boolean[adj.length];

        for (int i = 0; i < adj.length; i++) {
            if (!visited[i]) {
                bfs(adj, i, visited);
            }
        }
    }
    private static void dfsRec(int[][] adj, int val, boolean[] visited) {
        visited[val] = true;
        System.out.print(val + " ");
        for (int i = 0; i < adj.length; i++) {
            if (adj[val][i] == 1 && !visited[i]) {
                dfsRec(adj, i, visited);
            }
        }
    }
    public static void dft(int[][] adj) {
        boolean[] visited = new boolean[adj.length];
        for (int i = 0; i < adj.length; i++) {
            if (!visited[i]) {
                dfsRec(adj, i, visited);
            }
        }
    }

    public static void main(String[] args) {

        int[][] adj = { {0, 1, 0, 1, 1}, {1, 0, 1, 0, 0}, {0, 1, 0, 0, 0}, {1, 0, 0, 0, 1}, {1, 0, 0, 1, 0} };
        System.out.print("BFS with Matrix: ");
        bft(adj);
        System.out.println();


        System.out.print("DFS with Matrix: ");
        dft(adj);
    }
}

