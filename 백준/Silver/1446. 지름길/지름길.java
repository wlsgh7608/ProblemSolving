import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Shortcut {
        int s;
        int e;
        int dist;

        public Shortcut(int s, int e, int dist) {
            this.s = s;
            this.e = e;
            this.dist = dist;
        }


    }


    static class Route implements Comparable<Route> {
        int v;
        int cost;

        public Route(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Route o) {
            return this.cost - o.cost;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        Shortcut[] shortcuts = new Shortcut[N];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            shortcuts[i] = new Shortcut(s, e, cost);
        }

        int[] dist = new int[target + 1];

        Queue<Route> Q = new ArrayDeque<>();
        Q.add(new Route(0, 0));
        int minValue = Integer.MAX_VALUE;
        while (!Q.isEmpty()) {
            Route current = Q.poll();
            int v = current.v;
            int cost = current.cost;

            if (v > target) {
                continue;
            } else if (v == target) {
                minValue = Math.min(minValue, current.cost);
            }

            Q.add(new Route(v + 1, cost + 1));
            for (Shortcut shortcut : shortcuts) {
                if (shortcut.s == v) {
                    Q.add(new Route(shortcut.e, cost + shortcut.dist));
                }
            }

        }
        System.out.println(minValue);


    }

}
