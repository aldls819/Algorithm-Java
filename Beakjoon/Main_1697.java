package sliver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1697_숨바꼭질 {

	/*
	 * 수빈이의 현재 위치에서
	 * 동생을 찾으러 가는데 걸리는
	 * 최단 시간 구하는 문제
	 * 1초에 +1, -1
	 * 순간이동 2*x
	 * 10만 짜리 배열을 미리 만들어놓고
	 * 3가지 경우를 체크해가면서 bfs 돌려보자
	 */
	
	static int N; //수빈이 시작 위치
	static int K; //동생 위치
	static int [] arr; //길찾기 배열
	static int cnt;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		cnt = 0;
		
		arr = new int [100001];
		
		bfs(N, K);
		
		System.out.println(arr[K]-1);
		
	}
	
	public static void bfs(int n, int k) {
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(n);
		arr[n] = 1;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			if(cur == K) {
				break;
			}
			
			int front = cur + 1;
			int back = cur - 1;
			int twice = cur * 2;
			
			if(front >= 0 && front < arr.length && arr[front] == 0) {
				q.offer(front);
				arr[front] = arr[cur]+1;
			}
			
			if(back >= 0 && back < arr.length && arr[back] == 0) {
				q.offer(back);
				arr[back] = arr[cur]+1;
			}
			
			if(twice >= 0 && twice < arr.length && arr[twice] == 0) {
				q.offer(twice);
				arr[twice] = arr[cur]+1;
			}
		}
	}

}
