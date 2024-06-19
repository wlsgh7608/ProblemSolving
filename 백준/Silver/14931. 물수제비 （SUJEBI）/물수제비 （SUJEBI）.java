import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        int[] arr = new int[L + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= L; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int maxD = 0;
        long maxScore = 0;
        for (int i = 1; i <= L; i++) {
            long score = 0;
            for (int j = i; j <= L; j += i) {
                score += arr[j];
            }
            if (score > maxScore) {
                maxD = i;
                maxScore = score;
            }
        }
        System.out.println(maxD + " " + maxScore);
    }
}
