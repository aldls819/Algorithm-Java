package sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2644 {
	
	/*
	 * 촌수를 계산해야 하는 두 사람의 번호를 기준으로
	 * list를 bfs를 돌아보고
	 * 안 나오면 -1 출력하고
	 * 아니라면 cnt++ 하다가 결과값 출력해보자
	 */
	
	static int N, M; //전체 사람 수
	static int [] arr; //찾아야 하는 원소들 넣어줄 배열
	static List<Integer>[] list; //그래프 만들어 줄 list
	static boolean [] visited; //방문 처리 배열
	static int [] dis; //각각의 거리를 넣어줄 배열

	//flag 변수
	static boolean flag;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int [2];
		
		//관계를 구해야 하는 두 원소를 배열에 채워주자
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<2; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//인덱스와 원소 번호 맞춰주기
		list = new ArrayList[N+1];
		//안에 list 다시 넣어주기
		for(int i=0; i<N+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		M = Integer.parseInt(br.readLine());
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			list[to].add(from);
		}
		
		visited = new boolean [N+1];

		flag = false;
		dis = new int [N+1];
		
		bfs(arr[0], arr[1]);
		
		if(flag) {
			System.out.println(dis[arr[1]]);
		} else {
			System.out.println(-1);
		}
		

	}
	
	public static void bfs(int start, int end) {
		Queue<Integer> queue = new LinkedList<>();
		
		//일단 다 -1로 초기화
		for(int i=1; i<N+1; i++) {
			dis[i] = -1;
		}
		
		//큐에 시작점 집어넣고 방문처리
		queue.add(start);
		visited[start] = true;
		//시작점은 거리가 없으니까 0
		dis[start] = 0;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();

			
			//만약 종료지점에 도달했다면 그만!
			if(cur == end) {
				flag = true;
				break;
			} 
			
			for(int next : list[cur]) {
				if(!visited[next]) {
					visited[next] = true;
					queue.offer(next);
					//거리가 증가되는 것을 dis 배열에 표현해주자
					dis[next] = dis[cur] + 1;
				}
			}
			
		}
	}


}
