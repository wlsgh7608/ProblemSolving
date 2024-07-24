import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] maxArr = new int[]{100, 100, 200, 200, 300, 300, 400, 400, 500};

        int sum = 0;
        for(int i = 0; i<9;i++){
            int score = Integer.parseInt(st.nextToken());
            if(maxArr[i]<score){
                sum = -1;
                break;
            }
            sum+=score;
        }
        if(sum==-1){
            System.out.println("hacker");
        }else if(sum<100){
            System.out.println("none");
        }else{
            System.out.println("draw");
        }

    }
}
