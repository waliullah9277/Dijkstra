import java.util.*;
class Edge {
    int node, weight;

    public Edge(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

class EdgeComparator implements Comparator<Edge> {
    public int compare(Edge e1, Edge e2) {
        return e1.weight - e2.weight;
    }
}

public class pathCheck {

    public static void initialize(int n, ArrayList<Edge>[] adjList, 
    int[] distance, boolean[] visited, int[] parent) {
        for (int i = 0; i <= n; i++) {
            adjList[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
            visited[i] = false;
            parent[i] = -1;
        }
    }

    public static boolean dijkstra(int source, int destination, 
    ArrayList<Edge>[] adjList, int[] distance, 
    boolean[] visited, int[] parent) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(new EdgeComparator());
        distance[source] = 0;
        pq.add(new Edge(source, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int currentNode = current.node;

            if (currentNode == destination) {
                return true;
            }

            if (visited[currentNode]) continue;
            visited[currentNode] = true;

            for (Edge neighbor : adjList[currentNode]) {
                int neighborNode = neighbor.node;
                int newCost = distance[currentNode] + neighbor.weight;

                if (newCost < distance[neighborNode]) {
                    distance[neighborNode] = newCost;
                    pq.add(new Edge(neighborNode, newCost));
                    parent[neighborNode] = currentNode;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int e = in.nextInt();

            ArrayList<Edge>[] adjList = new ArrayList[n + 1];
            int[] distance = new int[n + 1];
            boolean[] visited = new boolean[n + 1];
            int[] parent = new int[n + 1];

            initialize(n, adjList, distance, visited, parent);

            for (int i = 0; i < e; i++) {
                int u = in.nextInt();
                int v = in.nextInt();
                int w = in.nextInt();
                adjList[u].add(new Edge(v, w));
            }

            int source = in.nextInt();
            int destination = in.nextInt();

            boolean isReachable = dijkstra(source, destination, 
            adjList, distance, visited, parent);

            if (isReachable) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }
        in.close();
    }
}
