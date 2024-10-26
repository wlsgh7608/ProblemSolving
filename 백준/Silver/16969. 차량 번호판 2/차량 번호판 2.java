import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    final static long MOD = 1_000_000_009;

    static int getNum(char c){
        if(c=='c'){
            return 26;
        }else{
            return 10;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int N = str.length();
        char[] arr = new char[N + 1];
        for(int i= 0; i<N;i++){
            arr[i + 1] = str.charAt(i);
        }

        long result =1;

        for(int i = 1; i<=N;i++){
            int num = getNum(arr[i]);
            if(arr[i-1] ==arr[i]){
                num--;
            }
            result = (result * num) % MOD;
        }
        System.out.println(result);
    }
}
