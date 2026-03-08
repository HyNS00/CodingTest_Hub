
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();

        List<Integer> list = new ArrayList<>();
        for(int num : arr) {
            if(list.isEmpty()) {
                list.add(num);
                continue;
            }
            // 항상 고려해야한다,
            // binarySearch는 정렬되어있어야한다.
            int idx = Collections.binarySearch(list,num);
            if(idx < 0) {
                int lastNum = list.get(list.size() - 1);
                if(num > lastNum) {
                    list.add(num);
                }else {
                    int real = (idx+1) * -1;
                    list.set(real, num);
                }
            }
        }
        bw.write(String.valueOf(list.size()));
        bw.close();
        br.close();
    }
}
