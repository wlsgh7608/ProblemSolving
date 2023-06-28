import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static class Cow {
        int x;
        int y;

        public Cow(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int getSum(int x1, int y1, int x2, int y2) {

        return dp[x2][y2] - dp[x1 - 1][y2] - dp[x2][y1 - 1] + dp[x1 - 1][y1 - 1];
    }


    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Cow[] cows = new Cow[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            cows[i] = new Cow(x, y);
        }
        TreeSet<Integer> xIdx = new TreeSet<>();
        TreeSet<Integer> yIdx = new TreeSet<>();

        for (Cow cow : cows) {
            xIdx.add(cow.x);
            yIdx.add(cow.y);
        }

        int xSize = xIdx.size();
        int ySize = yIdx.size();

        HashMap<Integer, Integer> xHm = new HashMap<>();
        HashMap<Integer, Integer> yHm = new HashMap<>();

        int p = 0;
        for (int x : xIdx) {
            xHm.put(x, p++);
        }
        p = 0;
        for (int y : yIdx) {
            yHm.put(y, p++);
        }


        int[][] G = new int[xSize][ySize];
        dp = new int[xSize + 1][ySize + 1];

        for (Cow cow : cows) {
            int x = xHm.get(cow.x);
            int y = yHm.get(cow.y);
            G[x][y]++;
        }

        for (int i = 1; i <= xSize; i++) {
            for (int j = 1; j <= ySize; j++) {
                // dp 좌표 (x,y)
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + G[i - 1][j - 1];
            }
        }
        //dp 세팅
        int result = Integer.MAX_VALUE;
        for (int i = 1; i <= xSize; i++) {
            for (int j = 1; j <= ySize; j++) {
                int area1 = getSum(1, 1, i, j);
                int area2 = getSum(i+1, 1, xSize, j);
                int area3 = getSum(1, j+1, i, ySize);
                int area4 = getSum(i + 1, j + 1, xSize, ySize);
                int max1 = Math.max(area1, area2);
                int max2 = Math.max(area3, area4);
                int max = Math.max(max1, max2);
                result = Math.min(max, result);
            }
        }
        System.out.println(result);


    }
}
