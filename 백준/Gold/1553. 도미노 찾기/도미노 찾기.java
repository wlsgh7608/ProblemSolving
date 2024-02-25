import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;


public class Main {
    static int N;
    static int M;
    static int[][] G;

    static boolean[][] visited;
    static HashSet<Domino> hs = new HashSet<>();
    static int answer = 0;


    static class Domino {
        int n1;
        int n2;

        public Domino(int n1, int n2) {
            this.n1 = n1;
            this.n2 = n2;
        }

        @Override
        public boolean equals(Object o) {

            Domino domino = (Domino) o;
            return n1 == domino.n1 && n2 == domino.n2;
        }

        @Override
        public int hashCode() {
            return 10 * n1 + n2;
        }

        @Override
        public String toString() {
            return "Domino{" +
                    "n1=" + n1 +
                    ", n2=" + n2 +
                    '}';
        }
    }


    static void dfs(int depth) {
        if (depth == 28) {
            answer++;

            return;
        }
        int x = -1;
        int y = -1;
        breakLoop:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    x = i;
                    y = j;
                    break breakLoop;
                }
            }
        }


        if (y + 1 < M) {
            int[] row = new int[]{G[x][y], G[x][y + 1]};
            Arrays.sort(row);
            if (!visited[x][y] && !visited[x][y + 1] && !hs.contains(new Domino(row[0], row[1]))) {
                hs.add(new Domino(row[0], row[1]));
                visited[x][y] = true;
                visited[x][y + 1] = true;
                dfs(depth + 1);
                visited[x][y] = false;
                visited[x][y + 1] = false;
                hs.remove(new Domino(row[0], row[1]));
            }
        }
        if (x + 1 < N) {
            int[] col = new int[]{G[x][y], G[x + 1][y]};
            Arrays.sort(col);
            if (!visited[x][y] && !visited[x + 1][y] && !hs.contains(new Domino(col[0], col[1]))) {
                hs.add(new Domino(col[0], col[1]));
                visited[x][y] = true;
                visited[x + 1][y] = true;
                dfs(depth + 1);
                visited[x][y] = false;
                visited[x + 1][y] = false;
                hs.remove(new Domino(col[0], col[1]));
            }
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = 8;
        M = 7;
        G = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                G[i][j] = str.charAt(j) - '0';
            }
        }
        dfs(0);
        System.out.println(answer);


    }
}
