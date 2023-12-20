import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static int[] getDist(int V, int start, List<Node>[] adjList) {
        int[] dist = new int[V + 1];
        Arrays.fill(dist, 5_000 * 10_000 + 1);
        dist[start] = 0;


        PriorityQueue<Node> PQ = new PriorityQueue<>();
        PQ.add(new Node(start, 0));

        while (!PQ.isEmpty()) {
            Node cur = PQ.poll();

            for (Node next : adjList[cur.v]) {
                if (cur.cost + next.cost < dist[next.v]) {
                    dist[next.v] = cur.cost + next.cost;
                    PQ.add(new Node(next.v, dist[next.v]));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());


        List<Node>[] adjList = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            adjList[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adjList[a].add(new Node(b, cost));
            adjList[b].add(new Node(a, cost));
        }

        int[] startDist = getDist(V, 1, adjList);
        int[] gunuDist = getDist(V, P, adjList);


        if (startDist[P] + gunuDist[V] <= startDist[V]) {
            System.out.println("SAVE HIM");
        } else {
            System.out.println("GOOD BYE");

        }


    }
}
