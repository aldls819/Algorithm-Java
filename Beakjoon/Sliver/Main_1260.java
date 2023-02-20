package sliver;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_DFS와BFS {

	//양방향 그래프를 생성해주기 위한 list 생성
	static List<Integer>[] adjList;
	//정점 개수, 간선 개수, 탐색 시작 정점 번호
	static int N, M, V;
	//출력을 위한 stringbuilder 생성
	static StringBuilder sb = null;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		//인덱스와 원소의 번호를 맞춰주기 위해서 +1
		adjList = new ArrayList[N + 1];
		
		// arrayslist 안에 또 arraylist -> 2차원 배열같이 생각하기
		for (int i = 0; i < N + 1; i++) {
			adjList[i] = new ArrayList<Integer>();
		}

		// 양방향으로 원소 넣어주기 -> from, to
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjList[from].add(to);
			adjList[to].add(from);
		}

		//dfs에서 사용할 visited 배열
		boolean[] visited = new boolean[N + 1];
		
		dfs(V, visited);
		
		sb.append("\n");

		 bfs(V);

		System.out.println(sb);
	}



	//dfs 메소드 생성
	//시작 정점을 기준으로 연결된 모든 원소들을 탐색하기
	public static void dfs(int curr, boolean[] visited) {
		//방문 처리 먼저 해주기
		visited[curr] = true;
		sb.append(curr).append(" ");

		// 정점 번호가 작은 거부터 방문하도록
		Collections.sort(adjList[curr]);
		
		for (int next : adjList[curr]) {
			if (!visited[next]) {
				dfs(next, visited);
			}
		}
	}

	//bfs 메소드
	//연결된 원소들 큐에 넣고 동시에 돌기
	public static void bfs(int n) {
		Queue<Integer> queue = new LinkedList<>();
		
		//bfs 메소드 내에서만 사용할 visited 배열
		boolean[] visited = new boolean[N + 1];

		queue.offer(n);
		visited[n] = true; // 저장하면서 체크

		while (!queue.isEmpty()) {
			int curr = queue.poll();
			sb.append(curr).append(" ");

			Collections.sort(adjList[curr]);
			for (int next : adjList[curr]) {
				if (!visited[next]) {
					visited[next] = true;
					queue.offer(next);
				}
			}
		}
	}

}
