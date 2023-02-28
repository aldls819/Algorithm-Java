package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2798 {

    /*
    N장의 카드 중 M과 가장 가깝게
    3장을 골라서 만들어야 함
    3장의 합을 구하는 문제
     */

    static int N, M; //카드의 개수, 구해야하는 합의 범위
    static int [] arr; //카드 배열
    static boolean [] visited; //방문처리 배열
    static int [] comb; //조합 생성 배열
    static List<Integer> list; //조합의 합 저장 리스트
    static int result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //전역변수 초기화
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int [N];
        visited = new boolean[N];
        comb = new int [3];
        list = new ArrayList<>();
        result = 0;

        //배열 채우기
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        combination(0, 0);

        //정렬하면 가장 뒤에 있는 애가 정답
        Collections.sort(list);
        
        result = list.get(list.size()-1);

        System.out.println(result);

    }

    public static void combination(int start, int cnt){
        //기저조건
        if(cnt == 3){
            //조합배열의 합을 구해보자
            int sum = 0;
            for(int i=0; i<3; i++){
                sum += comb[i];
            }
            //M보다 작거나 같은 경우에만 list에 추가한다
            if(sum <= M ){
                list.add(sum);
            }
            return;
        }

        //조합 코드
        for(int i=start; i<N; i++){
            //방문하지 않았다면
            if(!visited[i]) {
                //뽑고 방문처리
                comb[cnt] = arr[i];
                visited[i] = true;
                combination(i+1, cnt+1);
                visited[i] = false;
            }
        }

    }
}
