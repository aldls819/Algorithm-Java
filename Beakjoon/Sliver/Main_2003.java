package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2003 {

    /*
    주어진 수열에서 i~j 까지 더했을 떼 M이 되는 경우의 수를 구해야 함
     */
    
    //투포인터 로직 제대로 알고 넘어가기
    
    static int N, M; //숫자의 개수, 더해서 되어야 하는 숫자
    static int [] arr; //수열을 넣어줄 배열

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        //배열 채워넣기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //앞에서부터 하나씩 증가하면서
        //M이 구해지는지 판단해야 한다
        //M보다 크다면 무시하고 다음으로 넘어간다
        
        //합계
        int sum = 0;
        //시작점
        int start = 0;
        //끝점
        int end = 0;
        //가능한 경우
        int cnt = 0;

        while(true){
            //만약 sum 이 M 보다 같거나 크다면
            //시작점을 뒤로 밀면서 빼준다
            if(sum >= M){
                sum -= arr[start++];
            }
            //끝까지 간 경우
            //끝낸다
            else if(end == arr.length ) {
                break;
            }
            //일반적으로는
            //시작점 고정시키고 뒤에를 하나씩 밀면서 더한다
            else {
                sum += arr[end++];
            }

            //만약 sum==M이 되면
            //cnt를 증가시킨다
            if(sum == M){
                cnt++;
            }
        }

        System.out.println(cnt);


    }

}
