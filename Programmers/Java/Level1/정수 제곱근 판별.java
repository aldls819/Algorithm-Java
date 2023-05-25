class Solution {
    public long solution(long n) {
        //sqrt를 사용하여 제곱근으로 바꾸고
        //pow로 제곱을 했을 때 n이면 n+1의 제곱 리턴
        if(Math.pow((int)Math.sqrt(n), 2) == n) {
            return (long)Math.pow(Math.sqrt(n)+1, 2);
        }
        
        return -1;
    }
}
