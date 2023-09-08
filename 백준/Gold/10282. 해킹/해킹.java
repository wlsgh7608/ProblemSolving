import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int MAX_VALUE = 1_000_000_001;

    static class Computer implements Comparable<Computer> {
        int n;
        int t;

        public Computer(int n, int t) {
            this.n = n;
            this.t = t;
        }


        public int compareTo(Computer o) {
            return this.t - o.t;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            List<Computer> adjList[] = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                adjList[i] = new ArrayList<>();
            }
            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                adjList[b].add(new Computer(a, c));
            }
            int[] dist = new int[N + 1];
            Arrays.fill(dist, MAX_VALUE);
            Queue<Computer> Q = new ArrayDeque<>();
            Q.add(new Computer(C, 0));
            dist[C] = 0;

            while (!Q.isEmpty()) {
                Computer cur = Q.poll();
                int n = cur.n;
                int t = cur.t;

                for (Computer next : adjList[n]) {
                    if (dist[next.n] > t + next.t) {
                        dist[next.n] = t + next.t;
                        Q.add(new Computer(next.n, dist[next.n]));
                    }
                }
            }
            int cnt = 0;
            int maxValue = 0;
            for (int i = 1; i <= N; i++) {
                if (dist[i] != MAX_VALUE) {
                    cnt++;
                    maxValue = Math.max(maxValue, dist[i]);
                }
            }
            sb.append(cnt + " " + maxValue).append("\n");
        }//end while
        System.out.println(sb);
    }
}
