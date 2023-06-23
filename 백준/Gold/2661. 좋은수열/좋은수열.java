import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {


    static boolean check(String newN){
        int size = newN.length();
        for(int i = 1;i*2<=newN.length();i++){
            String subString1 = newN.substring(size - (2*i), size - i);
            String subString2 = newN.substring(size - i);
            if (subString1.equals(subString2)) {
                return false;
            }
        }
        return true;
    }

    static void dfs(int idx, String n) {
        if (idx == N) {
            isFinish= true;
            System.out.println(n);
            return;
        }

        for (int i = 1; i <= 3; i++) {
            String newN = n + i;
            if(check(newN)){
                dfs(idx + 1, newN);
            }
            if(isFinish){
                return;
            }
        }


    }

    static int N;
    static boolean isFinish=false;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dfs(1, "1");


    }
}
