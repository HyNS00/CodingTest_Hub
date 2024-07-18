class Solution {
    public int solution(String my_string) {
        // 공백을 잘 처리해야한다. -> 연속된 공백은 \\s+를 이용해준다.
        
        String[] tmp = my_string.replaceAll("[^0-9]+"," ").split(" ");
        int sum = 0;
        for(String str : tmp){
            if(!str.isEmpty()){
                sum += Integer.parseInt(str);
            }
        }
        return sum;
    }
}