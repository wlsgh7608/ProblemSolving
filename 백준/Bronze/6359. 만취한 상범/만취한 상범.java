import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            boolean[] room = new boolean[N + 1]; //처음에 모두 false
            for (int i = 1; i <= N; i++) {
                for (int j = 1; i * j <= N; j++) {
                    room[i * j] = !room[i * j];
                }
            }
            int cnt = 0;
            for (int i = 1; i <= N; i++) {
                if (room[i]) {
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);

    }
}
