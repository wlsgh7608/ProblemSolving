import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int minValue = Integer.MAX_VALUE;
    static int N;
    static int[][] arr;

    static void dfs(int start, int depth, boolean[] visited) {

        if (depth == N / 2 || start == N) {
            int diff = calculate(visited);
            minValue = Math.min(minValue, diff);
            return;
        }

        visited[start] = true;
        dfs(start + 1, depth + 1, visited);
        visited[start] = false;
        dfs(start + 1, depth, visited);
    }


    static int calculate(boolean[] visited) {
        int startTeam = 0;
        int linkTeam = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i] && visited[j]) {
                    startTeam += arr[i][j];
                }

                if (!visited[i] && !visited[j]) {
                    linkTeam += arr[i][j];
                }
            }
        }
        return Math.abs(startTeam - linkTeam);
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean[] visited = new boolean[N];
        dfs(0, 0, visited);
        System.out.println(minValue);
    }

}
