import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(long n) {
        //String으로 변환해주기
        //Wrapper Class인 Long.toString 을 사용
        String str = Long.toString(n);
        
        int [] answer = new int [str.length()];
        
        //배열에 넣어줄 기준이 될 idx
        int idx = 0;
        
        //str과 answer의 idx를 반대로 하여
        //반복문을 돌려 각 인덱스에 원소를 넣어준다
        //idx는 answer 배열의 기준 값이기 때문에
        //반복문 한번 돌 때마다 ++해줘야 함
        for(int i=str.length()-1; i>=0; i--) {
            answer[idx] = str.charAt(i)-'0';
            idx++;
        }
        return answer;
    }
}
