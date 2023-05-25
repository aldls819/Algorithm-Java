package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_10505_소득불균형 {

	//전체 소득의 평균을 구한 뒤
	//평균 이하의 소득인 사람이 몇명인지 구하는 문제
	
	static int T; //테스트 케이스
	static int N; //사람의 수
	static int [] arr; //소득값을 넣어줄 배열
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			
			N = Integer.parseInt(br.readLine());
			arr = new int [N];
			int sum = 0;
			int avg = 0;
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum += arr[i];
			}
			
			avg = sum / N;
			int res = 0;
			//다시 for문을 돌면서 avg보다 작거나 같은게 몇개인지 개수를 세어주기
			for(int i=0; i<N; i++) {
				if(arr[i] <= avg) {
					res++;
				}
			}
			
			System.out.println("#"+tc+" "+res);
		}
		
		
	}

}
