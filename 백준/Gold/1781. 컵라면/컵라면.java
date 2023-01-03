import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		List<Integer>[] deadLine = new List[N+1];
		for(int i = 0; i<=N;i++) {
			deadLine[i]= new ArrayList<>();
		}
		
		for(int i = 0; i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int date = Integer.parseInt(st.nextToken());
			int cup= Integer.parseInt(st.nextToken());
			deadLine[date].add(cup);
		}
		
		
		int day = N+1;
		int ans = 0;
		for(int i = 1;i<=N;i++) {
			Collections.sort(deadLine[i],(o1,o2)->o2-o1);
		}
		
		PriorityQueue<Integer> PQ = new PriorityQueue<>((o1,o2)->(o2-o1));
		while(--day>0) {
			
			for(int n: deadLine[day]) {
				PQ.add(n);
			}
			if(!PQ.isEmpty()) {
				ans += PQ.poll();
			}
		}
		System.out.println(ans);
		
	}

}
