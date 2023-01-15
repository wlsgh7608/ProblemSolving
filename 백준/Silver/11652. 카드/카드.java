import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<Long, Integer> hm = new HashMap<>();
		for(int i = 0; i<N;i++) {
			long n = Long.parseLong(br.readLine());
			int cnt = hm.getOrDefault(n, 0);
			hm.put(n, cnt+1);
		}
		long maxN = -1;
		int max = 0;
		Long[] list = new Long[hm.keySet().size()];
		int idx = 0;
		for(long n : hm.keySet()) {
			list[idx++] = n;
		}
		Arrays.sort(list);
		
		for(long n : list) {
			if(hm.get(n)>max) {
				max = hm.get(n);
				maxN = n;
			}
		}
		System.out.println(maxN);
	}
}
