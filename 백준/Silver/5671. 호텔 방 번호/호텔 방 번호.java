import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean isValid(int n){
        boolean[] cnt = new boolean[10];
        while(n>0){
            if(cnt[n%10]){
                return false;
            };
            cnt[n%10] = true;
            n/=10;
        }
        return true;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str ="";
        while((str= br.readLine())!=null){
            StringTokenizer st = new StringTokenizer(str);
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int cnt = 0;
            for(int i = N; i<=M;i++){
                if (isValid(i)) {
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);

    }
}
