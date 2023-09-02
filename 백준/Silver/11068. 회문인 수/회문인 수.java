import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static boolean isTrue(int d, int n){
        List<Integer> list = new ArrayList<>();
        while(n>0){
            list.add(n % d);
            n = n/d;
        }

        int size = list.size();
        for(int i = 0 ; i<size/2;i++){
            if (list.get(i) != list.get(size - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    static boolean solve(int N){
        for(int i = 2;i<=64;i++){
            if (isTrue(i, N)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0;t<T;t++){
            int N = Integer.parseInt(br.readLine());
            if(solve(N)){
                sb.append(1);
            }else{
                sb.append(0);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
