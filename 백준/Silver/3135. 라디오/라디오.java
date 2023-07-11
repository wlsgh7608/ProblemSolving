import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());

        int minCnt = Math.abs(A - B);
        for (int i = 0; i < N; i++) {
            int b = Integer.parseInt(br.readLine());
            minCnt = Math.min(minCnt, Math.abs(B - b) + 1);
        }
        System.out.println(minCnt);

    }
}
