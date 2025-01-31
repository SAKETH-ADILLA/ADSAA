import java.util.*;
public class BFS {
        public static void bfs(List<List<Integer>> adj, int val, List<Integer> res, boolean visited[]) {
            List<Integer> q = new ArrayList<>();
            visited[val] = true;
            q.add(val);

            while (!q.isEmpty()) {
                int i = q.remove(0);
                res.add(i);
                for (int v : adj.get(i)) {
                    if (!visited[v]) {
                        visited[v] = true;
                        q.add(v);
                    }
                }
            }
        }

        public static void bft(List<List<Integer>> adj) {
            boolean visited[] = new boolean[adj.size()];
            List<Integer> res = new ArrayList<>();

            for (int i = 0; i < adj.size(); i++) {
                if (!visited[i])
                    bfs(adj, i, res, visited);
            }
            System.out.println(res);
        }

        public static void DFSList(List<List<Integer>> ans, int index) {
            boolean[] visited = new boolean[ans.size()];
            DFSRec(ans, index, visited);
        }

        private static void DFSRec(List<List<Integer>> ans, int index, boolean[] visited) {
            visited[index] = true;
            System.out.print(index + " ");
            for (int i : ans.get(index)) {
                if (!visited[i]) {
                    DFSRec(ans, i, visited);
                }
            }
        }
        public static void DFTList(List<List<Integer>> ans) {
            boolean[] visited = new boolean[ans.size()];
            for (int i = 0; i < ans.size(); i++) {
                if (!visited[i]) {
                    DFSRec(ans, i, visited);
                }
            }
        }

        public static void addEdge(List<List<Integer>> adj, int u, int v) {
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        public static void main(String[] args) {
            List<List<Integer>> adj = new ArrayList<>();
            int n = 5;
            for (int i = 0; i < n; i++)
                adj.add(new ArrayList<>());

            addEdge(adj, 0, 4);
            addEdge(adj, 0, 1);
            addEdge(adj, 0, 3);
            addEdge(adj, 1, 2);
            addEdge(adj, 3, 4);
            System.out.println("BFT Traversal:");
            bft(adj);

          
            System.out.println("DFT Traversal:");
            DFTList(adj);


        }
}



