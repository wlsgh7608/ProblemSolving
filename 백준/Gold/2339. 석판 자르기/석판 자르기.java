import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {


    static int[][] G;
    static boolean isValid(int x1, int y1, int x2, int y2, Node node, boolean isX) {
        // 보석 0이어야 함
        int x = node.x;
        int y = node.y;
        if (isX) {
            for (int i = x1; i < x2; i++) {
                if (G[i][y] == 2) {
                    return false;
                }
            }
        } else {
            for (int i = y1; i < y2; i++) {
                if (G[x][i] == 2) {
                    return false;
                }
            }
        }

        return true;
    }

    static boolean isCorrect(int x1, int y1, int x2, int y2) {
        // 현재 석판에 보석, 불순물 체크
        int cnt = 0;
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                if (G[i][j] == 2) {
                    cnt++;
                } else if (G[i][j] == 1) {
                    return false;
                }
            }
        }
        if (cnt == 1) {
            return true;
        }
        return false;
    }

    static int dfs(int x1, int y1, int x2, int y2, boolean isX) {
        int result = 0;

        if (isCorrect(x1, y1, x2, y2)) {
            return 1;
        }

        for (Node bad : bads) {
            int x = bad.x;
            int y = bad.y;
            // 존재
            if (x1 <= x && x < x2 && y1 <= y && y < y2) {
                // 가로방향 싹둑
                if (!isX && isValid(x1, y1, x2, y2, bad, isX)) {
                    if (x1 < x && x < x2-1) { // 나눌 수 있는 경우
                        int seg1 = dfs(x1, y1, x, y2, true);
                        int seg2 = dfs(x + 1, y1, x2, y2, true);
                        result += seg1 * seg2;
                    }
                } else if (isX && isValid(x1, y1, x2, y2, bad, isX)) {
                    if (y1 < y && y < y2-1) { // 나눌 수 있는 경우
                        int seg1 = dfs(x1, y1, x2, y, false);
                        int seg2 = dfs(x1, y + 1, x2, y2, false);
                        result += seg1 * seg2;
                    }
                }
            }
        } // end for
        return result;
    }


    static List<Node> jewels = new ArrayList<>();
    static List<Node> bads = new ArrayList<>();

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        G = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                G[i][j] = Integer.parseInt(st.nextToken());
                if (G[i][j] == 2) {
                    jewels.add(new Node(i, j));
                } else if (G[i][j] == 1) {
                    bads.add(new Node(i, j));
                }
            }
        }

        int ans1 = dfs(0, 0, N, N, true);
        int ans2 = dfs(0, 0, N, N, false);
        int result = ans1 + ans2;
        if(result>0){
            System.out.println(result);
        }else{
            System.out.println(-1);
        }

    }
}
