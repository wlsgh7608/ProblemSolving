import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for(int i =0 ;  i<5;i++){
            int predict = Integer.parseInt(st.nextToken());
            if (predict == ans) {
                cnt++;
            }
        }
        System.out.println(cnt);

    }
}
