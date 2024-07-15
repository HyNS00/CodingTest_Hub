class Solution {
    public int solution(String my_string) {
        // 생각해보니까 간결화가 가능할거 같음
        String[] tmp = my_string.split(" ");
        int n = tmp.length;
        int answer = Integer.parseInt(tmp[0]);
        for(int i = 1; i < n; i+=2){
            if(tmp[i].equals("+")){
                answer += Integer.parseInt(tmp[i+1]);
            }else{
                answer -= Integer.parseInt(tmp[i+1]);
            }
        }
        return answer;
    }
}