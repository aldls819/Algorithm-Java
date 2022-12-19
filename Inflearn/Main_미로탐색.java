package section_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;import javax.security.auth.x500.X500Principal;

public class Main_미로탐색 {
	
	/*
	 * 7*7 배열에서 통로 0, 벽 1
	 * 0인 지점으로만 상하좌우로 움직일 수 있음
	 * 가능한 모든 경로의 개수를 구하는 문제 
	 */

	static int [][] arr; //미로배열 크기7로 고정
	static int [] dx = {1, 0, -1, 0};
	static int [] dy = {0, 1, 0, -1};
	static int ans; //결과값 변수 -> 경로의 개수
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		arr = new int [7][7];
		ans = 0;
		
		//주어진 입력값 배열에 넣기
		for(int i=0; i<7; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<7; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//시작점 1로 바꿔놓고 시작하자
		arr[0][0] = 1;
		
		dfs(0, 0);
		System.out.println(ans);
		
		

	}
	
	//출발은 무조건 0,0 도착은 무조건 6,6
	//문제에서는 1부터 7이라고 했지만
	//배열 인덱스가 0부터 시작이라 편의 상 0 ~ 6으로 맞췄음
	public static void dfs(int x, int y) {
		//기저조건은 도착지점에 왔을 때
		//즉 x = 7, y = 7 일때
		if(x == 6 && y == 6) {
			ans++;
			return;
		}
		

		
		//4방탐색 시작
		for(int idx=0; idx<4; idx++) {
			int nx = x + dx[idx];
			int ny = y + dy[idx];
			//만약 갈 수 있는 범위라면
			if(nx >= 0 && nx < 7 && ny >= 0 && ny < 7 && arr[nx][ny] == 0) {
				//이미 지나간 자리임을 표시하기 위해서
				//1로 바꿔주자
				arr[nx][ny] = 1;
				dfs(nx, ny);
				//그리고 다시 원상복구
				arr[nx][ny] = 0;
			}
		}
	}

}
