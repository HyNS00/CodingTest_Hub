class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int minX = 52;
        int minY = 52;
        int maxX = 0;
        int maxY = 0;
        for(int i  = 0; i < wallpaper.length; i++){
            for(int j = 0; j < wallpaper[i].length(); j++){
                if(wallpaper[i].charAt(j) == '#'){
                    if(i < minX){
                        minX = i;
                    }
                    if(j < minY){
                        minY = j;
                    }
                    if(i > maxX){
                        maxX = i;
                    }
                    if(j > maxY){
                        maxY = j;
                    }
                }
            }
        }
        answer[0] = minX;
        answer[1] = minY;
        answer[2] = maxX+1;
        answer[3] = maxY+1;
        return answer;
    }
}