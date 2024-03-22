import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean[] visited;
    static int[] shuffle;
    static HashSet<Long> cycleHs = new HashSet<>();

    static void dfs(int cur, int cnt) {
        if (visited[cur]) {
            cycleHs.add((long)cnt);
            return;
        }
        visited[cur] = true;
        int next = shuffle[cur];
        dfs(next, cnt + 1);
    }


    static long getGCD(long  a, long b) {
        while (b != 0) {
            long tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        shuffle = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            shuffle[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i, 0);
            }
        }

        Queue<Long> Q = new ArrayDeque<>(cycleHs);

        while (Q.size() > 1) {
            long a = Q.poll();
            long b = Q.poll();
            // a,b의 최소공배수 = a*b/최대공약수
            Q.add(a * b / getGCD(a, b));
        }
        System.out.println(Q.peek());
    }
}
