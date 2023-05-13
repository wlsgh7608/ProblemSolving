import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static void comb(int idx, int sum, int min, int max) {
        if (sum > R) {
            return;
        }
        if (idx == N) {
            if (max - min >= X && sum >= L) {
                cnt++;
            }
            return;
        }

        int cur = arr[idx];
        comb(idx + 1, sum + cur, Math.min(min, cur), Math.max(max, cur));
        comb(idx + 1, sum, min, max);
    }

    static int N;
    static int L;
    static int R;
    static int X;
    static int[] arr;
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        comb(0, 0, 1_000_000, 0);
        System.out.println(cnt);


    }
}
