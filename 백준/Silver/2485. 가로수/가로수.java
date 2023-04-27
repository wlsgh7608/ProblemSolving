import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int getGcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int gcd = arr[1] - arr[0];
        for (int i = 2; i < N; i++) {
            int diff = arr[i] - arr[i - 1];
            gcd = getGcd(gcd, diff);
        }
        int cnt = 0;
        for (int i = 1; i < N; i++) {
            int diff = arr[i] - arr[i - 1];
            cnt += diff / gcd - 1;
        }
        System.out.println(cnt);
    }
}
