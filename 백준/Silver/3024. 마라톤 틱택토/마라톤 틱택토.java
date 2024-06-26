import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {


    static char getWinner(char[][] G) {
        int N = G.length;

        int[] dx = new int[]{0, 1, 1, 1};
        int[] dy = new int[]{1, 0, 1, -1};


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char prev = G[i][j];

                nextLoop:
                for (int k = 0; k < 4; k++) {
                    for (int l = 0; l < 3; l++) {
                        int nx = i + l * dx[k];
                        int ny = j + l * dy[k];


                        if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                            continue nextLoop;
                        }
                        char cur = G[nx][ny];
                        if (cur != prev || cur == '.') {
                            continue nextLoop;
                        }
                    }
                    return prev;
                }
            }
        }
        return '.';
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] G = new char[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                G[i][j] = str.charAt(j);
            }
        }

        char result = getWinner(G);
        if (result != '.') {
            System.out.println(result);
        } else {
            System.out.println("ongoing");
        }

    }
}
