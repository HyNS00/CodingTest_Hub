class Solution {
    public int[] solution(int[] numbers, int num1, int num2) {
        int capacity = num2 - num1 +1;
        int[] answer = new int[capacity];
        for(int i = 0; i < capacity; i++){
            answer[i] = numbers[num1++];
        }
        return answer;
    }
}