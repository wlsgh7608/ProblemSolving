import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        char[][] arr = new char[H][W * N];

        for (int i = 0; i < H; i++) {
            String str = br.readLine();
            for (int j = 0; j < W * N; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int n = 0; n < N; n++) {
            char c = '?';

            end:
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (arr[i][n * W + j] != '?') {
                        c = arr[i][n * W + j];
                        break end;
                    }
                }

            }
            sb.append(c);
        }
        System.out.println(sb);


    }
}
