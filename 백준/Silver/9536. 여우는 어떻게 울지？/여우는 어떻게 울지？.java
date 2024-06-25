import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int t = 0; t<T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            List<String> sounds = new ArrayList<>();
            while(st.hasMoreTokens()){
                sounds.add(st.nextToken());
            }

            HashSet<String> otherSound = new HashSet<>();

            while(true){
                String str = br.readLine();
                if(str.equals("what does the fox say?")){
                    break;
                }
                st  = new StringTokenizer(str);
                st.nextToken();
                st.nextToken();
                String crying = st.nextToken();
                otherSound.add(crying);
            }
            for(String str : sounds){
                if(otherSound.contains(str)){
                    continue;
                }
                sb.append(str).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
