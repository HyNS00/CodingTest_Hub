class Solution {
    public int solution(String my_string) {
        String number = my_string.replaceAll("[^0-9]","");
        int sum = 0;
        for(int i = 0; i < number.length(); i++){
            sum += number.charAt(i) -'0';
            // char - '0'은 숫자 값이 나온다.
        }
        return sum;
    }
}