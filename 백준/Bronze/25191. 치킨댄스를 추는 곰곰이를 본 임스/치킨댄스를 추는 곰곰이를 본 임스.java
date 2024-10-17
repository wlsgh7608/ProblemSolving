import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        cnt+=Integer.parseInt(st.nextToken())/2;
        cnt+=Integer.parseInt(st.nextToken());
        System.out.println(Math.min(N, cnt));

    }
}
