package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_5014 {

    /*
    s에서 출발해서 g까지 도달하는데
    눌러야 하는 버튼 수의 최솟값을 구하는 문제
    bfs를 활용해서 풀어보자
     */

    static int f, s, g, u, d; //주어지는 변수들
    static int [] arr; //배열
    static boolean flag;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //전체 층수
        f = Integer.parseInt(st.nextToken());
        //시작점
        s = Integer.parseInt(st.nextToken());
        //도착점
        g = Integer.parseInt(st.nextToken());
        //위로
        u = Integer.parseInt(st.nextToken());
        //아래로
        d = Integer.parseInt(st.nextToken());

        //층수를 맞춰주기 위해서 +1을 해주자
        arr = new int [f+1];

        bfs(s);

        if(flag) {
            System.out.println(arr[g] - 1);
        }
        else {
            System.out.println("use the stairs");
        }

    }

    public static void bfs(int start){
        //큐 생성
        Queue<Integer> q = new LinkedList<>();

        //시작점인 s의 위치를 넣자
        q.offer(start);
        arr[start] = 1;

        while(!q.isEmpty()){
            int cur = q.poll();

            //도착하면 끝내기
            if(cur == g){
                //도달하지 못 하는 경우와 구별해주기 위해서
                //flag 변수를 true로
                flag = true;
                break;
            }

            //올라갈 때의 경우
            int up = cur + u;
            //내려갈 때의 경우
            int down = cur - d;

            if(up >= 1 && up < arr.length && arr[up] == 0){
                q.offer(up);
                //버튼 누르는 횟수를 증가시키기 위해서 +1을 해줌
                arr[up] = arr[cur] + 1;
            }

            if(down >= 1 && down < arr.length && arr[down] == 0){
                q.offer(down);
                //버튼 누르는 횟수를 증가시키기 위해서 +1을 해줌
                arr[down] = arr[cur] + 1;
            }

        }
    }
}
