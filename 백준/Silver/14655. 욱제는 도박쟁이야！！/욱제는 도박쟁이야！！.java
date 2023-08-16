import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0 ;i<N;i++){
            int n = Integer.parseInt(st.nextToken());
            result += Math.abs(n);
        }
        st = new StringTokenizer(br.readLine());
        for(int i =0 ;i<N;i++){
            int n = Integer.parseInt(st.nextToken());
            result += Math.abs(n);
        }
        System.out.println(result);
    }
}
