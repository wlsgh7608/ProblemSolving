import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		long min = Long.parseLong(input[0]);
		long max = Long.parseLong(input[1]);
		boolean[] isYes = new boolean[(int) (max-min+1)];
		
		
		for (long i = 2; i * i <= max; i++) {
			long start = (long) Math.ceil(1.0*min/(i*i));
			for (long iter = start; i*i*iter <= max; iter++) {
				isYes[(int) (i * i * iter-min)] = true;
			}
		}

		int result = 0;
		for(boolean isTrue:isYes) {
			if(!isTrue) {
				result++;
			}
		}
		System.out.println(result);

	}

}
