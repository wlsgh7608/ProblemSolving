import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] arr = {300, 60, 10};

        StringBuilder sb = new StringBuilder();

        if (T % 10 == 0) {
            for (int i = 0; i < 3; i++) {
                int cnt = T / arr[i];
                T = T % arr[i];
                sb.append(cnt + " ");
            }
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }
    }
}
