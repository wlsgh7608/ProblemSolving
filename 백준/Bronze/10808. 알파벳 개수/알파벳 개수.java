import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] cnt = new int[26];
        for(int i=0;i<input.length();i++){
            char c = input.charAt(i);
            cnt[c-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int n : cnt){
            sb.append(n + " ");
        }
        System.out.println(sb);
    }
}
