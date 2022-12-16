package hw;

import java.util.Scanner;

public class Solution_1954 {
	
	/*
	 * 시계방향으로 배열을 돌면서
	 * 1부터 숫자를 채워나가는 문제
	 * 4방탐색과 범위지정만 잘 해주면
	 * 그닥 어렵지 않은 문제일지도?
	 */
	
	static int N; //배열 크기
	static int [][] arr; //달팽이 배열
	//4방탐색은 시계방향 오른쪽 -> 아래쪽 -> 왼쪽 -> 위쪽 순서
	static int [] dx = {0, 1, 0, -1};
	static int [] dy = {1, 0, -1, 0};
	//한 방향으로 순서대로 나아가다가 경계를 만나면 방향을 바꾸어야 함
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		
		for(int tc =1; tc<=T; tc++) {
			N = sc.nextInt();
			
			//크기에 맞게 배열 생성
			arr = new int [N][N];
			
			//0,0 부터 시작해서 채워나가자
			int x = 0;
			int y = 0;
			//4방탐색 기준 변수
			int idx = 0;
			
			//숫자 채우기 시작!
			for(int i=1; i<= N*N; i++) {
				arr[x][y] = i;
				
				x += dx[idx];
				y += dy[idx];
				
				//범위체크
				//주어진 범위를 벗어나거나 이미 다른 숫자가 채워져있다면
				if(x < 0 || y < 0 || x >= N || y >= N || arr[x][y] != 0) {
					//이전 좌표로 돌아가고
					x -= dx[idx];
					y -= dy[idx];
					
					//방향을 바꿔주자
					idx = (idx + 1) % 4;
					
					//바뀐 방향으로 다시 나가자
					x += dx[idx];
					y += dy[idx];
				}
			}
			
			sb.append("#").append(tc).append("\n");
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					sb.append(arr[i][j] + " ");
				}
				sb.append("\n");
			}
			
		}
		System.out.println(sb);

	}

}
