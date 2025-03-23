import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {




    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] S = new int[N + 1];
        int[] D = new int[N + 1];


        // 셔플 후 봅을 때
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        // 원래
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            D[i] = Integer.parseInt(st.nextToken());
        }


        while(K-->0){

            int[] prev = new int[N + 1];
            for(int i =1; i<=N;i++){
                prev[D[i]] = S[i];
            }
            S = prev;
        }
        StringBuilder sb = new StringBuilder();
        for(int i= 1 ;i<=N;i++){
            sb.append(S[i] + " ");
        }
        System.out.println(sb);
    }

}
