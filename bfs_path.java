import java.util.*;

public class bfs_path {
    static final int N = 100007;
    static Vector<Integer>[] vector = new Vector[N];
    static boolean[] vis = new boolean[N];
    static int[] dis = new int[N];
    static int[] par = new int[N];

    public static void bfs_path_printing(int s){
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        dis[s] = 0;
        par[s] = -1;
        vis[s] = true;

        while(!q.isEmpty()){
            int parent = q.poll();

            for(int child: vector[parent]){
                if(!vis[child]){
                    q.add(child);
                    par[child] = parent;
                    dis[child] = dis[parent] + 1;
                    vis[child] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your node: ");
        int n = in.nextInt();
        System.out.print("Enter your edge: ");
        int e = in.nextInt();

        for(int i=0; i<=n; i++){
            vector[i] = new Vector<>();
        }

        for(int i=0; i<e; i++){
            int u = in.nextInt();
            int v = in.nextInt();
            vector[u].add(v);
            vector[v].add(u);
        }

        bfs_path_printing(1);

        // for(int i=1; i<=n; i++){
        //     System.out.println("Node "+i+": "+par[i]);
        // }
        
        System.out.print("Enter your destination: ");
        int d = in.nextInt();
        if(vis[d]){
            int x = d;
            Vector<Integer> path = new Vector<>();
            while(x != -1){
                path.add(x);
                x = par[x];
            }

            Collections.reverse(path);

            for(int val: path){
                System.out.print(val+" ");
            }
        }
        else{
            System.out.println("No path found!");
        }
    }
}
