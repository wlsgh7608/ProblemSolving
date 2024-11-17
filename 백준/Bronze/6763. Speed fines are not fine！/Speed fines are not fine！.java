import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int limit = Integer.parseInt(br.readLine());
        int speed = Integer.parseInt(br.readLine());

        int diff = speed - limit;
        if(diff<=0){
            System.out.println("Congratulations, you are within the speed limit!");
        }else{
            StringBuilder sb = new StringBuilder();
            sb.append("You are speeding and your fine is $");
            if(diff<=20){
                sb.append("100");
            }else if(diff<=30){
                sb.append("270");
            }else{
                sb.append("500");
            }
            sb.append(".");
            System.out.println(sb);
        }

    }
}
