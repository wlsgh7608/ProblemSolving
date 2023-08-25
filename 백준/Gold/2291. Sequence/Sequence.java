import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int solve(int startIdx, int sum, int prev) {
        if(startIdx==N && sum==M){ // 끝 도달 sum 맞은 경우
            return 1;
        }
        if(startIdx==N || sum>=M){ // 끝에 도달하거나, sum이 넘어버린 경우
            return 0;
        }
        if (dp[startIdx][sum][prev] != -1) { // 이미 답을 찾은 경우
            return dp[startIdx][sum][prev];
        }
        dp[startIdx][sum][prev] = 0;
        for (int i = prev; sum + i <= M; i++) {
            dp[startIdx][sum][prev] += solve(startIdx + 1, sum + i, i);
        }
        return dp[startIdx][sum][prev];
    }

    static void trace(int idx,int sum,int n,int cnt) {
        if(idx==N){
            return;
        }
        if(sum+n>M){
            return;
        }

        int pivot = solve(idx+1, sum+n, n);
        if(pivot<cnt){
            trace(idx, sum , n+1,cnt-pivot);
        }else{
            // pivot이 더 큰 경우 다음으로 진행
            answer[idx] = n;
            trace(idx+1, sum+n, n,cnt );
        }
    }

    static int N, M, K;
    static int[][][] dp; // len, sum, min
    static int[] answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        answer = new int[N];
        dp = new int[11][221][221];
        for(int[][] G : dp){
            for(int[] row: G){
                Arrays.fill(row, -1);
            }
        }

        solve(0, 0, 1);
        trace(0, 0, 1,K);

        StringBuilder sb = new StringBuilder();
        for(int n : answer){
            sb.append(n+" ");
        }
        System.out.println(sb);
    }
}
