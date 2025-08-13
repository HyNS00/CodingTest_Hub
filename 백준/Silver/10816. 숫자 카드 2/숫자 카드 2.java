
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();

        int M = Integer.parseInt(br.readLine());
        int[] sHave = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < numbers.length; i++){
            map.put(numbers[i],map.getOrDefault(numbers[i],0)+1);
        }

        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < sHave.length; j++){
            int tmp = map.getOrDefault(sHave[j],0);
            sb.append(tmp).append(" ");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
