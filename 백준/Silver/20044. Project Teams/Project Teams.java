import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[2 * N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0;  i<2*N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int sum = Integer.MAX_VALUE;
        for(int i = 0 ;i<N;i++){
            int cur = arr[i] + arr[2 * N - i - 1];
            sum = Math.min(sum, cur);
        }
        System.out.println(sum);

    }
}
