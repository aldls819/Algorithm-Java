package hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_9229 {
	
	/*
	 * 과자 두 봉지 구매 M 그램 초과하지 않는 선에서
	 * 과자 두 봉지의 최대 무게 합을 구하는 문제
	 * 과자는 무조건 두봉지를 삼
	 * 그리디? -> N 봉지 중 두개를 뽑는다 순서 상관 없음
	 * 조합 + M 초과 안 되는 조건을 줘보자
	 */
	
	static int T; //테스트케이스
	static int N, M;// 과자의 개수, 가능한 최대 무게
	static int [] arr; //과자 배열
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			arr = new int [N];
			
			//과자 무게 입력받기
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			//오름차순으로 정렬해서
			//앞에서부터 하나씩 넣어보면서 무게 초과하지 않는
			//최대값을 구하자
			Arrays.sort(arr);
			
			//과자무게 합
			int sum = 0;
			//최종 출력값
			int res = -1;
			
			
			//앞에서부터 연속된 두개를 고를때
			//이중for문의 범위 설정을 잘 알아두면 유용하다
			for(int i=0; i<N-1; i++) {
				for(int j=i+1; j<N; j++) {
					sum = arr[i] + arr[j];
					if(sum <= M) {
						res = Math.max(res, sum);
					}
				}
			}
			
			System.out.println("#"+tc+" "+res);
			
		}

	}
	


}
