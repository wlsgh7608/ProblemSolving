import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] G = new int[N][M];

        int[] sum = new int[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                G[i][j] = Integer.parseInt(st.nextToken());
                sum[j] += G[i][j];
            }
        }
        int colN = Integer.parseInt(br.readLine());

        int maxScore = 0;
        int score = 0;

        for (int j = 0; j < colN; j++) {
            score += sum[j];
        }
        maxScore = score;

        for(int j = colN; j<M;j++){
            score+= sum[j];
            score -= sum[j - colN];
            maxScore = Math.max(maxScore, score);
        }
        System.out.println(maxScore);



    }
}
