import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int v;
        int dist;

        public Node(int v, int dist) {
            this.v = v;
            this.dist = dist;
        }
    }

    static List<Node>[] adjList;
    static int H;
    static int[][] ac;
    static int[] depth;
    static int[] dist;

    static void initTree(int current, int parent) {
        depth[current] = depth[parent] + 1;
        ac[current][0] = parent;

        for (int i = 1; i < H; i++) {
            int tmp = ac[current][i - 1];
            ac[current][i] = ac[tmp][i - 1];
        }

        for (Node next : adjList[current]) {
            if (next.v != parent) {
                dist[next.v] = dist[current] + next.dist;
                initTree(next.v, current);
            }
        }

    }


    static int query(int a, int b) {
        if (depth[a] < depth[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        } // a가 더 크게 변경

        for (int i = H; i >= 0; i--) {
            int diff = depth[a] - depth[b];
            if (1 << i <= diff) {
                a = ac[a][i];
            }
        }

        if (a == b) {
            return a;
        }

        for (int i = H - 1; i >= 0; i--) {
            if (ac[a][i] != ac[b][i]) {
                a = ac[a][i];
                b = ac[b][i];
            }
        }
        return ac[a][0];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        H = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
        adjList = new List[N + 1];
        depth = new int[N + 1];
        dist = new int[N + 1];
        ac = new int[N + 1][H];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adjList[a].add(new Node(b, c));
            adjList[b].add(new Node(a, c));
        }

        initTree(1, 0);
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int lca = query(a, b);
            int result = dist[a] - dist[lca] + dist[b] - dist[lca];
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
