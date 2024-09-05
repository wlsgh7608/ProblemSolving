import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] arr = new long[1000001];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            arr[x]+=g;
        }

        long sum = 0;
        long max = 0;
        for (int i = 0; i < 1000001; i++) {
            sum += arr[i];
            max = Math.max(max, sum);
            if (i >= 2 * K) {
                sum -= arr[i - 2 * K];
            }
        }
        System.out.println(max);

    }
}
