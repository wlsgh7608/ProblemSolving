import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Coin {
        int v;
        int n;

        public Coin(int v, int n) {
            this.v = v;
            this.n = n;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        Coin[] coins = new Coin[k];
        int dp[] = new int[T + 1];
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            coins[i] = new Coin(p, n);
        }
        dp[0]=1;


        for (int i = 0; i < k; i++) {
            for (int j = T; j > 0; j--) {
                for (int l = 1; l <= coins[i].n; l++) {
                    if (j - l * coins[i].v >= 0) {
                        dp[j] += dp[j - l * coins[i].v];
                    }
                }
            }
        }
        System.out.println(dp[T]);


    }
}
