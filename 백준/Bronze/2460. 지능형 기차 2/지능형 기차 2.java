import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int maxPeople = 0;
        int cur = 0;
        for(int i= 0 ; i<10;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int out = Integer.parseInt(st.nextToken());
            int in = Integer.parseInt(st.nextToken());

            cur-=out;
            cur+=in;
            maxPeople = Math.max(maxPeople, cur);
        }
        System.out.println(maxPeople);
    }
}
