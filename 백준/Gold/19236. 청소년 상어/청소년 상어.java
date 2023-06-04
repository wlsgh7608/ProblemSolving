
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Fish implements Comparable<Fish> {
        int n;
        int d;
        int x;
        int y;

        public Fish(Fish f) {
            this.n = f.n;
            this.d = f.d;
            this.x = f.x;
            this.y = f.y;
        }

        public Fish(int n, int d, int x, int y) {
            this.n = n;
            this.d = d;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Fish o) {
            return this.n - o.n;
        }

        @Override
        public String toString() {
            return "Fish{" +
                    "n=" + n +
                    ", d=" + d +
                    ", x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    static class Shark extends Fish {
        public Shark(Fish f) {
            super(f);
        }

        public Shark(int n, int d, int x, int y) {
            super(n, d, x, y);
        }

        @Override
        public String toString() {
            return "Shark{" +
                    "n=" + n +
                    ", d=" + d +
                    ", x=" + x +
                    ", y=" + y +
                    '}';
        }
    }


    static void change(Fish a, Fish b,Fish[][] G) {
        Fish temp = new Fish(a);

        a.x = b.x;
        a.y = b.y;

        b.x = temp.x;
        b.y = temp.y;
        G[b.x][b.y] = b;
        G[a.x][a.y] = a;
    }


    static void move(Fish[][] G) {
        Fish[] fishList = new Fish[16];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                fishList[i * 4 + j] = G[i][j];
            }
        }

        Arrays.sort(fishList);
        for (int i = 0; i < 16; i++) {
            if (!isEat[i + 1]) {
                for (int d = 0; d < 8; d++) {
                    Fish cur = fishList[i];
                    int x = cur.x;
                    int y = cur.y;
                    int dir = (cur.d + d) % 8;
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];

                    if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4) {
                        continue;
                    }

                    if (nx == shark.x && ny == shark.y) {
                        continue;
                    }
                    cur.d = dir;
                    Fish next = G[nx][ny];
                    change(cur, next,G);
                    break;
                }
            }
        }
    }

    static void eat(Fish[][] G) {
        int tempX = shark.x;
        int tempY = shark.y;
        int tempD = shark.d;

        int nx = shark.x + dx[shark.d];
        int ny = shark.y + dy[shark.d];
        while (nx >= 0 && nx < 4 && ny >= 0 && ny < 4) {
            Fish fish = G[nx][ny];
            if (!isEat[fish.n]) {
                isEat[fish.n] = true;
                shark.x = nx;
                shark.y = ny;
                shark.d = fish.d;
                score += fish.n;

                Fish[][] newG = new Fish[4][4];
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        newG[i][j] = new Fish(G[i][j]);
                    }
                }

                process(newG);
                score -= fish.n;
                isEat[fish.n] = false;
            }
            nx += dx[tempD];
            ny += dy[tempD];
        }
        shark.x = tempX;
        shark.y = tempY;
        shark.d = tempD;
    }

    static void process(Fish[][] G) {

        maxScore = Math.max(score, maxScore);
        // 물고기 이동
        move(G);
        // 잡아 먹기
//        print(G);
        eat(G);
    }

//    static void print(Fish[][] G) {
//        for (Fish[] row : G) {
//            for (Fish fish : row) {
//                if (isEat[fish.n]) {
//                    System.out.print("EAT");
//                } else {
//                    System.out.print(fish);
//                }
//                System.out.print("\t");
//            }
//            System.out.println();
//        }
//    }

    static boolean[] isEat = new boolean[17];

    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static Fish shark;
    static int maxScore = 0;
    static int score = 0;

    public static void main(String[] args) throws Exception {

        Fish[][] G = new Fish[4][4];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int n = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken()) - 1;
                G[i][j] = new Fish(n, d, i, j);
            }
        }

        shark = new Shark(0, G[0][0].d, 0, 0);
        isEat[G[0][0].n] = true;

        score += G[0][0].n;
        process(G);
        System.out.println(maxScore);

    }
}
