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

public class dijOp {
    static final int N = 100007;
    static Vector<Edge>[] vector = new Vector[N];
    static int[] dis = new int[N];
    static boolean[] visited = new boolean[N];
    static int[] par = new int[N];

    public static void dijkstra(int s){
        PriorityQueue<Edge> pq = new PriorityQueue<>(new EdgeCom());
        dis[s] = 0;
        par[s] = -1;
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
                    par[childNode] = parentNode;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // System.out.print("Enter your node: ");
        int n = in.nextInt();
        // System.out.print("Enter your edge: ");
        int e = in.nextInt();

        for(int i=1; i<=n; i++){
            vector[i] = new Vector<>();
            dis[i] = Integer.MAX_VALUE;
        }

        for(int i=0; i<e; i++){
            int u = in.nextInt();
            int v = in.nextInt();
            int w = in.nextInt();

            vector[u].add(new Edge(v, w));
            vector[v].add(new Edge(u, w));
        }

        int s = in.nextInt();
        int d = in.nextInt();

        dijkstra(s);

        if(visited[d]){
            int x = d;
            Vector<Integer> path = new Vector<>();
            while(x != -1){
                path.add(x);
                x = par[x];
            }

            Collections.reverse(path);

            System.out.print("Shortest Path in this graph: ");
            for(int val: path){
                System.out.print(val+" ");
            }
        }
        System.out.println("Minimum cost of this path is: "+dis[d]);

        // for(int i=1; i<=n; i++){
        //     System.out.println("Node "+i+": "+dis[i]);
        // }
    }
}
