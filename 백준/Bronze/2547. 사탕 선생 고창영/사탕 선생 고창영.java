import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            br.readLine();
            long N = Long.parseLong(br.readLine());
            long sum = 0;
            for (int i = 0; i < N; i++) {
                sum += Long.parseLong(br.readLine());
                sum %= N;
            }
            if (sum == 0) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);

    }
}
