import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static boolean isDuplicate(int N) {
        String strN = "" + N;
        int square = N * N;
        int MOD = (int) Math.pow(10, strN.length());
        if (N == square % MOD) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            boolean result = isDuplicate(N);
            if (result) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }

        System.out.println(sb);
    }
}
