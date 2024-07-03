import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0 ; i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int maxCost = Integer.MAX_VALUE;
        for(int i = 1;i<N;i++){
            int cost = arr[i - 1] * X + arr[i] * X;
            maxCost = Math.min(maxCost, cost);
        }
        System.out.println(maxCost);

    }
}
