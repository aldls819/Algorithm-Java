package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_9205 {

    /*
    50미터 당 한병씩 맥주 마셔야 함
    1000미터에 20병
    편의점에서 새 맥주 살 수 있음
    가지고 있을 수 있는 맥주 최대 20병
     */

    static int T; //테스트케이스
    static int N; //편의점 개수

    //xy 좌표값을 갖는 class를 만들어서
    //집, 편의점, 페스티벌 좌표를 입력받자
    static location house;
    static location[] store; //편의점은 여러개
    static location festival;
    //방문한 편의점은 다시 가지 않기 때문에 방문처리 필요
    static boolean[] visited;
    static boolean flag; //갈 수 있는지 없는지 확인


    static class location {
        int x;
        int y;

        public location(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        //테스트케이스 입력
        T = sc.nextInt();
        for(int tc=1; tc<=T; tc++){

            //편의점 개수 입력받기
            N = sc.nextInt();
            //편의점 개수만큼 배열 생성
            store = new location[N];
            visited = new boolean [N];
            
            //상근이네 집
            house = new location(sc.nextInt(), sc.nextInt());

            //편의점 좌표 입력
            for(int i=0; i<N; i++){
                store[i] = new location(sc.nextInt(), sc.nextInt());
            }

            //페스티벌 좌표 입력
            festival = new location(sc.nextInt(), sc.nextInt());

            //갈 수 있으면 true
            //갈 수 없으면 false
            flag = false;

            //집에서부터 출발함
            distance(house.x, house.y);

            if(flag){
                System.out.println("happy");
            } else {
                System.out.println("sad");
            }

        }



    }

    //맨해튼 거리 구하는 메소드
    //현재 위치에서 편의점까지 갈 수 있으면
    //true를 return 하고 끝낸다
    //이외의 경우에서는 현재 위치에서 편의점까지 갈 수 있는지를 확인한다
    //이때 재귀를 타고 들어가며 현재 위치에서 다음 위치로 이동한다
    public static void distance(int x, int y){
        //기저조건
        if(flag){
            return;
        }

        
        //맨해튼 거리 구하기 -> 페스티벌까지 가기
        //거리가 1000 이하라면 갈 수 있음
        if(Math.abs(x- festival.x) + Math.abs(y - festival.y) <= 1000) {
            flag = true;
            return;
        }

        for(int i=0; i<N; i++){
            //방문했으면 넘어가기
            if(visited[i]){
                continue;
            }

            if(Math.abs(x-store[i].x)+Math.abs(y-store[i].y) <= 1000) {
                    //방문체크 해주고
                    //다음 편의점 위치에서 다시 출발해보자
                    visited[i] = true;
                    distance(store[i].x, store[i].y);
            }
        }

    }
}
