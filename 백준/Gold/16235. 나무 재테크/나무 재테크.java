import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int K;
	static int[][] G;
	static int[][] nut;

	static int[] dx = { -1, -1, 1, 1, 0, -1, 0, 1 };
	static int[] dy = { 1, -1, 1, -1, -1, 0, 1, 0 };

	static List<Integer>[][] trees;

	static void spr_sum() {
		List<Integer> newTree;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				newTree = new ArrayList<>();
				Collections.sort(trees[i][j]);
				int idx = trees[i][j].size();
				for (int k = 0; k < trees[i][j].size(); k++) {
					int t = trees[i][j].get(k);
					if (t <= G[i][j]) {
						newTree.add(t + 1);
						G[i][j] -= t;
					} else {
						idx = k;
						break;
					}
				}

				for (int k = idx; k < trees[i][j].size(); k++) {
					G[i][j] += (trees[i][j].get(k) / 2);
				}
				
				trees[i][j] = newTree;
			}
			
		}
	}

	static void fall() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int t : trees[i][j]) {
					if (t % 5 == 0) {
						for (int k = 0; k < dx.length; k++) {
							int nx = i + dx[k];
							int ny = j + dy[k];

							if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
								continue;
							}
							trees[nx][ny].add(1);
						}
					}
				}
			}
		}

	}

	static void winter() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				G[i][j] += nut[i][j];
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		trees = new List[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				trees[i][j] = new ArrayList<>();
			}
		}

		nut = new int[N][N];
		G = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				nut[i][j] = Integer.parseInt(st.nextToken());
				G[i][j] = 5 ;
			}
		}
		

		for (int j = 0; j < M; j++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			trees[x-1][y-1].add(z);
		}
		

		for (int t = 0; t < K; t++) {
			spr_sum();
			fall();
			winter();
		}
		
		
		int result = 0;
		for(int i  =0;i<N;i++) {
			for(int j = 0;j<N;j++) {
				result+=trees[i][j].size();
			}

		}

		System.out.println(result);
	}

}
