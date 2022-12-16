import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static long[] arr;
	static long[] trees;
	static int N;
	static long init(int treeN,int start,int end) {
		if (start== end) {
			return trees[treeN] = arr[start];
		}
		int m = (start+end)/2;
		long left = init(treeN*2,start,m);
		long right = init(treeN*2+1,m+1,end);
		return trees[treeN] = left+right;
	}
	
	static long query(int ql,int qr,int idx,int cl,int cr) {
		if(qr<cl|| ql>cr) {
			return 0;
		}
		if(ql<=cl && cr<=qr) {
			return trees[idx];
		}
		int m = (cl+cr)/2;
		long left = query(ql,qr,idx*2,cl,m);
		long right = query(ql,qr,idx*2+1,m+1,cr);
		return left+right;
	}
	
	static long update(int ui,int uv,int idx ,int cl ,int cr) {
		if(cl>ui|| cr<ui) {
			return trees[idx];
		}
		if(cl==ui && cr == ui) {
			return trees[idx] = uv;
		}
		
		int m = (cl+cr)/2;
		
		long left = update(ui, uv, 2*idx, cl, m);
		long right = update(ui, uv, 2*idx+1, m+1, cr);
		
		return trees[idx] = left+right;
	}
	
	
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		arr = new long[N];
		trees = new long[4*N];
		for(int i = 0; i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		init(1,0,N-1);
		
		for(int i = 0; i<Q;i++) {
			st = new StringTokenizer(br.readLine());
			int ql = Integer.parseInt(st.nextToken())-1;
			int qr = Integer.parseInt(st.nextToken())-1;
			int ui = Integer.parseInt(st.nextToken())-1;
			int uv = Integer.parseInt(st.nextToken());
			if(ql>qr) {
				int temp = ql;
				ql = qr;
				qr = temp;
			}
			long ans = query(ql, qr, 1, 0, N-1);
			sb.append(ans).append("\n");
			update(ui, uv, 1, 0, N-1);
		}
		System.out.println(sb);
		
		
	}

}
