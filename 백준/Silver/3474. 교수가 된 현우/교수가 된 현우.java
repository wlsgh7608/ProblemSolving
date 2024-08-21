import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            long cnt2 = 0;
            long cnt5 = 0;
            for (int i = 2; i <= N; i *= 2) {
                cnt2 += N / i;
            }
            for (int i = 5; i <= N; i *= 5) {
                cnt5 += N / i;
            }
            sb.append(Math.min(cnt2, cnt5)).append("\n");
        }
        System.out.println(sb);

    }
}
