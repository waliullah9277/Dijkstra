import java.util.*;

class ShortestPath {
    static final int V = 5;
    static int parent[] = new int[V];    
    static Boolean sptSet[] = new Boolean[V];

    int minDistance(int dist[], Boolean sptSet[]) {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++) {
            if (!sptSet[v] && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
        }
        return min_index;
    }

    void printSolution(int dist[], int src, int target) {
        System.out.println("Vertex \t\t Distance from Source");
        System.out.println(target + " \t\t " + dist[target]);
    }

    void dijkstra(int graph[][], int src, int target) {
        int dist[] = new int[V];

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
            parent[i] = -1; 
        }

        dist[src] = 0;
        parent[src] = -1;

        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, sptSet);
            sptSet[u] = true;

            for (int v = 0; v < V; v++) {
                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                    parent[v] = u; 
                }
            }
        }

        printSolution(dist, src, target);

        if (dist[target] != Integer.MAX_VALUE) {
            int p = target;
            ArrayList<Integer> path = new ArrayList<>();
            while (p != -1) {
                path.add(p);
                p = parent[p];
            }

            Collections.reverse(path);

            System.out.print("Shortest Path is: ");
            for (int val : path) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Example graph input
        int graph[][] = new int[][] { 
            { 0, 0, 0, 0, 3 },
            { 0, 0, 0, 3, 6 },
            { 1, 2, 7, 0, 0 },
            { 0, 0, 0, 0, 5 },
            { 0, 0, 0, 6, 0 }
        };

        ShortestPath t = new ShortestPath();
        int src = 2;
        int target = 3;
        t.dijkstra(graph, src, target);
    }
}
