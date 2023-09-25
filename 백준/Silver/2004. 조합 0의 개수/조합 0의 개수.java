import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int getCount(int n, int v) {
        int cnt = 0;
        while (n >= v) {
            cnt += n / v;
            n /= v;
        }
        return cnt;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        long cnt5 = getCount(N, 5) - getCount(N - K, 5) - getCount(K, 5);
        long cnt2 = getCount(N, 2) - getCount(N - K, 2) - getCount(K, 2);

        long result = Math.min(cnt5, cnt2);
        System.out.println(result);


    }


}
