import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] G = new int[N][M];
        int tot = 0 ;
        for(int i= 0 ; i <N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j<M;j++){
                G[i][j] = Integer.parseInt(st.nextToken());
                tot+=G[i][j];
            }
        }
        tot+=B;
        int maxHeight = tot / (N * M);
        if(maxHeight>256){
            maxHeight = 256;
        }

        int minTime = Integer.MAX_VALUE;
        int resultHeight = 0;

        for(int k = 0 ;k<=maxHeight;k++){
            int totTime = 0;
            for(int i = 0 ; i <N;i++){
                for(int j =0 ; j<M;j++){
                    if(G[i][j]>k){
                        totTime += (G[i][j] - k) * 2;
                    }else{
                        totTime += k - G[i][j];
                    }
                }
            }

            if(minTime>=totTime){
                minTime = totTime;
                resultHeight = k;
            }
        }

        System.out.println(minTime+" "+resultHeight);
    }
}
