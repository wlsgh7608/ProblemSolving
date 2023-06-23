import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    static int[] remains = {5, 5, 5, 5, 5};
    static final int CANT = 100;

    static boolean isSizeOk(int x, int y, int size) {
        //범위 벗어남
        if (x + size >= 10 || y + size >= 10) {
            return false;
        }

        // size 내 0 존재
        for (int i = 0; i <= size; i++) {
            for (int j = 0; j <= size; j++) {
                if (G[x + i][y + j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    static void change(int x, int y, int size, int d) {
        for (int i = 0; i <= size; i++) {
            for (int j = 0; j <= size; j++) {
                G[x + i][y + j] = d;
            }
        }
    }


    static void dfs(int x, int y, int cnt) {
        if (x == 10 && y == 0) {
            ans = Math.min(ans, cnt);
            return;
        }

        if (cnt >= ans) {
            return;
        }
        if (y == 10) {
            dfs(x + 1, 0, cnt);
            return;
        }

        int cur = G[x][y];
        if (cur == 1) {
            for (int i = 4; i >= 0; i--) {
                if (remains[i] > 0) {
                    if (isSizeOk(x, y, i)) {
                        remains[i] -= 1;
                        change(x, y, i, 0);
                        dfs(x, y + 1, cnt + 1);
                        remains[i] += 1;
                        change(x, y, i, 1);
                    }

                }
            } // end for
        } else {
            dfs(x, y + 1, cnt);
        }

    }

    static int[][] G;
    static int ans = CANT;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        G = new int[10][10];


        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                G[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // input
        dfs(0, 0, 0);
        if (ans == CANT) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }
}
