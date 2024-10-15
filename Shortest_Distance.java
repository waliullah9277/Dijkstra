import java.util.*;

class Edge{
    int u,w;
    public Edge(int u, int w){
        this.u = u;
        this.w = w;
    }
}

class EdgeCom implements Comparator<Edge>{
    public int compare(Edge u, Edge v){
        return u.w - v.w;
    }
}

public class Shortest_Distance{
    static final int N = 100007;
    static Vector<Edge>[] vector = new Vector[N];
    static int[] dis = new int[N];
    static boolean[] visited = new boolean[N];

    public static void dijkstra(int s){
        PriorityQueue<Edge> pq = new PriorityQueue<>(new EdgeCom());
        dis[s] = 0;
        // par[s] = -1;
        pq.add(new Edge(s, 0));

        while(!pq.isEmpty()){
            Edge parent = pq.poll();

            int parentNode = parent.u;

            if(visited[parentNode]) continue;
            visited[parentNode] = true;

            int parentCost = parent.w;

            for(Edge child: vector[parentNode]){
                int childNode = child.u;
                int childCost = child.w;

                if(parentCost + childCost < dis[childNode]){
                    dis[childNode] = parentCost + childCost;
                    pq.add(new Edge(childNode, dis[childNode]));
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int e = in.nextInt();

        for(int j=1; j<=n; j++){
            vector[j] = new Vector<>();
            dis[j] = Integer.MAX_VALUE;
        }

        for (int j = 0; j < e; j++) {
            int u = in.nextInt();
            int v = in.nextInt();
            int w = in.nextInt();
            vector[u].add(new Edge(v, w));
        }

        int s = in.nextInt();

        dijkstra(s);

        int t = in.nextInt();
        while(t-- > 0){
            int d = in.nextInt();
            System.out.println(dis[d]);
        }
        in.close();
    }
}

