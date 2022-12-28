import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	
	static String[][] arr;
	static int N = 6;
	static HashSet<String> hs = new HashSet<>();
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	
	static void dfs(int v,int x, int y,String str) {
		if(v==N) {
			hs.add(str);
			return;
		}
		for(int d = 0; d<4;d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			
			if(nx<0 || nx>=5||ny<0||ny>=5) {
				continue;
			}
			String newStr = str+arr[nx][ny];
			dfs(v+1,nx,ny,newStr);
		}
		
		
		
		
		
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		arr = new String[5][5]; 
		for(int i = 0; i<5;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<5;j++) {
				arr[i][j]=  st.nextToken();
			}
		}

		for(int i = 0; i<5;i++) {
			for(int j = 0; j<5;j++) {
				dfs(0,i,j,"");
			}
		}
		System.out.println(hs.size());
			
		
		
		
		
		
	}

}
