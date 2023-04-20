import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    static void perm(int depth, int flag) {
        if (depth == N - 2) {
            int ans = 0;
            boolean[] isSelected = new boolean[N];

            for (int idx : selected) {
                isSelected[idx] = true;
                int left = idx - 1;
                int right = idx + 1;

                for (int i = left; i >= 0; i--) {
                    if (!isSelected[i]) {
                        left = i;
                        break;
                    }
                }
                for (int i = right; i < N; i++) {
                    if (!isSelected[i]) {
                        right = i;
                        break;
                    }
                }
                ans += arr[left] * arr[right];
            }
            maxResult = Math.max(maxResult, ans);

        }

        for (int i = 1; i < N - 1; i++) {
            if ((flag & 1 << i) == 0) {
                selected[depth] = i;
                perm(depth + 1, flag | 1 << i);
            }
        }


    }


    static int N;
    static int[] selected;
    static int[] arr;
    static int maxResult = 0;


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        selected = new int[N - 2];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        perm(0, 0);
        System.out.println(maxResult);


    }
}
