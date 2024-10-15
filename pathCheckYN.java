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

public class pathCheckYN {
    static final int N = 100007;
    static Vector<Edge>[] vector = new Vector[N];
    static int[] dis = new int[N];
    static boolean[] visited = new boolean[N];
    static int[] par = new int[N];

    public static boolean dijkstra(int s, int d){
        PriorityQueue<Edge> pq = new PriorityQueue<>(new EdgeCom());
        dis[s] = 0;
        par[s] = -1;
        pq.add(new Edge(s, 0));

        while(!pq.isEmpty()){
            Edge parent = pq.poll();

            int parentNode = parent.u;

            if(parentNode == d){
                return true;
            }

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
        return false;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for(int i=1; i<=t; i++){
            int n = in.nextInt();
            int e = in.nextInt();

            for(int j=0; j<n; j++){
                vector[j] = new Vector<>();
                dis[j] = Integer.MAX_VALUE;
            }

            for (int j = 0; j < e; j++) {
                int u = in.nextInt();
                int v = in.nextInt();
                int w = in.nextInt();
                vector[u].add(new Edge(v, w));
            }

            // input source and destination
            int s = in.nextInt();
            int d = in.nextInt();

            boolean res = dijkstra(s,d);

            // path printing 
            if(res){
                System.out.println("true");
            }
            else{
                System.out.println("false");
            }
        }
        in.close();
    }
}

