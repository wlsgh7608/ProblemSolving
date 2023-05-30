import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] G = new char[8][8];

        for (int i = 0; i < 8; i++) {
            G[i] = br.readLine().toCharArray();
        }

        int cnt = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    if (G[i][j] == 'F') {
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);


    }
}
