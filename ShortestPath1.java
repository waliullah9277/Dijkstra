import java.util.*;

class ShortestPath1 {
    static final int V = 5; // Number of vertices in the graph

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

    void printSinglePath(int parent[], int j) {
        if (parent[j] == -1) {
            System.out.print("No Path"); // Handle cases with no path
            return;
        }
        Stack<Integer> path = new Stack<>(); // Use a stack to reverse the path order
        while (j != -1) {
            path.push(j); // Push vertices to the stack
            j = parent[j]; // Move to the parent vertex
        }
        while (!path.isEmpty()) {
            System.out.print(path.pop() + " "); // Print the path in correct order
        }
        System.out.println(); // Move to next line after printing the path
    }

    void dijkstra(int graph[][], int src, int target) {
        int dist[] = new int[V]; 
        Boolean sptSet[] = new Boolean[V];
        int parent[] = new int[V];

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
            parent[i] = -1;
        }

        dist[src] = 0;

        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, sptSet);
            sptSet[u] = true;

            for (int v = 0; v < V; v++) {
                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                    parent[v] = u;
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        System.out.println("Shortest path from " + src + " to " + target + ":");
        if (dist[target] == Integer.MAX_VALUE) {
            System.out.println("No Path");
        } else {
            printSinglePath(parent, target);
        }
    }

    public static void main(String[] args) {
        int graph[][] = new int[][] { 
            { 0, 0, 0, 0, 3 },
            { 0, 0, 0, 3, 6 },
            { 1, 2, 7, 0, 0 },
            { 0, 0, 0, 0, 5 },
            { 0, 0, 0, 6, 0 }
        };

        ShortestPath1 t = new ShortestPath1();
        
        int src = 2;
        int target = 3;
        
        t.dijkstra(graph, src, target);
    }
}
