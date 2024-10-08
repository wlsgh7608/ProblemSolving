import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        boolean isPossible = true;

        for(int i= 0; i<M;i++){
            int K = Integer.parseInt(br.readLine());
            int prev = 200_001;

            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j<K;j++){
                int cur = Integer.parseInt(st.nextToken());
                if (cur > prev) {
                    isPossible = false;
                    break;
                }
                prev = cur;
            }
        }


        if(isPossible){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }
}
