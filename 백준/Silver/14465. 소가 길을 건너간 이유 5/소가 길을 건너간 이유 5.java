import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        Arrays.fill(arr, 1);
        arr[0] = 0;
        for(int i=0;i<B;i++){
            arr[Integer.parseInt(br.readLine())] = 0;
        }

        int cur = 0;
        for(int i =1;i<K;i++){
            cur+=arr[i];
        }

        int maxOn = cur;
        for(int i = K; i<=N;i++){
            cur+=arr[i];
            cur-=arr[i-K];
            maxOn = Math.max(maxOn,cur);
        }

        System.out.println(K-maxOn);





    }
}
