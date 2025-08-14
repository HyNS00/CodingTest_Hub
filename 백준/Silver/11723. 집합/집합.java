

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String commnd = st.nextToken();

            switch (commnd) {
                case "add":
                    int add = Integer.parseInt(st.nextToken());
                    set.add(add);
                    break;
                case "remove":
                    set.remove(Integer.parseInt(st.nextToken()));
                    break;
                case "check":
                    int target = Integer.parseInt(st.nextToken());
                    sb.append(checker(target)).append("\n");
                    break;
                case "toggle":
                    int tmp = Integer.parseInt(st.nextToken());
                    toggle(tmp);
                    break;
                case "all":
                    set = init();
                    break;
                case "empty":
                    set.clear();
                    break;
            }
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
    private static int checker(int target) {
        for(int num : set){
            if(num == target) {
                return 1;
            }
        }
        return 0;
    }

    private static void toggle(int target) {
        int result = checker(target);
        if(result == 1){
            set.remove(target);
        }else {
            set.add(target);
        }
    }

    private static Set<Integer> init() {
        Set<Integer> newOne = new HashSet<>();
        for(int i = 1; i <= 20; i++){
            newOne.add(i);
        }
        return newOne;
    }
}
