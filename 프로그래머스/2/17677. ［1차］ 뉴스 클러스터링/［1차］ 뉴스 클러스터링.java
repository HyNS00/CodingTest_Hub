import java.util.*;
import java.util.regex.*;
import java.util.stream.*;
class Solution {
    public int solution(String str1, String str2) {
        Pattern pattern  = Pattern.compile("[a-z]+");
        Map<String,Integer> first = change(classifier(str1,pattern));
        Map<String,Integer> second = change(classifier(str2,pattern));
    
        if(first.size() == 0 && second.size() == 0){
            return 65536;
        }
        
        Map<String,Integer> intersection = new HashMap<>();
        Map<String,Integer> union = new HashMap<>();
        
        for(String key : first.keySet()){
            if(second.containsKey(key)){
                intersection.put(key, Math.min(first.get(key), second.get(key)));
            }
            union.put(key, first.get(key));
        }
        
        for(String key : second.keySet()){
            if(union.containsKey(key)){
                union.put(key, Math.max(first.get(key), second.get(key)));
            }else{
                union.put(key, second.get(key));
            }
        }
        
        int up = intersection.values().stream().mapToInt(x -> x).sum();
        int down = union.values().stream().mapToInt(x -> x).sum();
        
        return (int) (((double)up/down) * 65536);
        
    }
    private List<String> classifier(String str, Pattern p){
        str = str.toLowerCase();
        List<String> list = new ArrayList<>();
        for(int i = 0; i < str.length()-1; i++){
            list.add(str.substring(i,i+2));
        }
        return list.stream().filter(s -> p.matcher(s).matches())
            .collect(Collectors.toList());
    }
    private Map<String,Integer> change(List<String> list){
        Map<String,Integer> map = new HashMap<>();
        for(String str : list){
            map.put(str, map.getOrDefault(str,0)+1);
        }
        return map;
    }
}