import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static void binaryCnt(int digit,int n,long cnt){
        if(n==0){
            return;
        }

        long startSeq= sum[n-1]+1;
        if(startSeq<=cnt){
            answer[digit]='1';
            binaryCnt(digit + 1, n - 1, cnt - startSeq);
        }else{
            answer[digit] = '0';
            binaryCnt(digit + 1, n - 1, cnt );
        }
    }
    static long[][] dp;
    static long[] sum;
    static char[] answer;



    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long  K = Long.parseLong(br.readLine());
        dp = new long[100 + 1][2];
        dp[1][1]= 1;
        dp[1][0]= 1;
        for(int i = 2; i<=100;i++){
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
            dp[i][1] = dp[i - 1][0];
        }
        // 이친수 : 1으로 시작, 11 연속 X
        // 자리수 찾기

       sum = new long[101];
        sum[1] = 1;
        for(int i = 2; i<=100;i++){
            sum[i] = sum[i - 1] + dp[i][1];
        }

        int N = -1;
        for(int i =1; i<=100;i++){
            if(sum[i]>=K){
                N = i;
                break;
            }
        }
        answer = new char[N];
        binaryCnt(0, N, K);
        StringBuilder sb = new StringBuilder();
        for(char c: answer){
            sb.append(c);
        }
        System.out.println(sb);

    }
}
