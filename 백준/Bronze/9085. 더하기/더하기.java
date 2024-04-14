import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<T;i++){
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sum = 0;
            for(int j = 0; j<N;j++){
                sum += Integer.parseInt(st.nextToken());
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);

    }
}
