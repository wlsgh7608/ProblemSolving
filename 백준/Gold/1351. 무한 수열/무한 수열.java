import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static long P;
    static long Q;
    static HashMap<Long, Long> hm;

    static long dfs(long n) {
        if (hm.containsKey(n)){
            return hm.get(n);
        }

        long result = 0L;
        long case1 = n / P;
        long case2 = n / Q;

        result+=dfs(case1) +dfs(case2);
        hm.put(n,result);
        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());

        hm = new HashMap<>();
        hm.put(0L, 1L);
        long result = dfs(N);
        System.out.println(result);

    }
}
