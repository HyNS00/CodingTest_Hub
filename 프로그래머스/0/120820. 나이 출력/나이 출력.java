class Solution {
    public int solution(int age) {
        // 어차피 365일이 지나면 1살씩 먹는다.
        // 나이는 태어난 년도가 1살
        // 2022 년 기준 age 가 주어진다.
        int originalAge = age-1;
        int result = 2022 - originalAge;
        return result;
    }
}