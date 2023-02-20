package hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2563_색종이 {
	
	/*
	 * 100 * 100 도화지 안에 검은색 색종이 붙임
	 * 색종이의 크기는 10 * 10
	 * 총 검은 영역의 넓이를 구하기
	 * 주어진 입력은 검은색 색종이의 왼쪽 아래 꼭지점의 좌표를 줌
	 */
	
	static int N; //색종이 수
	static int [][] sketch; //스케치북
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		//100*100 크기의 스케치북 배열을 생성
		sketch = new int [100][100];
		
		//스케치북 넓이 변수
		int res = 0;
		
		//색종이의 한변의 길이가 10 이므로 
		//주어진 좌표 + 10까지의 반복을 돌면서
		//1로 바꾸고 마지막에 다시 한번 배열 돌면서
		//1의 개수를 세어주면 색종이의 넓이를 구할 수 있다!
		
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			//입력받은 x, y 값 기준으로 다시 크기만큼 반복 돌면서
			//그 칸을 1로 바꾸자
			for(int a=x; a<x+10; a++) {
				for(int b=y; b<y+10; b++) {
					sketch[a][b] = 1;
				}
			}
		}
		
		//반복을 다 돌면
		//다시 완전탐색 하면서 1의 개수를 세어주자
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(sketch[i][j] == 1) {
					res++;
				}
			}
		}
		
		System.out.println(res);

	}

}
