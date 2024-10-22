import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[][] G = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                G[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int T = Integer.parseInt(br.readLine());
        int cnt = 0;


        for (int i = 0; i < R - 2; i++) {
            for (int j = 0; j < C - 2; j++) {
                int[] arr = new int[9];
                for (int p = 0; p < 3; p++) {
                    for (int q = 0; q < 3; q++) {
                        arr[p * 3 + q] = G[i + p][j + q];
                    }
                }
                Arrays.sort(arr);
                if (arr[4] >= T) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);


    }
}
