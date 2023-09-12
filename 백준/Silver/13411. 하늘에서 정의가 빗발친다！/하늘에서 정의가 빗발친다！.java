import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node> {
        int n;
        double dist;

        public Node(int n, double dist) {
            this.n = n;
            this.dist = dist;
        }

        public int compareTo(Node o) {
            if (this.dist == o.dist) {
                return this.n - o.n;
            }
            return Double.compare(this.dist,o.dist);
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node[] arr = new Node[N];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            arr[i - 1] = new Node(i, (double) Math.sqrt(x * x + y * y) / d);
        }
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (Node n : arr) {
            sb.append(n.n + "\n");
        }
        System.out.println(sb);


    }
}
