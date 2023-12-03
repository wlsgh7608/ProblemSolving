import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for(int i = 0 ; i< 5;i++){
            int b = Integer.parseInt(st.nextToken());
            if(A==b){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}