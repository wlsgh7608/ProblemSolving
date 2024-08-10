import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double[] arr = new double[7];
        Arrays.fill(arr, 100);

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            double score = Double.parseDouble(br.readLine());
            for(int j = 0; j <7; j++){
                if(score <= arr[j]){
                    for(int k = 6; k > j; k--){
                        arr[k] = arr[k-1];
                    }
                    arr[j] = score;
                    break;
                }
            }

        }

        for (int i = 0; i < 7; i++) {
            System.out.println(String.format("%.3f", arr[i]));
        }
    }
}