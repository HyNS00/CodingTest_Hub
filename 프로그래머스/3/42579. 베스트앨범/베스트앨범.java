import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String,Integer> playing = new HashMap<>();
        Map<String,List<int[]>> genreMap = new HashMap<>();
        for(int i = 0; i < genres.length; i++){
            String genre = genres[i];
            if(!genreMap.containsKey(genre)){
                genreMap.put(genre, new ArrayList<int[]>());
                // 빈칸을 항상 먼저 만들어줘야한다.
            }
            genreMap.get(genre).add(new int[]{i, plays[i]});
            playing.put(genre, playing.getOrDefault(genre, 0)+plays[i]);
        }
        List<Integer> answer = new ArrayList<>();
        // 장르의 우선순위를 정해야한다.
        Stream<Map.Entry<String,Integer>> sortedGenre = playing.entrySet().stream()
            .sorted((o1,o2) -> Integer.compare(o2.getValue(), o1.getValue()));
        sortedGenre.forEach(entry -> {
            Stream<int[]> sorted = genreMap.get(entry.getKey()).stream().sorted((o1,o2)-> Integer.compare(o2[1], o1[1])).limit(2);
            sorted.forEach(e -> answer.add(e[0]));
        });
       return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}