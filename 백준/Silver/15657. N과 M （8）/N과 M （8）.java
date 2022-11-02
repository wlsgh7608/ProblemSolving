
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	
	static void comb(int start,int depth) {
		if(depth==M) {
			for(int n: box) {
				sb.append(n+" ");
			}
			sb.append("\n");
			return;
		}
		if(start==N) {
			return;
		}
		
		box[depth] =  arr[start];
		comb(start,depth+1);
		comb(start+1,depth);
		
		
	}
	
	static int[] arr ;
	static int[] box;
	static int N;
	static int M;
	
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		M = Integer.parseInt(st.nextToken());
		box = new int[M];
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		Arrays.sort(arr);
		
		comb(0,0);
		System.out.println(sb);
		
	}

}
