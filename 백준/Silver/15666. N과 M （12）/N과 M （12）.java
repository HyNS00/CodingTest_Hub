
import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static Set<List<Integer>> set = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb.setLength(0);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
        Arrays.sort(arr);
        // 1 1 2
        // 3
        // 1 1 1
        // 1 1 2

        for(int i = 0; i < arr.length; i++){
            ArrayList<Integer> list = new ArrayList<>();
            maker(0,m,list,arr,i);
        }
        for(List<Integer> list : set) {
            for(int num : list) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }
        // retry
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
    public static void maker(int depth, int m, List<Integer> list, int[] arr, int startIdx) {
        if(depth == m) {
            set.add(new ArrayList<>(list));
            return;
        }

        for(int i = startIdx; i < arr.length; i++) {
            if(i > startIdx && arr[i] == arr[i-1]) continue;

            list.add(arr[i]);
            maker(depth+1,m,list,arr,i);
            list.remove(list.size() - 1);


        }

    }

}
