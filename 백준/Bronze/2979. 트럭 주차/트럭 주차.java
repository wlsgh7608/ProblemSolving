import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] cost = new int[4];
        int[] arr = new int[101];
        for (int i = 1; i <= 3; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            for (int j = start; j < end; j++) {
                arr[j]++;
            }
        }

        int ans = 0;

        for (int i = 1; i <= 100; i++) {
            ans += arr[i] * cost[arr[i]];
        }
        System.out.println(ans);

    }
}
