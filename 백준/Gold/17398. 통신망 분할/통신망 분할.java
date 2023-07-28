import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static class Line {
        int a;
        int b;

        public Line(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    static int[] parent;
    static long[] num;

    static int getParent(int v) {
        if (parent[v] == v) {
            return v;
        }
        return parent[v] = getParent(parent[v]);
    }


    static void union(int a, int b) {
        parent[b] = a;
        num[a] += num[b];
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        num = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
            num[i] = 1;
        }
        Line[] line = new Line[M + 1];

        HashSet<Integer> hs = new HashSet<>();
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            line[i] = new Line(a, b);
            hs.add(i);
        }

        Stack<Integer> S = new Stack<>();
        for (int i = 0; i < Q; i++) {
            int removeN = Integer.parseInt(br.readLine());
            hs.remove(removeN);
            S.add(removeN);
        }

        for (int idx : hs) {
            Line l = line[idx];
            int a = l.a;
            int b = l.b;
            a = getParent(a);
            b = getParent(b);
            if (a != b) {
                union(a, b);
            }

        }

        long result = 0;

        while (!S.isEmpty()) {
            Integer idx = S.pop();
            Line cur = line[idx];
            int a = cur.a;
            int b = cur.b;

            a = getParent(a);
            b = getParent(b);

            if (a != b) {
                result += num[a] * num[b];
                union(a, b);
            }
        }
        System.out.println(result);


    }


}
