import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t<T;t++){
            int tot = (65 + 90) * 13;
            boolean[] isUsed = new boolean[26];
            String str = br.readLine();
            for(int i = 0 ;i<str.length();i++){
                char c = str.charAt(i);
                isUsed[c - 'A']=  true;
            }

            for(int i = 0; i<26;i++){
                if(isUsed[i]){
                    tot -= 65+i;
                }
            }
            sb.append(tot).append("\n");
        }
        System.out.println(sb);
    }
}
