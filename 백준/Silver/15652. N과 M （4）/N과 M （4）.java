
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        // 같은걸 골라도 된다.

        int[] arr = IntStream.rangeClosed(1, n).toArray();
        for(int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(arr[i]);
            maker(1, list, arr, m, i);
        }
        bw.write(sb.toString());
        bw.close();
        br.close();

    }
    static void maker(int depth, List<Integer> list, int[] arr ,int m, int startIdx) {
        if(depth == m) {
            for(int n : list) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = startIdx; i < arr.length; i++) {
            if(!list.isEmpty() && list.get(list.size()-1) <= arr[i]) {
                list.add(arr[i]);
                maker(depth + 1, list, arr, m, startIdx);
                list.remove(list.size() - 1);
            }
        }

    }
}
