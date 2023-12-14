import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt=0;
        for(int a=1;a<=N/3;a++) {
            for(int b=a;b<=(N-a)/2;b++) {
                int c=N-a-b;
                if(b>c) break;

                if(c<a+b) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}