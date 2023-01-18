import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Elv{
		int floor;
		int cnt;
		public Elv(int floor, int cnt) {
			super();
			this.floor = floor;
			this.cnt = cnt;
		}
		
		
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		boolean[] isVisited = new boolean[F+1];
		isVisited[S] = true;
		Queue<Elv> Q = new ArrayDeque<>();
		Q.add(new Elv(S,0));
		int result = -1;
		while(!Q.isEmpty()) {
			Elv cur = Q.poll();
			int f = cur.floor;
			int c = cur.cnt;
			
			if(f==G) {
				result = c;
				break;
			}
			
			if(f+U <=F && !isVisited[f+U]) {
				Q.add(new Elv(f+U,c+1));
				isVisited[f+U]= true;
			}
			if(f-D >0 && !isVisited[f-D]) {
				Q.add(new Elv(f-D,c+1));
				isVisited[f-D]= true;
			}
			
			
		}
		if(result!=-1) {
			System.out.println(result);
		}else {
			System.out.println("use the stairs");
		}
		
		
		
		
	}

}
