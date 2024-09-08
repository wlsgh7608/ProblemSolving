import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static boolean check(int[] queen){
        for(int i = 0; i<8;i++){
            for(int j = i+1; j<8;j++){
                if(queen[i]==queen[j] || Math.abs(queen[i]-queen[j])==Math.abs(i-j)){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] queen = new int[8];
        int cnt = 0;


        for(int i = 0 ;i<8;i++){
            String str = br.readLine();
            int rowCnt = 0;
            for(int j = 0; j<8;j++){
                char c = str.charAt(j);
                if (c == '*') {
                    queen[i] = j;
                    cnt++;
                    rowCnt++;
                }
            }
            if(rowCnt!=1){
                cnt = -1;
                System.out.println("invalid");
                return;
            }
        }
        if(cnt!=8){
            System.out.println("invalid");
            return;
        }
        if(!check(queen)){
            System.out.println("invalid");
            return;
        }
        System.out.println("valid");




    }
}
