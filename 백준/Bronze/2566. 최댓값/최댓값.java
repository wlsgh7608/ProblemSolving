import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = 9;

        int maxN = 0;
        int maxI = 1;
        int maxJ = 1;
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                int n = Integer.parseInt(st.nextToken());
                if (n > maxN) {
                    maxN = n;
                    maxI = i;
                    maxJ = j;

                }
            }
        }
        System.out.println(maxN);
        System.out.println(maxI + " " + maxJ);
    }
}
