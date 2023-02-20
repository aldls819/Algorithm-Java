package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14503 {

    static int N, M; //배열 가로 세로 크기
    static int r, c, d; //x좌표, y좌표, 방향
    static int[][] arr; //배열
    static boolean[][] visited; //방문처리 배열
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    /*
    현재 위치에서 청소 후
    4방 탐색 -> 후진 가능하면 후진
    청소할 수 있는 곳은 반시계 방향으로 탐색
    처음 빈칸은 전부 청소되지 않은 상태
    가장 바깥쪽은 벽으로 막혀있음
    */


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //전역변수 초기화
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        int cnt = 1; //처음 시작점은 청소되지 않았음 -> 청소하고 시작
        visited[r][c] = true;
        
        //배열 채우기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //현재 내 위치가 청소 가능한지 판단
        //바라보고 있는 방향 기준으로 후진 가능한지 판단
        //4방 탐색으로 청소 가능한 곳이 있는지 -> 반시계 방향으로 청소
        while(true) {
            //dfs1번 가능한지 확인
            //반시계로 회전 돌고 청소되지 않은 칸으로 전진가능한 경우
            if(dfs1(r, c, d)) {
                //반시계 방향으로 회전 한 후
                d = (d+3) % 4;
                //그 쪽 방향으로 전진 후 청소
                r = r + dx[d];
                c = c + dy[d];
                visited[r][c] = true;
                cnt++;
            }

            //4번 조건이 true일 때
            else if(dfs4(r, c, d)){
                    break;
            }

            //3번 조건이 true일 때
            else if(dfs3(r, c, d)){
                //후진하기
                r = r + dx[(d+2)%4];
                c = c + dy[(d+2)%4];
            }
            else {
                //반시계로 돌리기
                d = (d+3)%4;
            }

        }

        System.out.println(cnt);

    }

    //반시계 방향으로 돌면서
    //4방 탐색 후 범위 안에 있고 방문하지 않았고 청소되지 않은 칸인지 확인
    //3번 조건
    public static boolean dfs1(int x, int y, int d){
        //반시계 방향으로 회전
        int nd = (d+3) %4;

        int nx = x +dx[nd];
        int ny = y +dy[nd];

        //범위 및 방문 및 청소 체크
        if(rangeCheck(nx, ny) && !visited[nx][ny] && arr[nx][ny] == 0){
            //청소 가능
            return true;
        }
        //청소 불가능
        return false;
    }

    //청소할 공간이 없는 경우
    public static boolean dfs2(int x, int y, int d){
        int nd = (d+3) % 4;
        int nx = x + dx[nd];
        int ny = y + dy[nd];
        //갈 수 있는지 확인하자
        if(rangeCheck(nx, ny) && !visited[nx][ny] && arr[nx][ny] == 0){
            return true;
        }
        return false;
    }

    //후진도 안 되고 다 청소되어 있는 경우
    public static boolean dfs3(int x, int y, int d){
        int noClean = 0;
        //noClean은 청소할 수 없는 칸의 개수를 세어줄 변수임
        for(int idx=0; idx<4; idx++){
            int nx = x + dx[idx];
            int ny = y + dy[idx];
            //범위 밖에 있거나
            //방문 했거나
            //벽이면 noClean ++
            if(!rangeCheck(nx, ny) || visited[nx][ny] || arr[nx][ny] == 1){
                noClean++;
            }
        }
        return noClean == 4 ? true : false;
    }

    //바라보는 방향 기준
    //후진이 가능한 경우
    public static boolean dfs4(int x, int y, int d){
        if(dfs3(x, y, d)){
            //후진하기 -> 반대편으로 방향 전환
            int nd = (d+2) % 4;
            int nx = x + dx[nd];
            int ny = y + dy[nd];
            //범위 밖에 있거나 벽이라면
            if(!rangeCheck(nx, ny) || arr[nx][ny] == 1){
                //후진 불가능
                return true;
            }
        }
        //후진 가능
        return false;
    }

    //범위 체크 메소드
    public static boolean rangeCheck(int x, int y){
        return x > 0 && x < N && y > 0 && y < M;
    }
}
