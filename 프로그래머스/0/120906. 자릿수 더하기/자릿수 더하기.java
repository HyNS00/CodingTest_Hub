class Solution {
    public int solution(int n) {
        int sum = 0;
        String[] tmp = String.valueOf(n).split("");
        for(String str : tmp){
            sum += Integer.parseInt(str);
        }
        return sum;
    }
}