import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long  N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        if(N>=M){
            System.out.println(0);
        }else{
            long cur = N;
            while(--N>0){
                cur*=N;
                cur %= M;
            }

            System.out.println(cur);

        }
    }
}
