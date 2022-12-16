package hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2001 {

	/*
	 * N*N 배열에서 
	 * M*M 크기의 파리채로 
	 * 파리를 죽이는데 
	 * 최대한 많은 파리를 죽여야함 
	 * 완전탐색으로 배열 전체를 돌면서 
	 * 최대값을 갱신해주면
	 * 되는 문제일듯?
	 */

	static int T;// 테스트 케이스
	static int N; // 배열크기
	static int M; // 파리채크기
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			// 크기 입력 받기
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			arr = new int[N][N];

			// 배열에 값 입력 받기
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 결과값 변수
			int res = 0;

			//0,0 에서부터 시작해서 옮겨다녀야함
			//어떻게 구현하지?
			//그림 그려서 생각해보면 쉽네
			//파리채 시작 위치 이동 for문
			for(int i=0; i<N-M+1; i++) {
				for(int j=0; j<N-M+1; j++) {
					int sum = 0;
					//죽일 수 있는 파리의 수를 더해줄 for문
					for(int a = 0; a<M; a++) {
						for(int b=0; b<M; b++) {
							sum += arr[i+a][j+b];
						}
					}
					
					res = Math.max(res, sum);
				}
			}
			
			System.out.println("#"+tc+" "+res);
			
		}

	}
}
