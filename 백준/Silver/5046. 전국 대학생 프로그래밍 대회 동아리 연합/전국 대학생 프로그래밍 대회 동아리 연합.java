import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int minCost = Integer.MAX_VALUE;

        for (int i = 0; i < H; i++) {
            int hotelCost = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                int available = Integer.parseInt(st.nextToken());
                if (available >= N) {
                    minCost = Math.min(minCost, N * hotelCost);
                }
            }
        }

        if (minCost <= B) {
            System.out.println(minCost);
        } else {
            System.out.println("stay home");
        }


    }
}
