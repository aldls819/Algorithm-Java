import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2667_단지 {

	/*
	 * 집 있는 것 1 없는 것 0 연결된 애들 몇갠지 세는 문제 4방탐색 총 단지 수 출력 후 각 단지내 집의 수를 오름차순으로 정렬
	 */
	
	//총 단지수 즉 cnt 출력
	//각 단지내 집의 개수 오름차순 출력

	static int N; // 지도크기
	static int[][] arr; // 지도배열
	static boolean[][] visited; // 방문확인배열
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static List<Integer> list;
	static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 초기화 작업
		N = Integer.parseInt(br.readLine());
		//띄어쓰기 없이 한줄로 입력 받기 때문에
		//중간에서 끊어줘야함
		String s = "";
		
		arr = new int[N][N];
		visited = new boolean[N][N];
		list = new ArrayList<>();
		cnt = 0; //아파트 개수

		
		// 배열 값 입력
		for (int i = 0; i < N; i++) {
			s = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = (int) s.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 집이고 방문한 적 없다면
				if (arr[i][j] == 1 && visited[i][j] == false) {
					bfs(i, j);
					list.add(cnt);
					cnt = 0;
				}
			}
		}
		//bfs 다 돌고 오름차순 정렬
		Collections.sort(list);
		
		System.out.println(list.size());
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}

	}

	public static void bfs(int x, int y) {
		Queue<Integer> q = new LinkedList<>();

		// 현재의 x, y 좌표 q에 추가
		q.add(x);
		q.add(y);
		cnt++;
		visited[x][y] = true;

		//큐가 비어있지 않을 떄까지
		while (!q.isEmpty()) {
			
			int curX = q.poll();
			int curY = q.poll();
//			System.out.println(curX+ " " +curY);
//			System.out.println();
			//4방탐색해서 조건에 맞으면
			//큐에 넣고 돌리기
			for (int idx = 0; idx < 4; idx++) {
				int nx = curX + dx[idx];
				int ny = curY + dy[idx];
				if (nx >= 0 && nx < N && ny >= 0 && ny < N && arr[nx][ny] == 1 && visited[nx][ny] == false) {
					q.add(nx);
					q.add(ny);
					visited[nx][ny] = true;
					cnt++;
				}
			}
		}
		

	}

}
