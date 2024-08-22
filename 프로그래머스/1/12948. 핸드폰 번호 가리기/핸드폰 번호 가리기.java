class Solution {
    public String solution(String phone_number) {
        int n = phone_number.length();
        if(n == 4){
            return phone_number;
        }
        String mark = "*";
        String tmp = phone_number.substring(n-4);
        String marked = mark.repeat(n-4);
        return marked+tmp;
    }
}