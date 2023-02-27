import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			int n= Integer.parseInt(br.readLine());
			list.add(n);
		}
		Collections.sort(list,Collections.reverseOrder());
		int P = N / 3;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			if(i%3==2)continue;
			sum += list.get(i);
		}
		System.out.println(sum);
	}

}
