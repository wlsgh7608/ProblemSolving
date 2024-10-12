import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }


    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    private static void setObstacle(char[][] G, int x, int y) {
        G[x][y] = 'O';
    }

    private static void removeObstacle(char[][] G, int x, int y) {
        G[x][y] = 'X';
    }

    private static void setObstacles(char[][] G, Node a, Node b, Node c) {
        setObstacle(G, a.x, a.y);
        setObstacle(G, b.x, b.y);
        setObstacle(G, c.x, c.y);
    }

    private static void removeObstacles(char[][] G, Node a, Node b, Node c) {
        removeObstacle(G, a.x, a.y);
        removeObstacle(G, b.x, b.y);
        removeObstacle(G, c.x, c.y);
    }

    static boolean isValid(char[][] G, int x, int y) {
        if (x < 0 || x >= G.length || y < 0 || y >= G[0].length) {
            return false;
        }
        if (G[x][y] == 'O') {
            return false;
        }
        return true;
    }


    private static boolean detect(char[][] G, Node teacher) {
        for (int d = 0; d < 4; d++) {
            int nx = teacher.x;
            int ny = teacher.y;

            while (isValid(G, nx, ny)) {
                if (G[nx][ny] == 'S') {
                    return true;
                }
                nx += dx[d];
                ny += dy[d];
            }
        }
        return false;
    }

    private static boolean detectStudents(char[][] G, List<Node> teachers) {
        for (Node teacher : teachers) {
            if (detect(G, teacher)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Node> teachers = new ArrayList<>();
        List<Node> empty = new ArrayList<>();
        // 36*35*34 = 42840
        int N = Integer.parseInt(br.readLine());
        char[][] G = new char[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                G[i][j] = st.nextToken().charAt(0);
                if (G[i][j] == 'T') {
                    teachers.add(new Node(i, j));
                } else if (G[i][j] == 'X') {
                    empty.add(new Node(i, j));
                }
            }
        }


        int emptySize = empty.size();

        boolean isSafe = false;

        for (int iter0 = 0; iter0 < emptySize; iter0++) {
            for (int iter1 = iter0 + 1; iter1 < emptySize; iter1++) {
                for (int iter2 = iter1 + 1; iter2 < emptySize; iter2++) {
                    Node a = empty.get(iter0);
                    Node b = empty.get(iter1);
                    Node c = empty.get(iter2);
                    setObstacles(G, a, b, c);


                    if (detectStudents(G, teachers)) {
                        isSafe = true;
                        break;
                    }
                    removeObstacles(G, a, b, c);
                }
            }
        }
        if (isSafe) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
