
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        for(int i = 0; i < n; i++){
            set1.add(br.readLine());
        }

        for(int j = 0; j < m; j++){
            set2.add(br.readLine());
        }
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(String str : set1) {
            if(set2.contains(str)) {
                result.add(str);

            }
        }
        sb.append(result.size()).append("\n").append(result.stream().sorted().collect(Collectors.joining("\n")));
        bw.write(sb.toString());
        bw.close();
        br.close();

    }
}
