
import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();

        Map<Integer,Integer> map = new HashMap<>();
        int value = Integer.MIN_VALUE;
        int left = 0;
        for(int start = 0; start < arr.length; start++){
            int curr = arr[start];

            map.put(curr, map.getOrDefault(curr, 0) + 1);
            while(map.size() > 2){
                map.put(arr[left], map.get(arr[left]) - 1);
                if(map.get(arr[left]) == 0){
                    map.remove(arr[left]);
                }
                left++;
            }
            value = Math.max(value,start-left+1);
        }
        bw.write(String.valueOf(value));
        bw.close();
        br.close();
    }
}