package hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1244_스위치켜고끄기 {
	
	/*
	 * 스위치 번호 1부터 연속적으로 붙어있음
	 * 1 -> 켜져있음
	 * 0 -> 까쟈있음
	 * 남학생 -> 스위치 번호의 배수 스위치 상태 바꿈
	 * 여학생 -> 스위치 번호를 중심으로 좌우 대칭 가장 많은 스위치 포함하는 구간 찾아서 바꿈(개수는 항상 홀수)
	 * 스위치의 마지막 상태를 출력
	 */
	
	static int N; //스위치개수
	static int [] arr; //스위치 상태 배열
	static int students; //학생수
	

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		//스위치번호가 1부터 시작되기 때문에 맞춰주기
		arr = new int [N+1];
		//0번째 인덱스는 안 쓸거니까 아예 안 나오는 숫자로 초기화
		arr[0] = 3;
		
		//스위치 상태 입력받기
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<N+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		students = Integer.parseInt(br.readLine());
		
		for(int i=0; i<students; i++) {
			st = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st.nextToken());
			int switchNum = Integer.parseInt(st.nextToken());
			
			if(sex == 1) {
				changeMan(switchNum);
			}
			else {
				changeWoman(switchNum);
			}
		}
		
		
		//한 줄에 20개씩 출력
		for(int i=1; i<N+1; i++) {
			System.out.print(arr[i]+ " ");
			if(i % 20 == 0) {
				System.out.println();
			}
		}


	}
	
	public static void changeMan(int switchNum) {
		for(int i=1; i<N+1; i++) {
			//스위치 번호의 배수라면
			if(i % switchNum == 0) {
				if(arr[i] == 1) {
					arr[i] = 0;
				}
				else {
					arr[i] = 1;
				}
			}
		}
	}
	
	public static void changeWoman(int switchNum) {
		//일단 자기 자신부터 바꾸기
		if(arr[switchNum] == 1) {
			arr[switchNum] = 0;
		}
		else {
			arr[switchNum] = 1;
		}
		
		int size = Math.min(switchNum, N-switchNum+1);
		
		for(int i=1; i<size; i++) {
			//대칭이라면
			if(arr[switchNum-i] == arr[switchNum+i]) {
				arr[switchNum-i] = arr[switchNum-i] == 1 ? 0 : 1;
				arr[switchNum+i] = arr[switchNum+i] == 1 ? 0 : 1;
			}
			else break;
		}
	}


}
