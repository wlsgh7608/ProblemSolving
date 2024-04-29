import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());


        int[] maxPrime = new int[N + 1];
        for (int i = 2; i <= N; i++) {
            if (maxPrime[i] != 0) {
                continue;
            }
            for (int j = 1; i * j <= N; j++) {
                maxPrime[i * j] = i;
            }
        }
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (maxPrime[i] <= K) {
                cnt++;
            }
        }
        System.out.println(cnt);


    }
}
