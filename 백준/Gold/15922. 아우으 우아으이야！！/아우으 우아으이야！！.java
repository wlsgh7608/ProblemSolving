import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int s = -1_000_000_001;
        int e = -1_000_000_001;
        int ans = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (e < x) {
                s = x;
                e = y;
                ans += (y - x);
            }
            if (s <= e && e < y) {
                ans += y - e;
                e = y;
            }
        }
        System.out.println(ans);
    }
}
