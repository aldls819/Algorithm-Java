package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1941 {

    /*
    25명의 여학생 고정
    이다솜파 여학생 4명 이상 포함되어 있어야 함
    DFS를 이용할 경우 십자모양이나 위아래로 튀어나온 모양같은건 판단하기 어려움
    25명 중 7명을 뽑은 조합 -> BFS로 연결되어 있는지 확인하자
    25명이 고정이기 때문에 x, y좌표를 미리 구해놓자
     */

    //조합을 통해 25개 중 7개 선택
    //이다솜파 4명 이상인지 확인
    //bfs를 이용해서 모두 연결되어 있는지 확인 -> cnt++

    //행 : i / 5
    //열 : i % 5

    static char[][] arr; //배열
    static boolean[] visited; //방문확인 배열
    static int[] comb; //조합에서 사용할 배열
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //전역변수 초기화
        arr = new char[5][5];
        visited = new boolean[25];
        comb = new int[7];
        result = 0;

        //배열에 값넣기
        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            for (int j = 0; j < 5; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        combination(0, 0);
        System.out.println(result);

    }

    //cnt -> 몇명을 뽑을지 7명
    //start -> 시작 위치
    public static void combination(int cnt, int start) {
        //기저조건
        //7명을 다 뽑았을 떄
        if (cnt == 7) {
            //인접해있고
            //다솜이파 4명 이상인지 확인한다
            if(checkDasom() && bfs()){
                    result++;
            }
            return;
        }


        for (int i = start; i < 25; i++) {
            //7명을 뽑는다
            //방문하지 않았다면
            if (!visited[i]) {
                //방문처리
                visited[i] = true;
                //comb배열에 무엇을 뽑았는지 넣는다
                comb[cnt] = i;
                //cnt+1을 해주고 i 위치부터 다시 시작한다
                combination(cnt + 1, i+1);
                //방문처리 해제
                visited[i] = false;
            }
        }
    }

    //다솜이 4명 이상인지 확인하는 메소드
    public static boolean checkDasom() {
        int cntDasom = 0;
        for (int i = 0; i < 25; i++) {
            //방문처리 된 곳만 확인하면 됨
            if (visited[i]) {
                int x = i / 5;
                int y = i % 5;
                //좌표값을 구해서 그 값에 해당하는
                //arr의 학생을 확인한다
                if (arr[x][y] == 'S') {
                    cntDasom++;
                }
            }
            //다솜이가 4명 이상이면
            //true 반환
            if (cntDasom >= 4) {
                return true;
            }
        }

        //아니면 false 반환
        return false;
    }


    //뽑아놓은 배열을 bfs돌려서 연결되어 있는지 확인한다
    public static boolean bfs(){
        //방문처리가 된 곳의 좌표를 bfs에 넣고 돌려본다
        int idx = 0;
        for(int i=0; i<25; i++){
            if(visited[i]){
                //방문처리 된 곳을 발견하면
                //그 좌표를 받고 바로 끝낸다
                idx = i;
                break;
            }
        }


        Queue<Integer> queue = new LinkedList<>();
        //x좌표
        queue.offer(idx/5);
        //y좌표
        queue.offer(idx%5);

        //bfs에서 사용할 방문처리 배열
        boolean [][] bfsVisited = new boolean [5][5];
        bfsVisited[idx/5][idx%5] = true;
        //시작위치 개수 세어주고 시작한다
        int cnt = 1;

        while(!queue.isEmpty()){
            int curX = queue.poll();
            int curY = queue.poll();
            //4방 탐색해서 연결되어 있는지 확인한다
            for(int i=0; i<4; i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                //범위 내에 있고
                if(nx >=0 && nx < 5 && ny >= 0 && ny < 5 ){
                    //bfs 메소드 내에서 방문하지 않았고
                    //combination 메소드 내에서 방문처리 되어있다면
                    if(!bfsVisited[nx][ny] && visited[nx*5+ny]) {
                        bfsVisited[nx][ny] = true;
                        queue.offer(nx);
                        queue.offer(ny);
                        cnt++;
                    }

                }
            }
        }
        //다 돌고 나와서 cnt가 7이면 true 아니면 false
        return cnt == 7 ? true : false;
    }
}

