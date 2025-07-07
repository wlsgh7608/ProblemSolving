import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {


    static void dfs(int depth){
        if (depth ==N){
            StringBuilder str = new StringBuilder();
            for(char c: enagram){
                str.append(c);
            }
            sb.append(str).append("\n");

            return;
        }

        for(int i= 0; i<26;i++){
            enagram[depth] = (char)('a'+i);

            if (cntBox[i] > 0 ){
                cntBox[i]--;
                dfs(depth + 1);
                cntBox[i]++;
            }
        }
    }

    static int N;
    static int[] cntBox;
    static char[] enagram;

    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 단어의 길이가 20 이하
        // 만들 수 있는 애너그램의 수는 10만 이하

        //메모리 초과



        cntBox = new int[26];

        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            String str = br.readLine();
            N = str.length();
            cntBox = new int[26];
            enagram = new char[N];
            for(int i =0 ; i <N;i++){
                char c = str.charAt(i);
                cntBox[c - 'a']++;
            }
            dfs(0);

        }
        System.out.println(sb);
    }

}
