import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] diff = new int[N];
        for(int i = 1; i<N;i++){
            diff[i] = Math.abs(arr[i] - arr[i - 1]);
        }
        int[] dp = new int[N];
        for(int i = 1; i<N;i++){
            dp[i] = dp[i - 1] + diff[i];
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <Q;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int ans = dp[b - 1] - dp[a - 1];
            sb.append(ans).append("\n");
        }
        System.out.println(sb);

    }
}
