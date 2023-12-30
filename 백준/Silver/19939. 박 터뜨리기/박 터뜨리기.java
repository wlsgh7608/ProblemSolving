import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int minV = K * (K + 1) / 2;


        if (N >= minV) {
            int remain = (N - minV) % K;
            if (remain > 0) {
                System.out.println(K);
            } else {
                System.out.println(K - 1);
            }
        } else {
            System.out.println(-1);
        }

    }
}
