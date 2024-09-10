import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringBuilder sb = new StringBuilder();
        while(true){
            String str = br.readLine();
            if (str.equals("0")) {
                break;
            }

            int len = 2;

            for(int i = 0; i<str.length();i++){
                char c= str.charAt(i);
                if(c=='1'){
                    len+=2;
                }else if(c=='0'){
                    len+=4;
                }else{
                    len+=3;
                }
                len++;
            }
            len--;
            sb.append(len).append("\n");
        }
        System.out.println(sb);

    }
}
