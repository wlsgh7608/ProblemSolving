import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] G = new char[N][N];


        Node head = null;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                G[i][j] = str.charAt(j);
                if (G[i][j] == '*' && head == null) {
                    head = new Node(i, j);
                }
            }
        }

        Node heart = new Node(head.x + 1, head.y);
        int[] arr = new int[5];

        int x = heart.x;
        int y = heart.y;

        for (int i = 1; i < N; i++) {
            int ny = y - i;
            if (ny < 0 || ny >= N) {
                break;
            }
            if (G[x][ny] == '*') {
                arr[0]++;
            }
        }

        for (int i = 1; i < N; i++) {
            int ny = y + i;
            if (ny < 0 || ny >= N) {
                break;
            }
            if (G[x][ny] == '*') {
                arr[1]++;
            }
        }

        for (int i = 1; i < N; i++) {
            int nx = x + i;
            if (nx < 0 || nx >= N) {
                break;
            }
            if (G[nx][y] == '*') {
                arr[2]++;
            }
        }

        x = heart.x + arr[2];


        for (int i = 1; i < N; i++) {
            int nx = x + i;
            if (nx < 0 || nx >= N) {
                break;
            }
            if (G[nx][y - 1] == '*') {
                arr[3]++;
            }
        }

        for (int i = 1; i < N; i++) {
            int nx = x + i;
            if (nx < 0 || nx >= N) {
                break;
            }
            if (G[nx][y + 1] == '*') {
                arr[4]++;
            }
        }
        StringBuilder sb = new StringBuilder();

        sb.append(heart.x + 1).append(" ").append(heart.y + 1).append("\n");
        for (int i = 0; i < 5; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);


    }
}
