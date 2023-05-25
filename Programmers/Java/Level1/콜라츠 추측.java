class Solution {
    public int solution(long num) {
        int answer = 0;
        
        while(true) {
            //1이면 바로 0을 return
            if(num == 1 ){
                answer = 0;
                break;
            }
            //짝수일 때
            if(num % 2 == 0 ){
                num = num / 2;
                answer++;
                //1이 되면 멈춘다
                if(num == 1) {
                    break;
                }
            }
            //홀수일 때
            if(num % 2 == 1) {
                num = (num * 3) + 1;
                answer++;
                if(num == 1) {
                    break;
                }
            }

        }
        //500 이상이라면 -1 
        if(answer >= 500) {
            answer = -1;
        }
        
        return answer;
    }
}
