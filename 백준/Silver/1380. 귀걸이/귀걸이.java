import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = 1;

        while(true){
            int N = Integer.parseInt(br.readLine());
            if(N == 0) break;
            String[] arr = new String[N+1];
            boolean[] check = new boolean[N+1];
            for(int i = 1; i <= N; i++){
                arr[i] = br.readLine();
            }

            for(int  i = 0;i<2*N-1;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int idx = Integer.parseInt(st.nextToken());
                check[idx] = !check[idx];
            }

            for(int i =1;i<=N;i++){
                if(check[i]){
                    sb.append(T+" ").append(arr[i]).append("\n");
                }
            }
            T++;
        }
        System.out.println(sb);

    }
}
