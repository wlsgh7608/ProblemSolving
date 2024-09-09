import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int  N= Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = 0;
        for(int i= 0 ;i<3;i++){
            int cnt = Integer.parseInt(st.nextToken());
            sum += Math.min(cnt, N);
        }
        System.out.println(sum);

    }
}
