import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int idx = 1;
        int maxSum = 0;
        int maxIdx = -1;
        while (idx <= 5) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sum = 0;
            for (int i = 0; i < 4; i++) {
                sum += Integer.parseInt(st.nextToken());
            }

            if (sum > maxSum) {
                maxSum = sum;
                maxIdx = idx;
            }

            idx++;
        }
        System.out.println(maxIdx + " " + maxSum);
    }
}
