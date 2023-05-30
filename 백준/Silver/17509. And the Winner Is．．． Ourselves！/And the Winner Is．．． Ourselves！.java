import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Score implements Comparable<Score>{
        int t;
        int wrong;

        public Score(int t, int wrong) {
            this.t = t;
            this.wrong = wrong;
        }

        @Override
        public int compareTo(Score o){
            return (this.t) - (o.t);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Score[] scores = new Score[11];
        for (int i = 0; i < 11; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            scores[i] = new Score(t, w);
        }
        Arrays.sort(scores);

        int ans = 0;
        int curT = 0;
        for(int i = 0 ; i<11;i++){
            curT += scores[i].t;
            ans += curT + scores[i].wrong * 20;
        }
        System.out.println(ans);

    }
}
