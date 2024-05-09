import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean isPossible(int[] light, int height, int N) {
        int current = 0;
        for (int i = 0; i < light.length; i++) {
            if (light[i] - height > current) {
                return false;
            }

            current = light[i] + height;
        }

        if (current < N) {
            return false;
        }
        return true;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] light = new int[M];
        for (int i = 0; i < M; i++) {
            light[i] = Integer.parseInt(st.nextToken());
        }
        int lo = 1;
        int hi = N;
        int ans = 0;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (isPossible(light, mid, N)) {
                hi = mid - 1;
                ans = mid;
            } else {
                lo = mid + 1;
            }
        }
        System.out.println(ans);


    }
}
