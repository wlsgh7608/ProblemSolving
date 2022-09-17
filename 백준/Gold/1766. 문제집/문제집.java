import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] cnt = new int [N+1]; 
		ArrayList<Integer>[] adjList = new ArrayList[N+1];
		for(int i = 0; i<N+1;i++) {
			adjList[i] = new ArrayList<>();
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i = 0; i<M;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adjList[a].add(b);
			cnt[b]+=1;
		}
		for(int i = 1;i<N+1;i++) {
			if (cnt[i] == 0){
				pq.add(i);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()) {
			int c = pq.poll();
			sb.append(c+" ");
			for(int next: adjList[c]) {
				if(--cnt[next]==0) {
					pq.add(next);
				}
			}
			
		}
		System.out.println(sb);
		
		
	}
}
