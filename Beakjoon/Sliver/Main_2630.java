package sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2630 {
	
	/*
	 * 분할정복, 재귀 문제
	 * 분할정복 단계
	 * 1. 현재 상태의 문제를 풀 수 없으면 분할 가능한지 확인
	 * 2. 문제를 작게 분할하여 풀이
	 * 3. 풀린 문제 합치기
	 */
	
	//부분 색종이는 모두 같은 색상
	//같은 색상이 아니라면 색종이를 절반씩 잘라서 같은 색이 될 떄까지
	
	static int N; //배열 크기
	static int [][] arr; //색종이 배열
	static int white; //하얀색 카운트 변수
	static int blue; //파란색 카운트 변수

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//변수 초기화
		N = Integer.parseInt(br.readLine());
		arr = new int [N][N];
		white = 0;
		blue = 0;
		
		//배열 값 입력
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//하얀색과 파란색의 색종이가 몇장인지 출력해야함
		
		partition(0, 0, N);
		
		System.out.println(white);
		System.out.println(blue);

	}
	
	//분할정복 메소드
	public static void partition(int row, int col, int size) {
		
		//기저조건
		//색 확인
		if(colorCheck(row, col, size)) {
			//모든 색이 동일하다면
			//하얀색인지 파란색인지 확인
			if(arr[row][col] == 0) {
				white++;
			}
			else {
				blue++;
			}
			return;
		}
		
		
		//N/2씩 작아짐
		int newSize = size/2; //절반
		//재귀호출
		partition(row, col, newSize); //2사분면
		partition(row, col+newSize, newSize); //1사분면
		partition(row+newSize, col, newSize); //3사분면
		partition(row+newSize, col+newSize, newSize); //4사분면
	}
	
	//같은 색인지 확인하는 메소드
	public static boolean colorCheck(int row, int col, int size) {
		
		//첫번째 칸부터 색 확인
		int color = arr[row][col];
		
		//정해진 사이즈만큼의 크기를 돌면서
		//첫번째 칸의 색과 다르면 바로 false return
		//끝까지 다 돌고 나면 true return
		for(int i=row; i<row+size; i++) {
			for(int j=col; j<col+size; j++) {
				if(arr[i][j] != color) {
					return false;
				}
			}
		}
		return true;
	}

}
