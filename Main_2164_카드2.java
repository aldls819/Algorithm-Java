package hw;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2164_카드2 {
	
	/*
	 * 1~N까지의 번호 붙어있는 카드
	 * 1번카드 부터 제일 위에 있음
	 * 제일 위에 있는 카드 바닥에 버리고
	 * 그 다음으로 위에 있는 카드를 가장 밑으로 옮긴다
	 */
	
	static int N;
	static Queue<Integer> queue;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		//일단 카드를 순서대로 큐에 넣어줘야 함
		//큐 생성
		queue = new LinkedList<>();
		
		for(int i=1; i<N+1; i++) {
			queue.add(i);
		}
		
		while(true) {
			//1장이 남을때까지 반복 돌리기
			if(queue.size()>1) {
				//제일 위에 있는 애는 꺼내서 버리기
				//그 다음 위에 있는 애는 맨 뒤로 보내기
				queue.poll();
				int num = queue.poll();
				queue.add(num);
			}
			else break;
		}
		
		System.out.println(queue.poll());
		

	}

}
