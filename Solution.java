import java.util.*;

public class Solution {
    static final int N = 100007;
    static int[] dis = new int[N];
    static boolean[] vis = new boolean[N];
    static int[] par = new int[N];

    public static boolean checkPathExists(int n, int source, int destination, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        dis[source] = 0;
        par[source] = -1;
        vis[source] = true;

        while (!q.isEmpty()) {
            int parent = q.poll();

            if (parent == destination) {
                return true;
            }

            for (int child : adj.get(parent)) {
                if (!vis[child]) {
                    q.add(child);
                    par[child] = parent;
                    dis[child] = dis[parent] + 1;
                    vis[child] = true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            int e = in.nextInt();

            ArrayList<ArrayList<Integer>> adj = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                adj.add(new ArrayList<>());
                dis[j] = Integer.MAX_VALUE;
                par[j] = -1;
                vis[j] = false;
            }

            for (int j = 0; j < e; j++) {
                int u = in.nextInt();
                int v = in.nextInt();
                adj.get(u).add(v);
            }

            int s = in.nextInt();
            int d = in.nextInt();

            boolean res = checkPathExists(n, s, d, adj);
            if (res) {
                System.out.println("true");
            } else {
                // If no path, print false
                System.out.println("false");
            }
        }
        in.close();
    }
}
