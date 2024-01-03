import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] G = new int[N][N];

        int[] dx = {-1, -1, -1, 1, 1, 1, 0, 0};
        int[] dy = {-1, 1, 0, -1, 1, 0, -1, 1};


        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                char c = str.charAt(j);
                if ('0' <= c && c <= '9') {
                    G[i][j] = -100_000;

                    for (int k = 0; k < 8; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                            continue;
                        }
                        G[nx][ny] += c - '0';
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (G[i][j] < 0) {
                    sb.append('*');
                } else {
                    if (G[i][j] >= 10) {
                        sb.append("M");
                    } else {
                        sb.append(G[i][j]);

                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);


    }
}
