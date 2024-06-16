import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int cnt = 0;

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                cnt += Integer.parseInt(st.nextToken()) / K;
            }

            sb.append(cnt).append("\n");
        }
        System.out.println(sb);

    }
}
