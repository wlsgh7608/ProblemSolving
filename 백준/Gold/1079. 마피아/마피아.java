import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    static void perm(int day, int flag, int n) {
        if (n == 1 || (flag & 1 << mafia) != 0) {
            ans = Math.max(ans, day);
            return;
        }
        //밤
        if (n % 2 == 0) {
            for (int i = 0; i < N; i++) {
                if (i != mafia && (flag & 1 << i) == 0) {
                    for (int j = 0; j < N; j++) {
                        score[j] += G[i][j];
                    }
                    perm(day + 1, flag | 1 << i, n - 1);
                    for (int j = 0; j < N; j++) {
                        score[j] -= G[i][j];
                    }
                }
            }
            //낮
        } else {
            int max = -100_000;
            int killIdx = -1;
            for (int i = 0; i < N; i++) {
                if ((flag & 1 << i) == 0) {
                    if (max < score[i]) {
                        killIdx = i;
                        max = score[i];
                    }
                }
            }
            perm(day, flag | 1 << killIdx, n - 1);
        }

    }

    static int N;
    static int mafia;
    static int ans = 0;
    static int[] score;
    static int[][] G;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        score = new int[N];
        G = new int[N][N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                G[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        mafia = Integer.parseInt(br.readLine());
        perm(0, 0, N);
        System.out.println(ans);


    }
}
