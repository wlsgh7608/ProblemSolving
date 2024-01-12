import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Truck {
        int n;
        int w;

        public Truck(int n, int w) {
            this.n = n;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Queue<Integer> T = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            T.add(n);
        }

        Queue<Truck> Q = new ArrayDeque<>();

        int t = 0;


        int totWeight = 0;
        while (!Q.isEmpty() || !T.isEmpty()) {

            if (!Q.isEmpty() && Q.peek().n == t) {
                Truck cur = Q.poll();
                totWeight -= cur.w;
            }

            if (!T.isEmpty() && T.peek() + totWeight <= L) {
                Integer weight = T.poll();
                Q.add(new Truck(W + t, weight));
                totWeight += weight;
            }
            t++;
        }
        System.out.println(t);
    }
}
