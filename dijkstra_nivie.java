import java.util.*;

class Edge{
    int u,v,w;
    public Edge(int u, int v, int w){
        this.u=u;
        this.v=v;
        this.w=w;
    }
}

public class dijkstra_nivie {
    static final int N = 100007;
    static Vector<Edge>[] vector = new Vector[N];
    static int[] dis = new int[N];

    public static void dijkstra(int s){
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        dis[s]=0;

        while (!q.isEmpty()) {
            int parent = q.poll();

            for(Edge child: vector[parent]){
                if(dis[parent] + child.w < dis[child.v]){
                    dis[child.v] = dis[parent] + child.w;
                    q.add(child.v);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // System.out.print("Enter your node: ");
        int n = in.nextInt();
        // System.out.print("Enter your edge: ");5
        int e = in.nextInt();

        for(int i=1; i<=n; i++){
            vector[i] = new Vector<>();
            dis[i] = Integer.MAX_VALUE;
        }

        for(int i=0; i<e; i++){
            int u = in.nextInt();
            int v = in.nextInt();
            int w = in.nextInt();
            vector[u].add(new Edge(u, v, w));
            vector[v].add(new Edge(v, u, w));
        }

        dijkstra(1);

        for(int i=1;i<=n;i++){
            System.out.println("Node "+i+": "+dis[i]);
        }
    }
}