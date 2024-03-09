import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int answer;

    static void dfs(int cur, int[] arr, int N) {
        if (cur > N) {
            return;
        }
        answer = Math.max(answer, cur);

        for (int num : arr) {
            dfs(cur * 10 + num, arr, N);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String str = st.nextToken();
        int N = Integer.parseInt(str);
        int K = Integer.parseInt(st.nextToken());


        answer = 0;
        int[] arr = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, arr, N);
        System.out.println(answer);
    }
}
