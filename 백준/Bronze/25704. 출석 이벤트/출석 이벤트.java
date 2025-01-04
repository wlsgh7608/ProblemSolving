import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());

        int cost = P;

        if(N>=5){
            cost = Math.min(cost, P - 500);
        }
        if(N>=10){
            cost = Math.min(cost, (int) (P * 0.9));
        }
        if(N>=15){
            cost = Math.min(cost, P - 2000);
        }
        if(N>=20){
            cost = Math.min(cost, (int) (P * 0.75));
        }

        if(cost<0){
            cost = 0;
        }
        System.out.println(cost);


    }
}
