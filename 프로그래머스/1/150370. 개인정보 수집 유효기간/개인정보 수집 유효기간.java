import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        HashMap<String,Integer> map = new HashMap<>();
        ArrayList<Integer> list= new ArrayList<>();
        for(String term : terms){
            String[] tmp = term.split(" ");
            map.put(tmp[0], Integer.parseInt(tmp[1])*28);
        }
        long standard = calculateDate(today);
        for(int i = 0; i < privacies.length; i++){
            String[] privacy = privacies[i].split(" ");
            String alpha = privacy[1];
            String startDate = privacy[0];
            long tmp = calculateDate(startDate)+ map.get(alpha);
            if(tmp <= standard){
                list.add(i+1);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    private long calculateDate(String startDate){
        long sum = 0;
        String[] dates = startDate.split("\\.");
        sum += Integer.parseInt(dates[0]) * 28 * 12;
        sum += Integer.parseInt(dates[1]) * 28;
        sum += Integer.parseInt(dates[2]);
        return sum;
    }
}