import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Loc {
        int x;
        int y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            char[][] G = new char[h + 2][w + 2];
            List<Loc>[] doors = new ArrayList[26];
            boolean[][] visited = new boolean[h + 2][w + 2];
            for (int i = 0; i < 26; i++) {
                doors[i] = new ArrayList<>();
            }
            for (char[] row : G) {
                Arrays.fill(row, '.');
            }
            for (int i = 1; i <= h; i++) {
                String input = br.readLine();
                for (int j = 0; j < w; j++) {
                    G[i][j + 1] = input.charAt(j);
                    char c = G[i][j + 1];
                    if (c >= 'A' && c <= 'Z') {
                        doors[c - 'A'].add(new Loc(i, j + 1));
                    }
                }
            }
            boolean[] key = new boolean[26];
            String keys = br.readLine();
            for (int i = 0; i < keys.length(); i++) {
                char c = keys.charAt(i);
                if (c - 'a' < 0) {
                    break;
                }
                key[c - 'a'] = true; // 현재 가지고 있는 열쇠
            }

            for (int i = 0; i < 26; i++) {
                if (key[i]) {
                    for (Loc l : doors[i]) {
                        int x = l.x;
                        int y = l.y;
                        G[x][y] = '.';
                    }
                }
            }

            Queue<Loc> Q = new ArrayDeque<>();
            Q.add(new Loc(0, 0));
            visited[0][0] = true;
            int cnt = 0;


            while (!Q.isEmpty()) {
                Loc cur = Q.poll();
                int x = cur.x;
                int y = cur.y;
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx < 0 || ny < 0 || nx >= h + 2 || ny >= w+2 || visited[nx][ny] ||
                            G[nx][ny] == '*' || (G[nx][ny] >= 'A' && G[nx][ny] <= 'Z')) {
                        continue;
                    }
                    // 1 bfs
                    // 열쇠를 찾으면 => 방문 배열 초기화 =>
                    // 일괄처리 => 열쇠 문 => .
                    // 더 이상 진행할게 없으면 끝?


                    char c = G[nx][ny];
                    Q.add(new Loc(nx, ny));
                    if ('a' <= c && c <= 'z') {
                        int idx = c - 'a';
                        if (!key[idx]) {
                            key[idx] = true; // 키 획득
                            G[nx][ny] = '.';
                            for (Loc loc : doors[idx]) {
                                G[loc.x][loc.y] = '.'; // 문 -> '.'
                            }


                            visited = new boolean[h + 2][w + 2];
                        }
                    }
                    if(c=='$'){
                        cnt++;
                        G[nx][ny] = '.';
                    }

                    visited[nx][ny] = true;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);

    }
}
