package section_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_미로의최단거리통로 {
	
	/*
	 *  7*7 격자판 미로 탈출 최단경로 길이 출력
	 *  BFS 사용하는 문제
	 *  출발점 0,0 도착점 6,6 (배열 인덱스 기준)
	 *  0인 곳만 움직일 수 있음
	 */
	
	static int [][] arr; //미로배열
	static int [][] dis; //거리를 누적해 줄 배열
	//4방탐색
	static int [] dx = {1, 0, -1, 0};
	static int [] dy = {0, 1, 0, -1};
	static int ans; //결과값

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		arr = new int [7][7];
		dis = new int [7][7];
		ans = 0;
		
		//배열 값 입력받기
		for(int i=0; i<7; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<7; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs(0, 0);
		//만약에 도착점에 도달 못 했다면 dis(6,6)의 값이 0일거임
		if(dis[6][6] == 0) {
			System.out.println(-1);
		} else {
			System.out.println(dis[6][6]);
		}
		

	}
	
	//BFS 구현
	//큐를 생성해서 시작점을 넣고
	//4방탐색을 돌리면서
	//가능한 범위 내에 있는 애들로 나아가기
	public static void bfs(int x, int y) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		//x y 좌표를 순서대로 큐에 넣어주고
		queue.add(x);
		queue.add(y);
		
		//시작점 들렸다는 표시
		arr[x][y] = 1;
		
		//큐가 빌때까지 반복 돌리기
		while(!queue.isEmpty()) {
			int temp_x = queue.poll();
			int temp_y = queue.poll();
			//4방탐색 하면서 범위 안에 있는지 보자
			for(int idx = 0; idx < 4; idx++) {
				int nx = temp_x + dx[idx];
				int ny = temp_y + dy[idx];
				if(nx >= 0 && nx < 7 && ny >= 0 && ny < 7 && arr[nx][ny] == 0) {
					//방문표시
					arr[nx][ny] = 1;
					queue.add(nx);
					queue.add(ny);
					//bfs로 여러경로 동시에 뻗어나가면서
					//거리를 누적해서 dis라는 배열에 더하자
					dis[nx][ny] = dis[temp_x][temp_y]+1;
				}
				
			}
		}
		
	}

}
