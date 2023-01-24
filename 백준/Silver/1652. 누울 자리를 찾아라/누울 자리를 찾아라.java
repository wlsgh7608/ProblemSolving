import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] G = new char[N][N];
		for(int i = 0; i<N;i++) {
			G[i] = br.readLine().toCharArray();
		}
		
		int row = 0;
		for(int i = 0; i<N;i++) {
			boolean isNew = true;
			for(int j =1;j<N;j++) {
				if (G[i][j] == '.' && G[i][j-1]=='.'&&isNew) {
					row++;
					isNew = false;
				}
				if(G[i][j] =='X') {
					isNew = true;
				}
				
			}
		}
		
		
		int col = 0;
		for(int j = 0; j<N;j++) {
			boolean isNew = true;
			for(int i =1;i<N;i++) {
				if (G[i][j] == '.' && G[i-1][j]=='.'&&isNew) {
					col++;
					isNew = false;
				}
				if(G[i][j] =='X') {
					isNew = true;
				}
				
			}
		}
		System.out.println(row+" "+col);
		
		
		
	}

}
