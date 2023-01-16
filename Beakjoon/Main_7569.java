package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7569 {
	
	/*
	 * 상자를 수직으로 쌓아 올려서 창고에 보관
	 * 익은 토마토는 4방 + 위 + 아래의
	 * 안 익은 토마토들을 익힐 수 있음
	 * 토마토가 모두 익는 최소 일수 구하는 문제 -> bfs
	 * 3차원 배열 처음 써봐
	 * dx, dy에 dz를 추가하자
	 * 익은 토마토 1 안 익은 토마토 0 아무것도 없는 곳 -1
	 */
	
	//4방 탐색에 +z 축이 생겼다고 생각하기
	
	static int [][][] arr; //토마토 상자 배열
	static int [] dx = {0, 1, 0, -1, 0, 0}; //가로 탐색
	static int [] dy = {1, 0, -1, 0, 0, 0}; //세로 탐색
	static int [] dz = {0, 0, 0, 0, -1, 1}; //z축 탐색
	static int N, M, H; //가로, 세로, 높이
	static int res; //결과값
	static boolean flag;
	static Queue<Integer> q;
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//입력은 M부터 준다 조심하자
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		res = Integer.MIN_VALUE; //최소 일수 구해야 하니까 최대값으로 초기화
		flag = false;
		q = new LinkedList<>();
		
		//배열 크기 초기화
		arr = new int [H][N][M];
		
		//삼중 for문 돌면서 배열에 값을 넣어주자
		for(int i=0; i<H; i++) {
			for(int j=0; j<N; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0; k<M; k++) {
					arr[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		
		//익은 토마토가 여러개라면
		//여러 군데에서 주변 토마토를 익혀 나가기 때문에
		//익은 토마토가 있는 위치들을 모두 큐에 넣어주고
		//bfs를 한꺼번에 돌려야 한다
		for(int i=0; i<H; i++) {
			for(int j=0; j<N; j++) {
				for(int k=0; k<M; k++) {
					//익은 토마토를 bfs에 넣자
					if(arr[i][j][k] == 1) {
						q.offer(i);
						q.offer(j);
						q.offer(k);
					}
				}
			}
		}
		
		bfs();
		
		//안 익은 토마토가 있는 경우
		if(flag) {
			System.out.println(-1);
		}
		//res가 1이라는 것은
		//처음부터 모든 토마토가 익어있었다는 뜻
		else if(res == 1) {
			System.out.println(0);
		}
		//시작날부터 더해져있기 때문에
		//-1을 해줘야 함
		else {
			System.out.println(res-1);
		}

	}
	
	public static int bfs() {
		
		//큐가 빌 때까지 while문 수행
		while(!q.isEmpty()) {
			
			int curZ = q.poll();
			int curX = q.poll();
			int curY = q.poll();
			
			//주변 탐색 시직
			for(int idx=0; idx<6; idx++) {
				int nz = curZ + dz[idx];
				int nx = curX + dx[idx];
				int ny = curY + dy[idx];
				
				//범위 확인
				if(nx >= 0 && nx < N && ny >= 0 && ny < M && nz >= 0 && nz < H) {
					//안 익은 토마토라면
					if(arr[nz][nx][ny] == 0) {
						//기존 토마토에 +1을 해주면
						//bfs가 끝난 후 날짜 세기가 쉬워진다
						arr[nz][nx][ny] = arr[curZ][curX][curY]+1;
						//큐에 다시 넣어준다
						q.offer(nz);
						q.offer(nx);
						q.offer(ny);
					}
				}
			}
		}
		
		for(int i=0; i<H; i++) {
			for(int j=0; j<N; j++) {
				for(int k=0; k<M; k++) {
					//0이 있으면 다 못 익었다는 뜻
					//출력할 때 쉽게 구별하기 위해서
					//flag 변수로 true 값을 주자
					if(arr[i][j][k] == 0) {
						flag = true;
					}
					
					else {
						res = Math.max(res, arr[i][j][k]);
					}
				}
			}
		}
		return res;
	}

}
