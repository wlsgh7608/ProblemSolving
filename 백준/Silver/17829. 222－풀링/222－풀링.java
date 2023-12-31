import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static void findMaximum(int size, int[][] G) {
        if (size == 1) {
            maxNum = G[0][0];
            return;
        }
        int[][] newG = new int[size / 2][size / 2];
        for (int i = 0; i < size / 2; i++) {
            for (int j = 0; j < size / 2; j++) {
                int[] arr = new int[4];
                arr[0] = G[i * 2][j * 2];
                arr[1] = G[i * 2 + 1][j * 2];
                arr[2] = G[i * 2][j * 2 + 1];
                arr[3] = G[i * 2 + 1][j * 2 + 1];
                Arrays.sort(arr);
                newG[i][j] = arr[2];
            }
        }
        findMaximum(size / 2, newG);
    }

    static int maxNum = -10_001;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        int[][] G = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                G[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        findMaximum(N, G);
        System.out.println(maxNum);
    }
}
