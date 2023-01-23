import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i<N;i++) {
			list.add(Integer.parseInt(br.readLine()));
			
		}
		Collections.sort(list,(o1,o2)->o2-o1);
		StringBuilder sb = new StringBuilder();
		for(int n : list) {
			sb.append(n).append("\n");
		}
		System.out.println(sb);
	}

}
