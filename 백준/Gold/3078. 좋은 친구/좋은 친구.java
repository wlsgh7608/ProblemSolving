import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }
        int[] cnt = new int[21];
        long ans = 0;
        for (int i = 0; i <= K; i++) {
            if (i == N) {
                break;
            }
            String cur = arr[i];
            int len = cur.length();
            if (cnt[len] > 0) {
                ans += cnt[len];
            }
            cnt[len]++;
        }

        for (int i = K + 1; i < N; i++) {
            String prev = arr[i - K - 1];
            cnt[prev.length()]--;
            String cur = arr[i];
            int len = cur.length();

            if (cnt[len] > 0) {
                ans += cnt[len];
            }
            cnt[len]++;
        }
        System.out.println(ans);

    }
}
