import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] A;
	static int[] B;
	static int N;
	static int M;
	
	static List<Long> a_list;
	static List<Long> b_list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i<N;i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		M = Integer.parseInt(br.readLine());
		B = new int[M];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i<M;i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		a_list = new ArrayList<>();
		b_list = new ArrayList<>();
		
		long result= 0;
		
		for(int i = 0; i <N;i++) {
			long s = 0;
			for(int j = i; j<N;j++) {
				s+=A[j];
				a_list.add(s);
			}
		}
		
		for(int i = 0; i <M;i++) {
			long s = 0;
			for(int j = i; j<M;j++) {
				s+=B[j];
				b_list.add(s);
			}
		}
		
		Collections.sort(a_list);
		Collections.sort(b_list);
		
		
		for(long a : a_list) {
			int lo = 0;
			int hi = b_list.size()-1;
			
			
			//upper bound
			while(lo<=hi) {
				int m = (lo+hi)/2;
				if(b_list.get(m) + a <=T) {
					lo = m+1;
				}else {
					hi = m-1;
				}
			}
			int upper = lo;
			
			lo = 0;
			hi = b_list.size()-1;
			
			
			//lower bound
			while(lo<=hi) {
				int m = (lo+hi)/2;
				if(b_list.get(m) + a <T) {
					lo = m+1;
				}else {
					hi = m-1;
				}
			}
			
			int lower = lo;
			result += upper-lower;
			
		}
		System.out.println(result);
		
		
		
		
		
	}

}
