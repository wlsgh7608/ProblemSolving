import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 0 ;t<T;t++){
            int N = Integer.parseInt(br.readLine());
            boolean isOnly = true;
            int maxNum = -1;
            int idx = 0;
            int sum = 0;
            for(int i = 1 ; i<=N;i++){
                int n = Integer.parseInt(br.readLine());
                sum+=n;
                if(n>maxNum){
                    maxNum = n;
                    idx = i;
                    isOnly = true;
                }else if (n==maxNum){
                    isOnly = false;
                }
            }
            if(isOnly){
                if(maxNum > sum/2){
                    sb.append("majority winner ");
                }else{
                    sb.append("minority winner ");
                }
                sb.append(idx).append("\n");
            }else{
                sb.append("no winner").append("\n");
            }
        }
        System.out.println(sb);
    }
}
