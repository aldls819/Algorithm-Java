package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3431_준환이의운동관리 {
	
	//1주일에 L분 이상 U분 이하의 운동을 하여야 함
	//이번 주에 X분 만큼 운동했음
	//제한되어 있는 시간을 넘은 운동을 한 것인지, 
	//그것이 아니라면 몇 분 더 운동을 해야 제한을 맞출 수 있는지
	
	static int T; //테스트 케이스
	static int L, U, X; //L분 이상, U분 이하 운동, X분 운동함
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++){
			st = new StringTokenizer(br.readLine());
			
			L = Integer.parseInt(st.nextToken());
			U = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			
			int res = 0;
			
			//더 많은 운동을 하는 경우
			if(X > U) {
				res = -1;
			}
			if(L <= X && X <= U) {
				res = 0;
			}
			if(X < L) {
				res = L - X;
			}
			
			System.out.println("#"+tc+" "+res);
			
		}
		

	}

}
