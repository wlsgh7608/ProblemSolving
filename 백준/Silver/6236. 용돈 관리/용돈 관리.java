import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean isValid(long v) {
        int cnt = 0;
        long curMoney = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] > v) {
                return false;
            }
            if (arr[i] > curMoney) {
                curMoney = v;
                cnt++;
            }
            curMoney -= arr[i];
        }
        if (cnt <= M) {
            return true;
        }
        return false;
    }

    static int[] arr;
    static int N;
    static int M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        long lo = 1;
        long hi = N * 10000;

        while (lo <= hi) {
            long m = (lo + hi) / 2;
            if (isValid(m)) {
                hi = m - 1;
            } else {
                lo = m + 1;
            }
        }
        System.out.println(lo);


    }
}
