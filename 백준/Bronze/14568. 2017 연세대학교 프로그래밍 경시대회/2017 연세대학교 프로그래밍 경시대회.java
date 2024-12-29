import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; i + j <= N; j++) {
                for (int k = 1; i + j + k <= N; k++) {
                    if (i  >= j+2 && k % 2 == 0 && i + j + k == N) {
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);


    }
}
