class Solution {
    public int[] solution(String[] strlist) {
        int[] number = new int[strlist.length];
        int idx = 0;
        for(String ele : strlist){
            number[idx++] = ele.length();
        }
        return number;
    }
}