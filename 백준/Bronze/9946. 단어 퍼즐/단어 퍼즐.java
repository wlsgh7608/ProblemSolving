import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static boolean isZero(int[] arr){
        for(int i =0 ; i<arr.length;i++){
            if(arr[i] != 0){
                return false;
            }

        }
        return true;

    }


    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int caseNum = 1;
        while(true){
            String a = br.readLine();
            String b = br.readLine();
            if(a.equals("END") && b.equals("END")){
                break;
            }


            int[] arr = new int[26];
            for (int i = 0; i < a.length(); i++) {
                arr[a.charAt(i) - 'a']++;
            }
            for (int i = 0; i < b.length(); i++) {
                arr[b.charAt(i) - 'a']--;
            }

            if(isZero(arr)) {
                sb.append("Case ").append(caseNum).append(": same\n");
            } else {
                sb.append("Case ").append(caseNum).append(": different\n");
            }
            caseNum++;
        }
        System.out.println(sb);


    }
}
