import java.util.*;

class Solution {
    public boolean solution(int x) {
        //각 자리수를 나누어 더하기
        //더한 수로 x를 나누기
        
        //각 자리수를 나누어 더한 합
        int sum = 0;
        //x값 잠시 가져다 쓸 변수
        int temp = x;

        
        while(temp != 0) {
            sum += temp % 10;
            temp = temp / 10;
        }

        
        if(x % sum == 0) {
            return true;
        }
        return false;
    }
}
