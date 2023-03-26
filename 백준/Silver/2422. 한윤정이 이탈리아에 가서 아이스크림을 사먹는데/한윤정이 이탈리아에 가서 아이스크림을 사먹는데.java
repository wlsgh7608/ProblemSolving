import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[][] isM = new boolean[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			isM[a][b] = true;
			isM[b][a] = true;
		}
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = i + 1; j <= N; j++) {
				if (isM[j][i]) {
					continue;
				}
				for (int k = j + 1; k <= N; k++) {
					if (isM[k][i] || isM[k][j]) {
						continue;
					}
					cnt++;
				}
			}
		}
		System.out.println(cnt);

	}
}
