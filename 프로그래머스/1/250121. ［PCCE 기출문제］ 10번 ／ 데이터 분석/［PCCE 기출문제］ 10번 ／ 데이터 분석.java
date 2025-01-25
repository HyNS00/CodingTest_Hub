import java.util.stream.*;
import java.util.*;
class Solution {
    private static final Map<String,Integer> map = new HashMap<>();
    static{
        map.put("code",0);
        map.put("date",1);
        map.put("maximum",2);
        map.put("remain",3);
    }
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int standard = map.get(ext);
        int sortStandard = map.get(sort_by);
        return Arrays.stream(data).filter(arr -> arr[standard] < val_ext)
            .sorted((a,b) -> Integer.compare(a[sortStandard], b[sortStandard]))
            .toArray(int[][]::new);
    }
}