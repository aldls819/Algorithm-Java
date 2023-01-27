package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10026 {
    
    /*
    적록색약 -> 빨강과 초록을 동일하게 인식
    일반인과 적록색약이 보는 구역의 수를 각각 구하기
    일반인 -> 빨강, 파랑, 초록
    적록색약 -> 빨강+초록, 파랑
     */

    static int N; //배열 크기
    static char [][] arr;
    static boolean [][] visited;
    static boolean [][] colorVisited;
    static int [] dx = {0, 1, 0, -1};
    static int [] dy = {1, 0, -1, 0};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //문자로 입력 받기 때문에 string으로 받고
        //하나씩 잘라서 배열에 넣자
        N = Integer.parseInt(br.readLine());
        arr = new char [N][N];
        visited = new boolean [N][N];
        colorVisited = new boolean [N][N];

        //배열 입력받기기
       for(int i=0; i<N; i++){
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j);
            }
        }
       
       int cnt = 0; //일반 사람
        int colorCnt = 0; //적록색약

       //적록색약인 경우와
        //일반의 경우를
        //각각 dfs를 돌려서 cnt를 세어주자자

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                //일반 사람
                //방문하지 않았다면 dfs 시작
                if(!visited[i][j]){
                    cnt++;
                    dfs(i, j, arr[i][j]);
                }
                //적록색약의 경우
                //방문하지 않았다면 colorDfs 시작
                if(!colorVisited[i][j]){
                    colorCnt++;
                    colorDfs(i, j, arr[i][j]);
                }
            }

        }

        System.out.println(cnt+ " "+ colorCnt);


   }

   public static void dfs(int x, int y, char c){
        //시작하자마자 방문처리
        visited[x][y] = true;
        for(int idx=0; idx<4; idx++) {
            int nx = x + dx[idx];
            int ny = y + dy[idx];
            //범위체크
            if(nx>=0 && nx <N && ny >= 0 && ny < N){
                //각각의 경우마다 dfs를 돈다
                //시작점의 색과 같으면 탐색을 시작한다
                if(!visited[nx][ny] && arr[nx][ny] == c) {
                    dfs(nx, ny, c);
                }
            }
        }
   }

    public static void colorDfs(int x, int y, char c){
        colorVisited[x][y] =true;
        //시작점에서 4방탐색을 해서
        //색을 판단하자
        for(int idx=0; idx<4; idx++){
            int nx = x + dx[idx];
            int ny = y + dy[idx];
            //범위체크
            if(nx >= 0 && nx < N && ny >= 0 && ny < N){
                //방문체크
                if(!colorVisited[nx][ny]) {
                    //색 체크
                    //적록색약인 경우에는 R과 G를 따라서 DFS를 돈다
                    if(c == 'R' || c =='G'){
                        //4방 탐색해서 해당 색이 있는 경우
                        if (arr[nx][ny] == 'R' || arr[nx][ny] == 'G') {
                                    colorDfs(nx, ny, c);
                             }
                    }
                    //R과 G를 제외한 B의 경우에서
                    //DFS를 돈다
                    else {
                        if(arr[nx][ny] == c){
                            colorDfs(nx, ny, c);
                        }
                    }
                }
            }
        }
    }
}
