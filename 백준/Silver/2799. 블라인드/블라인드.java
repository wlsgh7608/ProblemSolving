import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int getCategory(int x,int y,char[][] G){
        int category = 0;
        for(int i = 0 ;i <4;i++){
            if(G[x+i][y]=='*'){
                category =i+1;
            }
        }
        return category;
    }

    static int[] getCnt(int N, int M, char[][] G) {
        int[] cnt = new int[5];
        for (int i = 0; i <N;i++){
            for(int j = 0 ; j<M;j++){
                int idx = getCategory(i * 5 + 1, j * 5 + 1, G);
                cnt[idx]++;
            }
        }
        return cnt;
    }



    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] G = new char[5 * N + 1][5 * M + 1];

        for(int i = 0; i<=5*N;i++){
            String str = br.readLine();
            for(int j =0 ; j <=5*M;j++){
                G[i][j] = str.charAt(j);
            }
        }
        int[] cnt = getCnt(N, M, G);

        System.out.println(cnt[0] + " " + cnt[1] + " " + cnt[2] + " " + cnt[3] + " " + cnt[4]);

    }
}
