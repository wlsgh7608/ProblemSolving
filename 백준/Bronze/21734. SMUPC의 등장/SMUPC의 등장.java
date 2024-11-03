import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = str.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ;i <N;i++){
            char c = str.charAt(i);

            int ascii = c;
            int iter = 0;
            while(ascii>0){
                iter+= ascii%10;
                ascii /= 10;
            }
            for(int j = 0; j <iter;j++){
                sb.append(c);
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}
