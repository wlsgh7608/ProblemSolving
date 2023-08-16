import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<Character, Integer> hm = new HashMap<>();
        hm.put(' ', 0);
        for (char c = 'A'; c <= 'Z'; c++) {
            hm.put(c, c - 'A' + 1);
        }
        for (char c = 'a'; c <= 'z'; c++) {
            hm.put(c, c - 'a' + 27);
        }
        int[] isUse = new int[53];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0 ; i<N;i++){
            int n = Integer.parseInt(st.nextToken());
            isUse[n] +=1;
        }

        String sentence = br.readLine();
        boolean isTrue = true;
        for(int i = 0 ;i<N;i++){
            int idx = hm.get(sentence.charAt(i));
            if(isUse[idx]==0){
                isTrue= false;
                break;
            }
            isUse[idx]-=1;
        }
        if(isTrue){
            System.out.println("y");
        }else{
            System.out.println("n");

        }
    }
}
