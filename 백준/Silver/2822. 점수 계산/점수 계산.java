import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static class Score implements Comparable<Score>{
		int idx;
		int p;
		public Score(int idx, int p) {
			super();
			this.idx = idx;
			this.p = p;
		}
		@Override
		public int compareTo(Score o) {
			return o.p-this.p;
		}
		
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Score[] sc = new Score[8];
		for(int i = 0; i<8;i++) {
			int score = Integer.parseInt(br.readLine());
			sc[i] = new Score(i+1,score); 
		}
		Arrays.sort(sc);
		int result = 0;
		int[] ans = new int[5];
		for(int i = 0; i<5;i++) {
			result+= sc[i].p;
			ans[i] = sc[i].idx;
		}
		Arrays.sort(ans);
		System.out.println(result);
		for(int n : ans) {
			System.out.print(n+" ");
		}
		
		
	}

}
