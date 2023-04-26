import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        if (N >=4) {
            ans = N * (N - 1) * (N - 2) * (N - 3) / 24;
        }
        System.out.println(ans);
    }
}
