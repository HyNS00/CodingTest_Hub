import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int currHealth = health;
        Map<Integer,Integer> attackTime = Arrays.stream(attacks).collect(Collectors.toMap(
            i -> i[0],
            i -> i[1]));
        int healthTime = 1;
        int lastTime = attacks[attacks.length-1][0];
        for(int time = 1; time <= lastTime; time++){
            
            if(attackTime.containsKey(time)){
                healthTime = 0;
                currHealth -= attackTime.get(time);
            }else{
                healthTime++;
                currHealth += bandage[1];
            }
            
            if(healthTime == bandage[0]){
                currHealth += bandage[2];
                healthTime = 0;
            }
            if(currHealth >= health){
                currHealth = health;
            }
            
            if(currHealth <= 0){
                return -1;
            }
        }
        return currHealth;
    }
}