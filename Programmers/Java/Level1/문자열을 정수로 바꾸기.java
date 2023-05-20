class Solution {
    public int solution(String s) {
        int answer = 0;
        
        //만약 s가 +로 시작하거나 아무런 부호가 없으면
        //그대로 출력하기
        //만약 s가 -로 시작하면 앞에 -를 붙여서 출력
        answer = Integer.parseInt(s);
        
        return answer;
    }
}
