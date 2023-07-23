import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashSet<String> hs = new HashSet<>();
        for(int i = 0 ;i<N;i++){
            char[] inp = br.readLine().toCharArray();

            Arrays.sort(inp);
            StringBuilder sb = new StringBuilder();
            for(char c : inp){
                sb.append(c);
            }
            hs.add(sb.toString());

        }
        System.out.println(hs.size());

    }
}
