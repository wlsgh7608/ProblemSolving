import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int v;
        long d;

        public Node(int v, long d) {
            this.v = v;
            this.d = d;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.d, o.d);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Node>[] adjList = new List[N + 1];

        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adjList[a].add(new Node(b, c));
            adjList[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        long[] dist = new long[N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[s] = 0;


        Queue<Node> Q = new PriorityQueue<>();
        Q.add(new Node(s, 0));
        while (!Q.isEmpty()) {
            Node cur = Q.poll();
            int v = cur.v;
            long d = cur.d;
            if (v == t) {
                break;
            }


            for (Node next : adjList[v]) {
                if (d + next.d < dist[next.v]) {
                    dist[next.v] = d + next.d;
                    Q.add(new Node(next.v, dist[next.v]));
                }
            }

        }
        System.out.println(dist[t]);

    }
}
