package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_12368_24시간 {
	
	static int T; //테스트케이스 개수
	static int A; //시작 시간
	static int B; //종료 시간

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			int time = A + B;
			int res = 0;
			
			if(time < 24) {
				res = time;
			}
			if(time == 24) {
				res = 0;
			}
			if(time > 24) {
				res = time - 24;
			}
			
			System.out.println("#"+tc+" "+res);
		}

	}

}
