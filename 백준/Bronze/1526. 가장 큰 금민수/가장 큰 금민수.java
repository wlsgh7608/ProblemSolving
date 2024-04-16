import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int ans = 0;
    static int N;

    static void dfs(int cur) {
        if (cur > N) {
            return;
        }
        ans = Math.max(ans, cur);
        dfs(cur * 10 + 4);
        dfs(cur * 10 + 7);
    }


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dfs(0);
        System.out.println(ans);
    }
}
