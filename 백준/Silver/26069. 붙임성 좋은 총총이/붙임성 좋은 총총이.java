import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashSet<String> hs = new HashSet<>();
        hs.add("ChongChong");
        for(int i = 0 ;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            if (hs.contains(a) || hs.contains(b)) {
                hs.add(b);
                hs.add(a);
            }
        }
        System.out.println(hs.size());
    }
}
