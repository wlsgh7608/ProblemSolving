import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[] arr;
    static int[] cur;
    static StringBuilder ans = new StringBuilder();
    static HashSet<String> hs = new HashSet<>();


    static void dfs(int depth) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(cur[i] + " ");
            }
            if (!hs.contains(sb.toString())) {
                hs.add(sb.toString());
                ans.append(sb.toString()).append("\n");
            }
            return;
        }
        for (int i = 0; i < N; i++) {
            cur[depth] = arr[i];
            dfs(depth + 1);
        }
    }


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
        dfs(0);
        System.out.println(ans);
    }
}
