package summer_academy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_새로운불면증치료법 {

	// N의 배수 번호 영 세기
	// 0-9까지 모든 숫자를 보는 최소 번째 구하기
	// N의 범위 1-10^6

	// 주어진 숫자를 잘라서 check 배열에 true
	// 계속 더해나가면서 check 배열이 전부 true 일 때까지 반복하기

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			
			boolean [] check = new boolean [10];
			//몇번 반복되었는지 체크할 변수
			int cnt = 0;
			int num = 0;
			
			while (true) {
				num += N;
				
				//각각의 자리수를 잘라서 check 배열에 true 표시한다
				checkNumber(num, check);
				//이 과정이 한번 일어날 때마다 cnt 증가
				cnt++;
				
				//check 배열이 모두 true인지
				//즉 0-9 의 숫자가 전부 나왔는지 확인한다
				if(allCheck(check)) {
					break;
				}
			}
			
			//xN번 숫자를 출력하는 것임
			System.out.println("#"+tc+" "+cnt*N);

		}

	}
	
	//숫자 체크해주는 메소드
	private static void checkNumber(int num, boolean [] check) {
		while(num > 0) {
			int temp = num % 10;
			
			if(!check[temp]) {
				check[temp] = true;
			}
			
			num = num / 10;
		}
	}
	//숫자 전부 나왔는지 확인 메소드
	private static boolean allCheck(boolean [] check) {
		for(int i=0; i<10; i++) {
			if(!check[i]) {
				return false;
			}
		}
		return true;
	}

}
