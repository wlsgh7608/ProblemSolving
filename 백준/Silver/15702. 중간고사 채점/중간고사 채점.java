import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] score = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i =0 ; i<M;i++){
            score[i] = Integer.parseInt(st.nextToken());
        }


        int maxScore = 0;
        int maxIdx  = 100_000;

        for(int i = 0 ;i <N;i++){
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int scoreSum = 0;
            for(int j =0  ; j<M;j++){
                boolean solved = st.nextToken().equals("O");
                if (solved) {
                    scoreSum += score[j];
                }
            }
            if(scoreSum>maxScore){
                maxScore = scoreSum;
                maxIdx = idx;
            }else if(scoreSum==maxScore){
                maxIdx = Math.min(maxIdx,idx);
            }
        }
        System.out.println(maxIdx + " " + maxScore);
    }
}
