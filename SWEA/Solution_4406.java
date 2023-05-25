package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution_4406_모음이보이지않는사람 {
	
	//주어진 String에서 a, e, i, o, u 를
	//삭제하는 문제
	static int T; //테스트 케이스
	static String str; //주어지는 단어
	static String [] arr; //list에 넣어주기 위한 배열
	static List<Character> list; //단어를 넣어줄 리스트
	//중간 단어 삭제해야 함으로 list 사용

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			str = br.readLine();
			list = new ArrayList<>();
			
			for(int i=0; i<str.length(); i++) {
				char C = str.charAt(i);
				//모음이면 넘어가기
				if(C == 'a' || C == 'e' || C == 'i' || C == 'o' || C == 'u') {
					continue;
				}
				//자음인 것만 list에 추가
				else {
					list.add(C);
				}
			}
			
			String res = "";
			
			//res로 list 값들 넣어주기
			for(int i=0; i<list.size(); i++) {
				res += list.get(i);
			}
			
			System.out.println("#"+tc+" "+res);
			
			
		}
		
		
	}

}
