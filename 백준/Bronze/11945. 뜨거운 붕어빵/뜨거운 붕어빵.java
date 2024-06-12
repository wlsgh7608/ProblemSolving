import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static void reverse(char[][] map) {
        for (char[] row : map) {
            int lo = 0;
            int hi = row.length - 1;

            while (lo < hi) {
                char temp = row[lo];
                row[lo] = row[hi];
                row[hi] = temp;
                lo++;
                hi--;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        StringBuilder sb = new StringBuilder();

        reverse(map);
        for (char[] row : map) {
            for (char c : row) {
                sb.append(c);
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}
