import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int max = 0;
        int cnt = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (arr[i] > max) {
                max = arr[i];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
