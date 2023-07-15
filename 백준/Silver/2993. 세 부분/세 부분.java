import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static String reverse(String str){
        StringBuilder sb= new StringBuilder(str);
        return sb.reverse().toString();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = str.length();
        String prevStr = null;
        for(int i = 1;i<N-1;i++){
            for(int j = i+1;j<N;j++){
                String a = str.substring(0,i);
                String b = str.substring(i,j);
                String c = str.substring(j);

                String newStr = reverse(a)+reverse(b)+reverse(c);
                if(prevStr==null){
                    prevStr = newStr;
                }else{
                    if(newStr.compareTo(prevStr)<0){
                        prevStr = newStr;
                    }
                }
            }
        }
        System.out.println(prevStr);

    }
}
