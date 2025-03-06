import java.util.*;

public class DijkstraAdjList {
    static class Edge {
        int vertex;
        int weight;
        Edge(int v, int w) {
            vertex = v;
            weight = w;
        }
    }
    public static void dijkstra(List<List<Edge>> graph, int src, int V) {
        int[] dist = new int[V];   
        boolean[] sptSet = new boolean[V]; 
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{src, 0}); 

        while (!pq.isEmpty()) {
            int[] u = pq.poll();
            int vertex = u[0];
            int d = u[1];

            if (sptSet[vertex]) continue;

            sptSet[vertex] = true;

            for (Edge edge : graph.get(vertex)) {
                int v = edge.vertex;
                int weight = edge.weight;

                if (!sptSet[v] && dist[vertex] != Integer.MAX_VALUE && dist[vertex] + weight < dist[v]) {
                    dist[v] = dist[vertex] + weight;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }
        System.out.println("Vertex \t Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + " \t " + (dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]));
        }
    }

    public static void main(String[] args) {
        int V = 6; 
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(new Edge(1, 10));
        graph.get(0).add(new Edge(3, 30));
        graph.get(1).add(new Edge(0, 10));
        graph.get(1).add(new Edge(2, 50));
        graph.get(2).add(new Edge(1, 50));
        graph.get(2).add(new Edge(3, 20));
        graph.get(2).add(new Edge(4, 10));
        graph.get(3).add(new Edge(0, 30));
        graph.get(3).add(new Edge(2, 20));
        graph.get(3).add(new Edge(4, 60));
        graph.get(4).add(new Edge(2, 10));
        graph.get(4).add(new Edge(3, 60));
        graph.get(4).add(new Edge(5, 10));
        graph.get(5).add(new Edge(4, 10));
        int src = 0; 
        dijkstra(graph, src, V);
    }
}
