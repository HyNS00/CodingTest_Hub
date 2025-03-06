class Solution {
    public int solution(int storey) {
        int stone = 0;
        // 기준점 -> 5 
        // 5일 때의 상황을 나눠보자.
        
        while(storey != 0){
            int r = storey % 10;
            if(r > 5){
                storey += 10;
                stone += (10 - r);
            }else if(r < 5){
                stone += r;
            }else{
                int next = (storey / 10) % 10;
                if(next  >= 5){
                    stone += 5;
                    storey += 10;
                }else{
                    stone += 5;
                }
            }
            storey /= 10;
        }
        return stone;
    }
}