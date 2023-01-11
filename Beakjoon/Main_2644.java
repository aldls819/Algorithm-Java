package sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2644 {
	
	/*
	 * 촌수 계산 문제
	 * 인접행렬 또는 인접리스트 사용
	 * 주어진 두개의 번호의 촌수를 계산해야 함
	 * 만약 아무런 관계가 없다면 -1을 출력
	 */
	
	static int N; //사람의 수
	static List<Integer>[] list; //촌수 계산을 위한 list 생성
	static int [] family; //구해야 하는 정점 번호를 미리 저장해 둘 배열
	static int M; //관계의 개수
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		family = new int [2];
		
		//구해야 할 번호 두개를 배열에 넣어두자
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<2; i++) {
			family[i] = Integer.parseInt(st.nextToken());
		}
		
		M = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N];
		//각각의 인덱스 안에 다시 arraylist 넣어주자
		for(int i=0; i<N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		//양방향으로 원소 넣어주기
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			list[to].add(to);
		}

	}

}
