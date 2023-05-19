import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static class Num {
        int n;
        int cnt;
        int copy;

        public Num(int n, int cnt, int copy) {
            this.n = n;
            this.cnt = cnt;
            this.copy = copy;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Num> Q = new ArrayDeque<>();
        Q.add(new Num(1, 0, 0));
        boolean[][] visited = new boolean[1001][2001];
        visited[0][1] = true;

        while (!Q.isEmpty()) {
            Num cur = Q.poll();
            int n = cur.n;
            int cnt = cur.cnt;
            int copy = cur.copy;
            if (n == N) {
                System.out.println(cnt);
                break;
            }

            if (n != copy&&n<=1000 && !visited[n][n]) {
                visited[n][n] = true;
                Q.add(new Num(n, cnt + 1, n));
            }

            if (n <= 1000 && !visited[copy][n + copy]) {
                visited[copy][n + copy] = true;
                Q.add(new Num(n + copy, cnt + 1, copy));
            }
            if (n > 0 && !visited[copy][n - 1]) {
                visited[copy][n - 1] = true;
                Q.add(new Num(n - 1, cnt + 1, copy));
            }

        }

    }
}
