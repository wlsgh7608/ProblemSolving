import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        HashSet<String> hs = new HashSet<>();
        int N = Integer.parseInt(br.readLine());
        for(int i = 0 ; i<N;i++){
            hs.add(br.readLine());
        }
        boolean[] dp = new boolean[input.length()];

        for(int i = input.length()-1;i>=0;i--){
            for(int j = i+1;j<input.length();j++){
                if (dp[j] && hs.contains(input.substring(i, j))) {
                    dp[i] = true;
                }

            }
            if (hs.contains(input.substring(i))) {
                dp[i]=  true;
            }

        }
        if(dp[0]){
            System.out.println(1);
        }else{
            System.out.println(0);
        }

    }
}
