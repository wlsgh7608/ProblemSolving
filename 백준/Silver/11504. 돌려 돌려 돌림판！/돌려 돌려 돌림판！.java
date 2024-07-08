import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int X = 0;
            int Y = 0;
            for(int i = 0; i<M;i++){
                X*=10;
                X += Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i<M;i++){
                Y*=10;
                Y += Integer.parseInt(st.nextToken());

            }

            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i<N;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int cnt = 0;

            for(int i = 0 ;i<N;i++){
                int cur = 0;
                for(int j = 0;  j<M;j++){
                    cur*=10;
                    cur+=arr[(i+j)%N];
                }
                if(X<=cur&& cur<=Y){
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);


    }
}
