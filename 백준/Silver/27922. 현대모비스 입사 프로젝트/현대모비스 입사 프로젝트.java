import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static int getScore(int[][] arr, int K, int subject1, int subject2) {

        Comparator<int[]> myCompartor = (o1, o2) ->
                o2[subject1] + o2[subject2] - o1[subject1] - o1[subject2];
        Arrays.sort(arr, myCompartor);
        int sum = 0;
        for (int i = 0; i < K; i++) {
            sum += arr[i][subject1] + arr[i][subject2];
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }


        int maxScore = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                int score = getScore(arr, K, i, j);
                maxScore = Math.max(maxScore, score);
            }
        }
        System.out.println(maxScore);


    }
}
