import java.io.*;
import java.util.*;

public class Main {


    static int[] G;
    static boolean[] visited;
    static int cnt;

    public static void dfs(int s, List<Integer> current) {
        int next = G[s];
        if (current.contains(next)) {
            cnt++;
            return;
        } else {
            visited[next] = true;
            current.add(next);
            dfs(next, current);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            cnt = 0;
            int n = Integer.parseInt(br.readLine());
            G = new int[n];
            visited = new boolean[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                G[i] = Integer.parseInt(st.nextToken()) - 1;
            }

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    List<Integer> current = new ArrayList<>();
                    current.add(i);
                    dfs(i, current);
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}



