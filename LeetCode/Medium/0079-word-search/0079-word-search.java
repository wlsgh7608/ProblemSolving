class Solution {
    static int R, C;
    static char[][] G;
    static String target;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[] route;
    static boolean[][] visited;

    static boolean dfs(int x, int y, int depth) {
        visited[x][y] = true;


        if (G[x][y] == target.charAt(depth)) {
            // 해당 단어를 찾았을 경우 depth = (단어 길이-1)
            if (depth == target.length() - 1) {
                return true;
            }


            // 사방 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C || visited[nx][ny]) {
                    continue;

                }
                if (dfs(nx, ny, depth + 1)) {
                    return true;
                }

            }

        }
        visited[x][y] = false;
        return false;
    }

    public static boolean exist(char[][] board, String word) {

        R = board.length;
        C = board[0].length;
        G = board;
        target = word;
        route = new char[word.length()];
        visited = new boolean[R][C];

        // 6X6 사이즈
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                // visited = new boolean[R][C];
                if (dfs(i, j, 0)) {
                    return true;
                }


            }
        }
        return false;

    }
}