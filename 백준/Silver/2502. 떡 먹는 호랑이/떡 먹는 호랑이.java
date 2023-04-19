import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int ansA = 0;
        int ansB = 0;
        int[] A = new int[D + 1];
        int[] B = new int[D + 1];
        A[1] = 1;
        B[2] = 1;

        for (int i = 3; i <= D; i++) {
            A[i] = A[i - 1] + A[i - 2];
            B[i] = B[i - 1] + B[i - 2];
        }

        for (int i = 1; i <= 100000; i++) {
            int remain = K - A[D] * i;
            if (remain % B[D] == 0) {
                int b = remain / B[D];
                if (b < i) {
                    continue;
                }
                ansA = i;
                ansB = b;
                break;

            }
        }
        System.out.println(ansA);
        System.out.println(ansB);
    }
}
