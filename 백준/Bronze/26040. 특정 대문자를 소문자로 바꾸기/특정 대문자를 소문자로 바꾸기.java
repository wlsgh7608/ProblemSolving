import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()){
            String alphabet = st.nextToken();
            str = str.replaceAll(alphabet, alphabet.toLowerCase());
        }
        System.out.println(str);

    }
}
