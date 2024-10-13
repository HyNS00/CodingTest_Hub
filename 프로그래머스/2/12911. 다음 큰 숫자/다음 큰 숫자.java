class Solution {
    public int solution(int n) {
        int next = n+1;
        while(!isValid(n,next)){
            next++;
        }
        return next;
    }
    private boolean isValid(int n , int check){
        int ori = Integer.bitCount(n);
        int tmp = Integer.bitCount(check);
        return ori == tmp;
    }
}