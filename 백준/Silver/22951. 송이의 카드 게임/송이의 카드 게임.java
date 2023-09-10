import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] cards = new int[N + 1][K];
        boolean[][] isUse = new boolean[N + 1][K];

        for(int i = 1 ; i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j<K;j++){
                cards[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;

        int p = 1;
        int q = 0;
        int n = cards[1][0];
        isUse[1][0] = true;


        while(++cnt<N*K){
            int i = p;
            int j = q;
            n = cards[i][j];

            while(n>0){
                if(++j == K){
                    j = 0;
                    i++;
                    if(i==N+1){
                        i = 1;
                    }
                }

                if(!isUse[i][j]){
                    n--;
                }
            }
            isUse[i][j]= true;
            p = i;
            q = j;
            n = cards[i][j];

        }
        System.out.println(p+" "+n);
    }

}
