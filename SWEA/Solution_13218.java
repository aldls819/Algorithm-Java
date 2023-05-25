package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_13218_조별과제 {
	
	//월화수 오전 9 ~ 10 시 30분 까지 진행되는 수업
	//N명의 수강생
	//한 조에 3명 이상의 학생으로 조를 구성해야 하며 구성된 조의 최댓값을 구하는 문제
	//3명을 못 채우면 버리기
	
	static int T; //테스트 케이스
	static int N; //학생의 수

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			int cnt = N / 3;
			
			System.out.println("#"+tc+" "+cnt);
		}
		
		
	}

}
