import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Candidate implements Comparable<Candidate> {


        int n;
        int sum;

        int[] scores = new int[4];

        @Override
        public int compareTo(Candidate o) {
            if (this.sum == o.sum) {
                if (this.scores[3] == o.scores[3]) {
                    return o.scores[2] - this.scores[2];
                }
                return o.scores[3] - this.scores[3];
            }
            return o.sum - this.sum;
        }


        public void addScore(int score) {
            this.scores[score]++;
            this.sum += score;
        }

        public boolean isSame(Candidate o) {
            if (this.sum == o.sum && this.scores[3] == o.scores[3] && this.scores[2] == o.scores[2]) {
                return true;
            }
            return false;
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Candidate[] candidates = new Candidate[3];

        for (int i = 0; i < 3; i++) {
            candidates[i] = new Candidate();
            candidates[i].n = i + 1;
        }


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                int score = Integer.parseInt(st.nextToken());
                candidates[j].addScore(score);

            }

        }
        Arrays.sort(candidates);

        StringBuilder sb = new StringBuilder();
        if (candidates[0].isSame(candidates[1])) {
            sb.append(0).append(" ").append(candidates[0].sum);
        } else {
            sb.append(candidates[0].n).append(" ").append(candidates[0].sum);
        }
        System.out.println(sb);
    }
}
