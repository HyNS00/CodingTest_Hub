class Solution {
    public long solution(String numbers) {
        
        String[] eng ={"zero","one","two","three","four","five",
                      "six","seven","eight","nine"};
        String[] num ={"0","1","2","3","4","5","6", "7","8","9"};
        for(int i = 0; i < eng.length; i++){
            if(numbers.contains(eng[i])){
                numbers = numbers.replace(eng[i],num[i]);
                // replace는 return값이 존재한다.
                // 원래 문자열은 변하지 않음
            }
        }
        return Long.parseLong(numbers);
        // Integer.parseInt
    }
}