import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        boolean isWolf;
        int n;
        int num;

        public Node(boolean isWolf, int n, int num) {
            this.isWolf = isWolf;
            this.n = n;
            this.num = num;
        }
    }


    static Node[] nodes;
    static List<Integer>[] adjList;
    static boolean[] visited;


    static long dfs(int v) {
        visited[v] = true;


        Node cur = nodes[v];

        int idx = cur.n;
        long cnt = 0;
        for (int next : adjList[idx]) {
            if (!visited[next]) {
                cnt += dfs(next);
            }
        }
        if (cur.isWolf) {
            cnt = Math.max(0, cnt - cur.num);
        } else {
            cnt += cur.num;
        }
        return cnt;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        nodes = new Node[N + 1];
        nodes[1] = new Node(false, 1, 0);
        adjList = new List[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 2; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            int num = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            boolean isWolf = true;
            if (c == 'S') {
                isWolf = false;
            }
            nodes[i] = new Node(isWolf, i, num);
            adjList[i].add(next);
            adjList[next].add(i);
        } // end for

        long result = dfs(1);
        System.out.println(result);


    }
}
