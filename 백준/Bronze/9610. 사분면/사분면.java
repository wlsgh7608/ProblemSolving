import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cnt = new int[5];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (x == 0 || y == 0) {
                cnt[0]++;
            } else if (x > 0 && y > 0) {
                cnt[1]++;
            } else if (x < 0 && y > 0) {
                cnt[2]++;
            } else if (x < 0 && y < 0) {
                cnt[3]++;
            } else {
                cnt[4]++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 5; i++) {
            sb.append("Q").append(i).append(": ").append(cnt[i]).append("\n");
        }
        sb.append("AXIS: ").append(cnt[0]);
        System.out.println(sb);


    }
}
