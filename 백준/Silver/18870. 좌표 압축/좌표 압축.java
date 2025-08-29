

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong)
                .toArray();


        StringBuilder sb =new StringBuilder();
        Set<Long> set = Arrays.stream(arr).boxed().sorted().collect(Collectors.toCollection(LinkedHashSet::new));
        int num = 0;
        Map<Long,Integer> map = new HashMap<>();
        for(long s : set){
            map.put(s,num++);
        }

        for(long ar : arr){
            sb.append(map.get(ar)).append(" ");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
