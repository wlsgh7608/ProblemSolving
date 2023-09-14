import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]dp = new int[101];

        int[] lose = new int[N+1];
        int[] joy = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i= 1 ; i <=N;i++){
            lose[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <=N;i++){
            joy[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1 ;i <=N;i++){
            for(int j = 100;j>lose[i];j--){
                dp[j] = Math.max(dp[j], dp[j - lose[i]]+joy[i]);
            }
        }
        System.out.println(dp[100]);

    }
}
