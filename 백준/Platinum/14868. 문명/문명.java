import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


    static int[] parent;
    static int N;
    static int K;

    static boolean[][] visited;
    static int[][] G;
    static Queue<Node> Q;

    static int findParent(int v) {
        if (parent[v] == v) {
            return v;
        }
        return parent[v] = findParent(parent[v]);
    }

    static boolean isEnd() {
        int a = findParent(1);
        for (int i = 1; i <= K; i++) {
            if (findParent(i) != a) {
                return false;
            }
        }
        return true;
    }


    static void checkNeighbor() {
        Queue<Node> newQ = new ArrayDeque<>();
        int size = Q.size();
        while (size-- > 0) {
            Node cur = Q.poll();
            int x = cur.x;
            int y = cur.y;
            newQ.add(cur);

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 1 || ny < 1 || nx > N || ny > N) {
                    continue;
                }
                if (visited[nx][ny]) {
                    union(G[nx][ny], G[x][y]);
                }
            }
        }
        Q = newQ;


    }

    static void spread() {
        int size = Q.size();


        while (size-- > 0) {
            Node cur = Q.poll();
            int x = cur.x;
            int y = cur.y;


            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 1 || ny < 1 || nx > N || ny > N||visited[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;
                G[nx][ny] = G[x][y];
                Q.add(new Node(nx, ny));
            }
        }
    }


    static void union(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a < b) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }

    }

    static class Node {
        int x;
        int y;


        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        parent = new int[K + 1];
        visited = new boolean[N + 1][N + 1];
        G = new int[N + 1][N + 1];
        for (int i = 1; i <= K; i++) {
            parent[i] = i;
        }
         Q = new ArrayDeque<>();

        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            visited[x][y] = true;
            G[x][y] = i;
            Q.add(new Node(x, y));
        }

        int year = 0;

        while (true) {
            checkNeighbor();
            if(isEnd()){
                break;
            }
            spread();
            year++;
        }

        System.out.println(year);
    }
}
