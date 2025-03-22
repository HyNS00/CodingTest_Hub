import java.util.*;
import java.util.stream.*;
class Solution {
    int cnt = 0;
    public static class Music{
        String name;
        String code;
        int remain;
        int idx;
        public Music(String name, String code, int remain,int idx){
            this.name = name;
            this.code = code;
            this.remain = remain;
            this.idx = idx;
        }
        public int getRemain(){
            return remain;
        }
        
        public int getIdx(){
            return idx;
        }
    }
    public String solution(String m, String[] musicinfos) {
        List<Music> list  = new ArrayList<>();
        int idx = 0;
        for(String musicinfo : musicinfos){
            String[] tmp = musicinfo.split(",");
            int remain = changer(tmp[0],tmp[1]);
            
            String code = convert(tmp[3]);
            int n = code.length();
            if(remain > n){
                StringBuilder sb = new StringBuilder();
                sb.append(code);
                for(int i = 0; i < remain-n; i++){
                    sb.append(code.charAt(i % n));
                }
                list.add(new Music(tmp[2],sb.toString(),remain,idx++));
            }else{
                list.add(new Music(tmp[2],convert(code.substring(0,remain)),remain,idx++));
            }
        }
        // 조건이 여러개 일 때는 여러 정렬 조건을 사용해주는 것이 좋다.
        List<Music> answer = list.stream().filter(music -> music.code.contains(convert(m)))
            .sorted(Comparator.comparingInt(Music::getRemain).reversed()
                    .thenComparingInt(Music::getIdx)).limit(1).collect(Collectors.toList());
        return answer.isEmpty() ? "(None)" : answer.get(0).name;
    }
    private int changer(String start, String end){
        int startTime = time(start.split(":"));
        int endTime = time(end.split(":"));
        
        return endTime - startTime;
    }
    // 샵이 붙은 코드는 다른 코드로 대체한다.
    private String convert(String s){
        return s.replace("C#","H")
            .replace("D#","I")
            .replace("F#","J")
            .replace("G#","K")
            .replace("A#","L")
            .replace("B#","M")
            .replace("E#","N");
    }
    private int time(String[] s){
        return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
    }
}