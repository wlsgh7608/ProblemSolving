import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0 ; i<N;i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        double result = 0.0;
        for(int i =0 ; i<N-1;i++){
            result+= 1.0*arr[i]/2;
        }
        result += arr[N - 1];
        System.out.println(result);

    }
}
