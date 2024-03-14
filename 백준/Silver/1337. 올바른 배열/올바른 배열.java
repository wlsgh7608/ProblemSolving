import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int result = 5;

        for (int i = 0; i < N; i++) {
            int cnt = 0;
            int cur = arr[i];

            for (int j = 0; j < 5; j++) {
                if (i + j < N && arr[i + j] <= cur + 4) {
                    continue;
                }
                cnt++;
            }
            result = Math.min(result, cnt);
        }
        System.out.println(result);


    }
}
