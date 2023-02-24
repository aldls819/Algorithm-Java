package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_11659 {
    /*
    N개의 수가 주어졌을 때 i~j 까지의 합을 구하기
    누적합 문제 -> 앞에서부터 애초에 더한 다음 배열에 저장하자
     */

    static int N; //수의 개수
    static int M; //합을 구해야 하는 횟구
    static int [] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        //전역변수 초기화
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int [N+1]; //인덱스 맞춰주기 위함


        //배열 채우기
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[0] = 0;
            //앞에서부터 차례대로 더한 값을 배열에 저장
            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
        }

        //M만큼 반복돌기
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            //구하고자 하는 범위의 끝 값에서
            //구하고자 하는 범위의 시작값 -1 을 해주면 쉽게 구할 수 있다
            sb.append(arr[end]-arr[start-1]).append("\n");
        }

        System.out.println(sb);


    }
}
