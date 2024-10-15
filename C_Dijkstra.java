import java.util.*; 
import java.lang.*; 
import java.io.*;


public class C_Dijkstra {

    static class Edge{
        int u;
        long w;
        Edge(int u, long w){
            this.u = u;
            this.w = w;
        }
    }
    
    static class EdgeCom implements Comparator<Edge>{
        public int compare(Edge u, Edge v){
            return Long.compare(u.w, v.w);
        }
    }

    static final int N = 100007;
    static Vector<Edge>[] vector = new Vector[N];
    static long[] dis = new long[N];
    static boolean[] vis = new boolean[N];
    static int[] par = new int[N];

    public static void dijkstra(int s){
        PriorityQueue<Edge> pq = new PriorityQueue<>(new EdgeCom());
        // Arrays.fill(dis, Long.MAX_VALUE);

        dis[s] = 0;
        par[s] = -1;
        pq.add(new Edge(s, 0));

        while(!pq.isEmpty()){
            Edge parent = pq.poll();
            int parentNode = parent.u;

            if(vis[parentNode]) continue;
            vis[parentNode] = true;

            long parentCost = parent.w;

            for(Edge child: vector[parentNode]){
                int childNode = child.u;
                long childCost = child.w;

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
        int n = in.nextInt();
        int e = in.nextInt();

        for(int i=1; i<=n; i++){
            vector[i] = new Vector<>();
            dis[i] = Long.MAX_VALUE;
        }

        for(long i=0; i<e; i++){
            int u = in.nextInt();
            int v = in.nextInt();
            int w = in.nextInt();
            vector[u].add(new Edge(v, w));
            vector[v].add(new Edge(u, w));
        }

        dijkstra(1);

        if(vis[n]){
            int x = n;
            Vector<Long> path = new Vector<>();
            while(x != -1){
                path.add((long) x);
                x = par[x];
            }
            Collections.reverse(path);
            for(Long val: path){
                System.out.print(val+" ");
            }
        }
        else{
            System.out.println("-1");
        }
    }
}