import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String A = st.nextToken();
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if(A.equals("#") && B==0 && C==0){
                break;
            }

            sb.append(A).append(" ");
            if(B>17 || C >=80){
                sb.append("Senior").append("\n");
            }else{
                sb.append("Junior").append("\n");
            }
        }
        System.out.println(sb);

    }
}
