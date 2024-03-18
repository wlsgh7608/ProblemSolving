import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        HashSet<Character> hs = new HashSet<>();
        hs.add('a');
        hs.add('e');
        hs.add('i');
        hs.add('o');
        hs.add('u');

        int cnt = 0;
        for(int i = 0 ;i < str.length();i++){
            char c = str.charAt(i);
            if (hs.contains(c)) {
                cnt++;
            }
        }
        System.out.println(cnt);

    }

}
