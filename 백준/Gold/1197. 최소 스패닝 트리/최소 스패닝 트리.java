import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int s;
        int e;
        int w;

        public Node(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }
    }

    static int getParent(int x, int[] parent) {
        if (parent[x] == x)
            return x;
        return parent[x] = getParent(parent[x], parent);
    }

    static void union(int a, int b, int[] parent) {
        a = getParent(a, parent);
        b = getParent(b, parent);
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());


        int[] parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }
        PriorityQueue<Node> PQ = new PriorityQueue<>((a, b) -> a.w - b.w);
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            PQ.add(new Node(a, b, c));
        }

        int answer = 0;
        while (!PQ.isEmpty()) {
            Node cur = PQ.poll();
            int a = getParent(cur.s, parent);
            int b = getParent(cur.e, parent);
            if (a == b) {
                continue;
            }

            union(a, b, parent);
            answer += cur.w;
        }
        System.out.println(answer);


    }
}
