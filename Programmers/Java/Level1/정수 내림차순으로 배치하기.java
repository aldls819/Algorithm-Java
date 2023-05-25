import java.util.*;

class Solution {
    public long solution(long n) {
        //valueOf 메소드를 사용해서
        //long을 String으로 변환하여 list에 추가한다
        long answer = 0;
        //n을 ""로 한 글자 씩 분리해서 arr 배열에 넣어준다
        String [] arr = String.valueOf(n).split("");

        //배열을 내림차순으로 정렬한다
        Arrays.sort(arr, Collections.reverseOrder());
        
        //시간을 줄이기 위해 StringBuilder를 사용한다
        StringBuilder sb = new StringBuilder();
        for(String str : arr) {
            sb.append(str);
        }
        
        //출력 시에서는 long을 String으로 바꿔줘야 한다
        return Long.parseLong(sb.toString());
    }
}
