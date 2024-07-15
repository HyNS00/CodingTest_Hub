class Solution {
    public String solution(String my_string, int num1, int num2) {
        char[] tmp = my_string.toCharArray();
        char first = tmp[num1];
        char second = tmp[num2];
        tmp[num1] = second;
        tmp[num2] = first;
        String answer = new String(tmp);
        return answer;
    }
}