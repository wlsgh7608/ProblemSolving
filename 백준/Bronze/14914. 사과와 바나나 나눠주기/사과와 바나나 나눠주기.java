import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] fruits = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int min = Math.min(fruits[0], fruits[1]);
    for (int i = 1; i <= min; i++) {
      if (fruits[0] % i == 0 && fruits[1] % i == 0) {
        System.out.println(i + " " + fruits[0] / i + " " + fruits[1] / i);
      }
    }
  }
  
}