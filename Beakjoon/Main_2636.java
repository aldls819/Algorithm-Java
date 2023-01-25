package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2636 {

	/*
	 * 공기와 닿아있는 치즈는 한시간 간격으로 녹음 치즈 내부의 0은 치즈를 녹이지 못 함 치즈가 모두 녹는데 걸린 시간 + 다 녹기 한시간 전
	 * 치즈의 개수 출력
	 */

	// 바깥쪽 공기와 닿아있는 치즈들만 녹음 ->
	// 안쪽과 바깥쪽 공기를 구분하기 어려움 그럼 반대로
	// 공기를 기준으로 dfs를 돌려서
	// 공기 기준으로 4방 탐색해서 있는 치즈들을 녹여주자

	static int N, M; // 가로 세로
	static int[][] arr; // 치즈 배열
	static boolean[][] visited; // 방문처리 배열
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int cheeseCnt;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 전역변수 초기화
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		visited = new boolean[N][M];

		// 배열 채우기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// dfs를 돌면서 공기와 닿은 치즈들을 2로 바꾼다
		// 치즈를 녹이는 메소드를 실행해서
		// 다 녹으면 true를 return하고 종료한다

		int timeCnt;
		// for문 안에서 조건문으로 boolean 메소드를 주면
		// false가 될 때까지 반복을 실행함 -> 기억해두자
		for (timeCnt = 0; checkCheese(); timeCnt++) {
			
			for(boolean[] xxx : visited) {
				Arrays.fill(xxx, false);
			}
			// 판 테두리는 무조건 공기
			visited[0][0] = true;
			cheeseCnt = 0;

			dfs(0, 0);
		}

		System.out.println(timeCnt);
		System.out.println(cheeseCnt);
	}

	public static void dfs(int x, int y) {
		// 4방탐색해서 주변에 치즈가 있는지 확인한다
		for (int idx = 0; idx < 4; idx++) {
			int nx = x + dx[idx];
			int ny = y + dy[idx];

			// 범위 체크
			if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
				// 방문하지 않았고 치즈라면 2로 표시해준다
				// 나중에 한꺼번에 녹여주기 위함
				if (!visited[nx][ny]) {
					visited[nx][ny] = true;
					if (arr[nx][ny] == 1) {
						arr[nx][ny] = 2;
						cheeseCnt++;
					}
					// 그렇지 않다면 재귀 실행
					else {
						dfs(nx, ny);
					}
				}
			}
		}

	}

	// 배열을 돌면서 치즈를 녹이고
	// 남은 치즈가 있는지 확인하자
	public static boolean checkCheese() {
		// dfs에서 2로 바꿔준 애들을
		// 한꺼번에 0으로 바꿔준다
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 2) {
					arr[i][j] = 0;
				}
			}
		}

		// 치즈를 녹이고 나서는 남은 치즈가 있는지 확인한다
		// 치즈가 남아있으면 true를 return
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 1) {
					return true;
				}
			}
		}
		// 다 녹으면 false
		return false;
	}

}
