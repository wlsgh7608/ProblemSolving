import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int result=0;
	static HashSet<Shark> hs;
	static HashMap<int[], List<Shark>> hm;
	static int R;
	static int C;
	static int[] dx = { -1, 0, 0, 1 }; // 상 우 좌 하
	static int[] dy = { 0, 1, -1, 0 }; // 상 우 좌 하

	static class Shark {
		int x;
		int y;
		int s;
		int d;
		int z;

		public Shark(int x, int y, int s, int d, int z) {
			this.x = x;
			this.y = y;
			this.s = s;
			this.d = d;
			this.z = z;
		}

		@Override
		public String toString() {
			return "Shark [x=" + x + ", y=" + y + ", s=" + s + ", d=" + d + ", z=" + z + "]";
		}
		
		

	}

	static void fishing(int loc) {
		int dist = Integer.MAX_VALUE;
		Shark fish = null;

		for (Shark shark : hs) {
			if (shark.y == loc && shark.x < dist) {
				fish = shark;
				dist = shark.x;
			}

		}
		

		if (fish != null) {
			result += fish.z;
			hs.remove(fish);
		}
	}

	static void move() {
		HashSet<Shark> newHs = new HashSet<>();
		HashMap<String, Shark> hm = new HashMap<>();
		int dist;
		for (Shark shark : hs) {
			int sx = shark.x;
			int sy = shark.y;
			int sd = shark.d;
			boolean isUpDown = false;
			if (shark.d == 1 || shark.d == 2) {
				dist = C;
			} else {
				dist = R;
				isUpDown = true;
			}
			int speed = shark.s;
			if (dist > 1) {
				speed = (speed) % (2 * (dist - 1));
				// 상어의 방향을 알아야 함..........
				for (int t = 0; t < speed; t++) {
					sx = sx + dx[sd];
					sy = sy + dy[sd];
					if (isUpDown) {
						if (sx < 0 || sx >= R ) {
							sx -= 2*dx[sd];
							sy -= 2*dy[sd];
							sd = 3 - sd; // 방향
						}
					} else {
						if (sy <0 || sy >=C) {
							sx -= 2*dx[sd];
							sy -= 2*dy[sd];
							sd = 3 - sd; // 방향
						}
						
					}
				}
			}
			if (hm.containsKey(sx+" "+ sy)) {
				if (shark.z > hm.get(sx+" "+ sy).z) {
					hm.put(sx+" "+ sy, new Shark(sx, sy, speed, sd, shark.z));
				}

			} else {
				hm.put(sx+" "+ sy, new Shark(sx, sy, speed, sd, shark.z));
			}

		} // end for
		for (Shark s : hm.values()) {
			newHs.add(s);
		}
		hs = newHs;

	}


	public static void main(String[] args) throws Exception {
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(1, 0);
		map.put(2, 3);
		map.put(3, 1);
		map.put(4, 2);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		hs = new HashSet<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			hs.add(new Shark(r - 1, c - 1, s, map.get(d), z));
		}
		int fisher = 0;
		while (fisher<C) {
			fishing(fisher);
			move();
			fisher++;
		}
		System.out.println(result);

	}

}

