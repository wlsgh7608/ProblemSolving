import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static void noBlock(int x, int y) { // 맵에 아무런 블록이 없을 때 실행하는 메소드
		int cnt = 0; // cnt변수 0으로 초기화
		if (x > 0) {// 행이 0보다 크다면
			if (G[x - 1][y] == 'M' || G[x - 1][y] == 'Z') { // 만약 시작이거나 끝인경우
				cnt++; // cnt+1
			}
		}
		if (y > 0) {// 열이 0보다 크다면
			if (G[x][y - 1] == 'M' || G[x][y - 1] == 'Z') { // 만약 시작이거나 끝인경우
				cnt++;// cnt+1
			}
		}
		if (x < R - 1) {// 행이 R-1보다 작다면
			if (G[x + 1][y] == 'M' || G[x + 1][y] == 'Z') { // 만약 시작이거나 끝인경우
				cnt++;// cnt+1
			}
		}
		if (y < C - 1) {// 열이 C-1보다 작다면
			if (G[x][y + 1] == 'M' || G[x][y + 1] == 'Z') { // 만약 시작이거나 끝인경우
				cnt++;// cnt+1
			}
		}

		if (cnt == 2) { // cnt값이 2라면
			ansX = x; // 블록 위치 x저장
			ansY = y;// 블록 위치 y저장

		}

	}

	static char makeBlock(int x, int y) { // 없어진 블록을 채우는 함수
		boolean up = false; // 해당 블록 위 블록이 이동할 수 없는 블록인지 체크
		boolean down = false; // 해당 블록 아래 블록이 이동할 수 없는 블록인지 체크
		boolean left = false; // 해당 블록 왼쪽 블록이 이동할 수 없는 블록인지 체크
		boolean right = false; // 해당 블록 오른쪽 블록이 이동할 수 없는 블록인지 체크
		if (x > 0) { // 행이 0보다 크다면
			if (isNeed[x - 1][y])
				up = true; // 만약 위쪽블록이 이동할 수 없으면 up = true;
		}
		if (y > 0) { // 열이 0보다 크다면
			if (isNeed[x][y - 1])
				left = true; // 만약 왼쪽 블록이 이동할 수없다면 left = true;
		}
		if (x < R - 1) { // 행이 R-1보다 작다면
			if (isNeed[x + 1][y])
				down = true;// 만약 아래쪽블록이 이동할 수 없으면 down = true;
		}
		if (y < C - 1) {// 열이 C-1보다 작다면
			if (isNeed[x][y + 1])
				right = true;// 만약 오른쪽 블록이 이동할 수없다면 right = true;
		}

		if (up && down && left && right) { // 상하좌우 모두 이동할 수없으면
			return '+'; // + 리턴
		} else if (up && down) { // 상하만 이동할 수 없다면
			return '|'; // |리턴
		} else if (left && right) { // 좌우만 이동할 수 없다면
			return '-'; // - 리턴
		} else if (down && right) {// 아래 오른쪽만 이동할수 없다면
			return '1'; // 1리턴
		} else if (up && right) { // 위 오른쪽만 이동할 수 없다면
			return '2';// 2리턴
		} else if (up && left) {// 위 왼쪽만 리턴할 수 없다면
			return '3';// 3리턴
		} else if (left && down) {// 왼,아래만 이동할 수 없다면
			return '4';// 4리턴
		}
		return '.'; // default값 리턴

	}

	static boolean isBlank(int x, int y) { // 해당 값이 빈칸인지 체크하는 함수
		if (x < 0 || y < 0 || x >= R || y >= C) { // 범위를 벗어난다면
			return false; // false리턴
		}

		if (G[x][y] == '.') { // 해당값이 빈칸이라면
			ansX = x; // ansX값에 x값 저장
			ansY = y; // ansY값에 y값 저장
			return true;// true리턴
		} else if (G[x][y] == 'M' || G[x][y] == 'Z') // 만약 시작,끝값이라면
			return false; // true
		return false;// 그 외 경우 false리턴
	}

	static void isPossible(int x, int y) { /* 해당 블록에 대하여 만족하는지 체크 */
		char c = G[x][y]; // 현재 블록의 값

		switch (c) { // 스위치를 이용하여 조건찾기
		case '|': // 만약 | 라면 ( 상, 하)에 대하여 체크
			if (isBlank(x - 1, y))
				isNeed[x][y] = true; // 위쪽이 빈칸일경우 isNeed 값 true
			if (isBlank(x + 1, y))
				isNeed[x][y] = true; // 아래쪽이 빈칸일경우 isNeed 값 true
			break; // switch 빠져나옴
		case '-': // 만약 - 라면 (좌,우)에 대하여 체크
			if (isBlank(x, y - 1))
				isNeed[x][y] = true; // 왼쪽이 빈칸일경우 isNeed 값 true
			if (isBlank(x, y + 1))
				isNeed[x][y] = true; // 오른쪽이 빈칸일경우 isNeed 값 true
			break; // switch 빠져나옴
		case '+':// 만약 + 라면 (좌,우)에 대하여 체크
			if (isBlank(x, y - 1))
				isNeed[x][y] = true;// 왼쪽이 빈칸일경우 isNeed 값 true
			if (isBlank(x, y + 1))
				isNeed[x][y] = true;// 오른쪽이 빈칸일경우 isNeed 값 true
			if (isBlank(x - 1, y))
				isNeed[x][y] = true;// 위쪽이 빈칸일경우 isNeed 값 true
			if (isBlank(x + 1, y))
				isNeed[x][y] = true; // 아래쪽이 빈칸일경우 isNeed 값 true
			break; // switch 빠져나옴
		case '1':// 만약 1이라면 (하,우)에 대하여 체크
			if (isBlank(x, y + 1))
				isNeed[x][y] = true;// 오른쪽이 빈칸일경우 isNeed 값 true
			if (isBlank(x + 1, y))
				isNeed[x][y] = true; // 아래쪽이 빈칸일경우 isNeed 값 true
			break; // switch 빠져나옴
		case '2': // 만약2라면 (상,우)에 대하여 체크
			if (isBlank(x, y + 1))
				isNeed[x][y] = true;// 오른쪽이 빈칸일경우 isNeed 값 true
			if (isBlank(x - 1, y))
				isNeed[x][y] = true;// 위쪽이 빈칸일경우 isNeed 값 true
			break; // switch 빠져나옴
		case '3': // 만약 3이라면 (좌,상)에 대하여 체크
			if (isBlank(x, y - 1))
				isNeed[x][y] = true;// 왼쪽이 빈칸일경우 isNeed 값 true
			if (isBlank(x - 1, y))
				isNeed[x][y] = true;// 위쪽이 빈칸일경우 isNeed 값 true
			break; // switch 빠져나옴
		case '4': // 만약 4라면 (좌,하)에 체크
			if (isBlank(x, y - 1))
				isNeed[x][y] = true;// 왼쪽이 빈칸일경우 isNeed 값 true
			if (isBlank(x + 1, y))
				isNeed[x][y] = true; // 아래쪽이 빈칸일경우 isNeed 값 true
			break; // switch 빠져나옴
		}

	}

	static char[][] G; // 2차원 그래프정보 저장
	static boolean[][] isNeed; // 이동할 수 없는 블록을 나타내는 2차원 boolean 배열
	static int ansX; // 없어진 블록의 x위치
	static int ansY; // 없어진 블록의 y위치
	static int R; // 행
	static int C; // 열

	public static void main(String[] args) throws Exception { // 메인 함수 실행
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // BufferedReader을 통하여 입력받음
		StringBuilder sb = new StringBuilder(); // 결과출력을 위한 StringBuilder
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");// 한 줄을 공백을 기준으로 나눔
			R = Integer.parseInt(st.nextToken()); // 나눈 값 R : 행
			C = Integer.parseInt(st.nextToken()); // 나눈 값 C : 열
			G = new char[R][C]; // 2차원 char 배열 생성
			isNeed = new boolean[R][C]; // 2차원 boolean 배열 생성
			ansX = -1; // 없어진 블록의 x위치
			ansY = -1; // 없어진 블록의 y위치

			/* 그래프에 값 저장하기 */
			for (int i = 0; i < R; i++) { // 행만큼 반복
				String row = br.readLine(); // 한줄을 입력받아서
				for (int j = 0; j < C; j++) { // 열만큼 반복
					G[i][j] = row.charAt(j); // 그래프 G[i][j]값에 저장
				}
			}

			/* 블록에 대하여 이동할 수 있는 지 찾기 */
			for (int i = 0; i < R; i++) { // 행만큼 반복
				for (int j = 0; j < C; j++) { // 열만큼 반복
					if (G[i][j] != 'Z' || G[i][j] != 'M' || G[i][j] != '.') { // 만약 해당칸이 블록이라면
						isPossible(i, j); // isPossible 함수 실행
					}
				}
			}

			if (ansX == -1 && ansY == -1) { // 없어지 블록을 못찾은 경우
				for (int i = 0; i < R; i++) { //행 만큼 반복
					for (int j = 0; j < C; j++) { //열만큼 반복
						noBlock(i, j);//함수실행

					}
				}
			}
			
			System.out.println((ansX + 1) + " " + (ansY + 1) + " " + makeBlock(ansX, ansY)); // 결과값
																													// sb에
																													// 저장

	}

}


