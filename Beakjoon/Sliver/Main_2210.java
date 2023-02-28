package Beakjoon;

import java.io.*;
import java.util.*;

public class Main_2210 {

    /*
    백트래킹 + 조합 문제
    5*5 숫자판 0-9 사이의 숫자로 채워져있음
    인접한 네방향으로 움직이면서 6자리 숫자 만들기
    한번 거쳤던 칸 다시 갈 수 있으며
    0으로 시작하는 숫자도 가능
     */

    //dfs + 백트래킹
    //모든 크기의 위치에 대해서 모두 확인
    //int + "" -> String으로 변환
    //contains를 사용하여 list에 있는지 확인
    //서로 다른 여섯자리 수들의 개수를 구하기

    static int [][] arr;
    static List<String> list;
    static int [] dx = {0, 1, 0, -1};
    static int [] dy = {1, 0, -1, 0};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        arr = new int [5][5];
        list = new ArrayList<>();

        //배열 입력받기
        for(int i=0; i<5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                dfs(i, j, 0, arr[i][j]+"");
            }
        }

        System.out.println(list.size());
    }

    public static void dfs(int x, int y, int cnt, String str){
        //기저조건
        if(cnt == 6){
            if(!list.contains(str)){
                list.add(str);
            }
            return;
        }

        for(int idx=0; idx<4; idx++){
            int nx = x + dx[idx];
            int ny = y + dy[idx];
            //방문 확인은 필요없음
            if(nx >= 0 && nx < 5 && ny >= 0 && ny < 5 ){
                //범위 내에 있다면
                //nx, ny를 가지고 재귀
                //str + arr[x][y] 의 값을 더해서 6자리 string 값을 만들기
                dfs(nx, ny, cnt+1, str+arr[x][y]);
            }
        }
    }

}
