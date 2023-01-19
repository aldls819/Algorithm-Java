package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2468 {

    /*
    배열 내의 숫자를 한번씩 반복하면서
    물에 잠기지 않는 영역이 가장 많을 때를 출력하기
    4방 탐색 필요
    dfs로 풀어보자
     */

    static int N; //배열 크기
    static int [][] arr; //배열
    static boolean [][] visited; //방문 확인 배열
    static List<Integer> list; //높이 저장 list
    static int [] dx = {0, 1, 0, -1};
    static int [] dy = {1, 0, -1, 0};
    static int res; //결과값


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //전역변수 초기화
        N = Integer.parseInt(br.readLine());
        arr = new int [N][N];
        list = new ArrayList<>();
        res = Integer.MIN_VALUE;

        //배열에 값 넣기 + 높이들 list에 추가
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(!list.contains(arr[i][j])){
                    list.add(arr[i][j]);
                }
            }
        }

        //list의 높이 순서대로 반복 진행
        for (int num : list) {
            int cnt = 0;
            visited = new boolean[N][N];

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(!visited[i][j] && arr[i][j] >= num){
                        dfs(i, j, num);
                        cnt++;
                    }
                }
            }
            res = Math.max(res, cnt);
        }

        System.out.println(res);

    }

    public static void dfs(int x, int y, int num){
        //dfs 시작하자마자 방문처리 해주기
        visited[x][y] = true;

        for (int idx=0; idx<4; idx++){
            int nx = x + dx[idx];
            int ny = y + dy[idx];
            //범위 체크
            if(nx>=0 && nx < N && ny >= 0 && ny < N){
                //높이 체크 및 방문 여부 확인
                if(!visited[nx][ny] && arr[nx][ny] >= num){
                    //조건에 부합하면
                    //방문처리 해주고
                    //그 값을 가지고 재귀 타기
                    visited[nx][ny] = true;
                    dfs(nx, ny, num);
                }
            }

        }
    }
}
