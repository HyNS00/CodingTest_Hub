import java.util.*;

class Solution {
    private HashMap<Integer, int[]> map = new HashMap<>();
    private int[][] keymap = {{-1,0,-2},{7,8,9},{4,5,6},{1,2,3}};

    // 생성자에서 초기화
    public Solution() {
        for(int i = 0; i < keymap.length; i++){
            for(int j = 0; j < keymap[i].length; j++){
                map.put(keymap[i][j], new int[]{i,j});
            }
        }
    }

    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int[] rightHand = map.get(-2); // 오른손 시작 위치
        int[] leftHand = map.get(-1);  // 왼손 시작 위치

        for(int i : numbers) {
            if(i == 3 || i == 6 || i == 9) {
                rightHand = map.get(i);
                sb.append("R");
            } else if(i == 1 || i == 4 || i == 7) {
                leftHand = map.get(i);
                sb.append("L");
            } else {
                int[] k = map.get(i);
                int rightDis = calDistance(rightHand, k);
                int leftDis = calDistance(leftHand, k);

                if(rightDis > leftDis || (hand.equals("left") && rightDis == leftDis)) {
                    leftHand = k;
                    sb.append("L");
                } else {
                    rightHand = k;
                    sb.append("R");
                }
            }
        }

        return sb.toString();
    }

    private int calDistance(int[] first, int[] second) {
        return Math.abs(first[0] - second[0]) + Math.abs(first[1] - second[1]);
    }
}
