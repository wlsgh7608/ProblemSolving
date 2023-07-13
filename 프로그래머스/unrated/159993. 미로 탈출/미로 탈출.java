import java.util.*;

class Solution {

    static char[][] G;
    static boolean[][] visited;

    static class Node {
        int x;
        int y;
        int t;

        public Node(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static Node bfs(Node start, char target) {
        Queue<Node> Q = new ArrayDeque<>();
        visited = new boolean[R][C];
        visited[start.x][start.y] = true;
        Q.add(start);

        while (!Q.isEmpty()) {
            Node cur = Q.poll();
            int x = cur.x;
            int y = cur.y;
            int t = cur.t;
            if (G[x][y] == target) {
                return cur;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= R || ny >= C ||
                    visited[nx][ny] || G[nx][ny] == 'X') {
                    continue;
                }

                visited[nx][ny] = true;
                Q.add(new Node(nx, ny, t + 1));

            }
        }
        return null;

    }

    static int R, C;


    public int solution(String[] maps) {
        R = maps.length;
        C = maps[0].length();
        G = new char[R][C];
        visited = new boolean[R][C];
        Node start = null;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                G[i][j] = maps[i].charAt(j);
                if (G[i][j] == 'S') {
                    start = new Node(i, j, 0);
                }
            }
        }


        visited[start.x][start.y] = true;
        Node level = bfs(start, 'L');
        if (level == null) {
            return -1;
        }
        Node end = bfs(level, 'E');
        if (end == null) {
            return -1;
        }
        return end.t;

    }
}