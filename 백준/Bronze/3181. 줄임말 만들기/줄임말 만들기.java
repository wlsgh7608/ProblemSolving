import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> set = new HashSet<>();
        set.add("i");
        set.add("pa");
        set.add("te");
        set.add("ni");
        set.add("niti");
        set.add("a");
        set.add("ali");
        set.add("nego");
        set.add("no");
        set.add("ili");

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        while(st.hasMoreTokens()){
            String str = st.nextToken();
            if(cnt>0 && set.contains(str)){
                continue;
            }
            sb.append(str.toUpperCase().charAt(0));
            cnt++;
        }
        System.out.println(sb);

    }
}
