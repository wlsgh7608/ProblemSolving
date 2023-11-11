import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {


    static boolean isPallendrom(int N) {
        String s1 = "" + N;
        String s2 = new StringBuilder(s1).reverse().toString();
        if (s1.equals(s2)) {
            return true;
        }
        return false;

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int MAX_NUM = 1_003_001;

        int N = Integer.parseInt(br.readLine());
        boolean[] isPrime = new boolean[MAX_NUM + 1];
        Arrays.fill(isPrime, true);
        isPrime[1] = false;
        for (int i = 2; i <= MAX_NUM; i++) {
            for (int j = 2; i * j <= MAX_NUM; j++) {
                isPrime[i * j] = false;
            }
        }


        for (int i = N; i <= MAX_NUM; i++) {
            if (isPrime[i]) {
                if (isPallendrom(i)) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
