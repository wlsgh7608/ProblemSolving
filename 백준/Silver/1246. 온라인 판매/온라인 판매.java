import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[M];
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int unitPrice = 0;
        int totalPrice = 0;
        for (int i = 0; i < M; i++) {
            int cnt = Math.min(M - i, N);
            int cur = arr[i];
            if (totalPrice < cur * cnt) {
                totalPrice = Math.max(totalPrice, cur * cnt);
                unitPrice = cur;
            }

        }
        System.out.println(unitPrice + " " + totalPrice);


    }
}
