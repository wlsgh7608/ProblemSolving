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

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int p = 0;
        int q = N - 1;
        int cnt = 0;
        while (p < q) {
            int left = arr[p];
            int right = arr[q];

            if (left + right > K) {
                q--;
            } else {
                p++;
                q--;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
