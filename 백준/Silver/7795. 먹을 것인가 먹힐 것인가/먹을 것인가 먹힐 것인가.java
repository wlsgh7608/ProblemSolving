import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int getCount(int target, int[] arr) {
        // a의 원소보다 작은 개수 count
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi) {
            int m = (lo + hi) / 2;
            if (arr[m] < target) {
                lo = m + 1;
            } else {
                hi = m - 1;
            }
        }
        return lo;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int[] arrA = new int[A];
            int[] arrB = new int[B];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < A; i++) {
                arrA[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < B; i++) {
                arrB[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arrB);
            int tot = 0;
            for(int n: arrA){
                tot += getCount(n, arrB);
            }
            sb.append(tot).append("\n");
        }
        System.out.println(sb);

    }
}
