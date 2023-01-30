package sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2583_영역구하기 {

	/*
	 * 왼쪽아래 꼭지점부터 오른쪽 위 꼭지점 까지의 직사각형이 주어짐 
	 * 직사각형 넓이를 제외하고 몇개의 분리된 영역으로 나뉘는지 
	 * 나누어진 영역의 넓이를 오름차순으로 출력 
	 * 직사각형의 개수만큼 반복을 돌면서 해당 직사각형을 1로 채우자 
	 * 0인 부분이 비어있는 부분이니까 bfs를 돌려보자
	 */

	static int[][] arr; // 배열
	static int M, N, K; // 행, 열, 직사각형 개수
	static boolean[][] visited; // 방문처리
	static List<Integer> list; // 분리된 영역 저장해 줄 list
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		// 전역변수 초기화
		arr = new int[M][N];
		visited = new boolean[M][N];
		list = new ArrayList<>();

		// 일단 모든 배열에 0을 넣어주자
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = 0;
			}
		}

		// 직사각형 개수만큼 반복 돌면서 주어진 좌표값대로 배열 값 바꾸기
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			// 주어진 꼭지점대로 1을 채워주려면 y 기준으로 먼저 반복 돌아야 함
			// 직사각형 안에를 1로 채우자
			// 근데 겹치는 부분도 있으니까 배열이 0 일때 라는 조건을 추가하자
			for (int a = y1; a < y2; a++) {
				for (int b = x1; b < x2; b++) {
					if(arr[a][b] == 1) {
						continue;
					}
					if (arr[a][b] == 0) {
						arr[a][b] = 1;
					}
				}
			}
			
		}
		//현재 비어있는 부분은 0으로 되어있을거임
		//bfs 돌려보자
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j] == 0 && !visited[i][j]) {
					bfs(i, j, 0);
				}
			}
		}
		
		Collections.sort(list);
		System.out.println(list.size());
		
		for(int x : list) {
			System.out.print(x + " ");
		}

	}
	
	public static void bfs(int x, int y, int cnt) {
		Queue<Integer> queue = new LinkedList<>();
		
		//시작점 큐에 넣어주고 방문처리
		queue.offer(x);
		queue.offer(y);
		visited[x][y] = true;
		//시작점부터 영역 개수를 세어주어야 함
		cnt++;
		
		while(!queue.isEmpty()) {
			int curX = queue.poll();
			int curY = queue.poll();
			//4방 탐색
			for(int idx=0; idx<4; idx++) {
				int nx = curX + dx[idx];
				int ny = curY + dy[idx];
				//배열 범위 내에 있는지 확인
				if(nx >=0 && nx < M && ny >= 0 && ny < N) {
					//0이고 방문하지 않았는지 확인
					if(arr[nx][ny] == 0 && !visited[nx][ny]) {
						//큐에 넣어주고 방문처리 해주자
						queue.offer(nx);
						queue.offer(ny);
						visited[nx][ny] =true;
						//영역의 넓이를 세어주자
						cnt++;
					}
					
				}
			}
		}
		list.add(cnt);
	}

}
