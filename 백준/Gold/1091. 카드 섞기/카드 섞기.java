
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] P  = new int[N];
		int[] S  = new int[N];
		
		
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		for(int i = 0; i<N;i++) {
			P[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i<N;i++) {
			S[i] = Integer.parseInt(st.nextToken());
		}
		int[] cards = new int[N];
		for(int i = 0; i<N;i++) {
			cards[i] = i;
		}
			
		int time = 0 ;
		while(true) {
			boolean isTrue = true;
			for(int i = 0; i<N;i++) {
				if(cards[i]%3 != P[i]) {
					isTrue = false;
					break;
				}
			}
			if(isTrue) {
				break;
			}
			
			
			
			int [] temp = new int[N];
			for(int i = 0; i<N;i++) {
				temp[i] = cards[S[i]];
			}
			cards = temp;
			
			boolean isTaecho = true;;
			for(int i = 0; i<N;i++) {
				if(cards[i] != i) {
					isTaecho = false;
					break;
				}
			}
			if(isTaecho) {
				time =-1;
				break;
			}
			time++;
			
		}
		System.out.println(time);
		
	}

}
