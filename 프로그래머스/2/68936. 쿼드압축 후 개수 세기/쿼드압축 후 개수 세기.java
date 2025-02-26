class Solution {
    int[] answer = new int[2];
    public int[] solution(int[][] arr) {
        int n = arr.length;
        
        compress(arr,0,0,n);
        return answer;
    }
    private void compress(int[][] arr, int startRow, int startCol, int size){
        if(checker(arr,startRow,startCol,size)){
            int s = arr[startRow][startCol];
            answer[s]++;
            return;
        }
        size /= 2;
        compress(arr,startRow,startCol,size);
        compress(arr,startRow, startCol + size, size);
        compress(arr,startRow+size, startCol, size);
        compress(arr,startRow+size, startCol+size, size);
    }
    
    private boolean checker(int[][] arr, int startRow, int startCol, int size){
        int value = arr[startRow][startCol];
        for(int i = startRow; i < startRow + size; i++){
            for(int j = startCol; j < startCol+size; j++){
                if(arr[i][j] != value){
                    return false;
                }
            }
        }
        return true;
    }
}