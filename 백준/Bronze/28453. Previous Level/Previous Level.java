import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] level = new int[]{301, 300, 275, 250, 0};

        StringBuilder sb = new StringBuilder();
        for (int n : arr) {
            for (int j = 1; j <= 4; j++) {
                if (level[j - 1] > n && n >= level[j]) {
                    sb.append(j).append(" ");
                }
            }
        }
        System.out.println(sb);


    }
}
