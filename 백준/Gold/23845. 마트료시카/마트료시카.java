import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        int[] cnt = new int[100_001];
        HashSet<Integer> hs = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());

            cnt[n]++;
            hs.add(n);
            arr[i] = n;
        }

        Arrays.sort(arr);

        Stack<Integer> S = new Stack<>();

        long result = 0;

        for (int i = 100_000; i >= 0; i--) {
            int n = i;
            int prev = n + 1;
            int nCnt = cnt[i];


            if (nCnt >= S.size()) {
                int diff = nCnt - S.size();
                while (diff-- > 0) {
                    S.add(n);
                }
            } else {
                int diff = S.size() - nCnt;
                while (diff-- > 0) {
                    int cur = S.pop();
                    result += (long) (cur - prev + 1) * cur;
                }
            }
        }
        System.out.println(result);


    }
}
