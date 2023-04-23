boolean solution(String inputString) {
    char[] c = inputString.toCharArray();
    int N = c.length;
    int lt = 0;
    int rt = N-1;
    
    //왼쪽이 오른쪽을 넘어가면 종료한다
    while(lt <= rt) {
        if(c[lt] != c[rt]) {
            return false;
        }
        lt++;
        rt--;
    }

    return true;
}
