import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 1;i <=N;i++){

            Stack<String> S = new Stack<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                S.add(st.nextToken());
            }
            sb.append("Case #").append(i).append(": ");
            while(!S.isEmpty()){
                sb.append(S.pop()).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}
