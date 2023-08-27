import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[20];
            for (int i = 0; i < 20; i++) {
                int h = Integer.parseInt(st.nextToken());
                arr[i] = h;
            }
            int cnt = 0;

            for (int i = 1; i < 20; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    if (arr[j] > arr[i]) {
                        cnt++;
                    }
                }
            }
            sb.append(n + " " + cnt).append("\n");
        }// end while
        System.out.println(sb);
    }
}
