import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[][] arr = new int[100][100];
        int cnt = 0;
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int i = x; i < x + 10; i++) {
                for (int j = y; j < y + 10; j++) {
                    if (i < 100 && j < 100) {
                        arr[i][j] = 1;
                    }
                }
            }
        }
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};


        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (arr[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx == -1 || ny == -1 || nx == 100 || ny == 100) {
                            cnt++;
                        }
                        if (nx < 0 || ny < 0 || nx >= 100 || ny >= 100) {
                            continue;
                        }
                        if (arr[nx][ny] == 0) {
                            cnt++;
                        }
                    }
                }
            }

        } // end cnt
        System.out.println(cnt);

    }
}
