import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static void dfs(int depth, int idx) {
        if (depth == M) {
            for (int n : cur) {
                sb.append(n + " ");
            }
            sb.append("\n");
            return;
        }

        int prev = -1;
        for (int i = idx; i < N; i++) {
            if (prev == arr[i]) {
                continue;
            }

            prev = arr[i];
            cur[depth] = arr[i];
            dfs(depth + 1, i);
        }
    }


    static int N, M;
    static int[] arr;
    static int[] cur;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        cur = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0, 0);
        System.out.println(sb);
    }
}
