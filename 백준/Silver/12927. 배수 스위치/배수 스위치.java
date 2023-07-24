import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        int N = input.length;

        boolean[] isOn = new boolean[N + 1];
        for(int i = 0; i<N;i++){
            if (input[i] == 'Y') {
                isOn[i + 1] = true;
            }
        }

        int cnt = 0;
        for(int i = 1;i <=N;i++){

            if(isOn[i]){
                cnt++;
                for(int j = 1; i*j<=N;j++){
                    isOn[i * j] = !isOn[i * j];
                }

            }
        }
        System.out.println(cnt);

    }
}
