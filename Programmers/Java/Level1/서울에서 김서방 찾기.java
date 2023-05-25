class Solution {
    public String solution(String[] seoul) {
        String str = "Kim";
        String answer = "";
        int idx = 0;
        
        for(int i=0; i<seoul.length; i++) {
            if(seoul[i].equals(str)) {
                idx = i;
            }
        }
        
        answer = "김서방은 " + idx + "에 있다";
        
        return answer;

    }
}
