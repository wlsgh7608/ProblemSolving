import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t = 0 ;t<T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[5];
            for(int i= 0 ; i<5;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            if(arr[3] - arr[1]>=4){
                sb.append("KIN").append("\n");
            }else{
                int tot = arr[1] + arr[2] + arr[3];
                sb.append(tot).append("\n");
            }
        }
        System.out.println(sb);

    }
}
