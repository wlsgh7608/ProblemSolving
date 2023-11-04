import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int maxSum = 0;
        int curSum = 0;
        int period = 1;
        for (int i = 0; i < X; i++) {
            curSum += arr[i];
        }
        maxSum = curSum;

        for (int i = X; i < N; i++) {
            curSum -= arr[i - X];
            curSum += arr[i];
            if (maxSum < curSum) {
                maxSum = curSum;
                period = 1;
            } else if (maxSum == curSum) {
                period++;
            }
        }

        if (maxSum == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(maxSum);
            System.out.println(period);
        }


    }
}
