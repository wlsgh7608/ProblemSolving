import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] top = new int[H + 1];
        int[] bottom = new int[H + 1];

        for (int i = 0; i < N / 2; i++) {
            bottom[Integer.parseInt(br.readLine())]++;
            top[Integer.parseInt(br.readLine())]++;
        }

        for (int i = H - 1; i > 0; i--) {
            bottom[i] += bottom[i + 1];
            top[i] += top[i + 1];
        }

        int min = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 1; i <= H; i++) {
            int sum = bottom[i] + top[H - i + 1];
            if (sum < min) {
                min = sum;
                count = 1;
            } else if (sum == min) {
                count++;
            }
        }
        System.out.println(min + " " + count);

    }
}
