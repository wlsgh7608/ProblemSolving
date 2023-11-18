import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        long[] judges = new long[(int) N];
        for (int i = 0; i < N; i++) {
            judges[i] = Long.parseLong(br.readLine());
        }

        long max = 0;
        for (long n : judges) {
            max = Math.max(max, n);
        }

        long lo = 0;
        long hi = max * 1_000_000_000L;

        while (lo <= hi) {
            long m = (lo + hi) / 2;

            long canJudge = 0;
            for (long n : judges) {
                canJudge += m / n;
                if (canJudge >= M) {
                    hi = m - 1;
                    break;
                }
            }
            if (canJudge >= M) {
                hi = m - 1;
            } else {
                lo = m + 1;
            }

        }
        System.out.println(lo);

    }
}
