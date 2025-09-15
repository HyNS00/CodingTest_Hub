import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        // 아이디어까지는 맞았으나 remove를 몰랐다. + TreeMap 생각도 했으나 못함

        for(int t = 0; t < T; t++){


            int n = Integer.parseInt(br.readLine());
            TreeMap<Integer,Integer> tm = new TreeMap<>();
            for(int i = 0; i < n; i++){

                StringTokenizer st = new StringTokenizer(br.readLine());

                String command = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if(command.equals("I")) {
                    tm.put(num, tm.getOrDefault(num, 0) + 1);
                }
                if (command.equals("D")) {
                    if(tm.isEmpty()) continue;
                    if(num == 1) {
                        int last = tm.lastKey();
                        if(tm.get(last) == 1){
                           tm.remove(last);
                        }else {
                            tm.put(last,tm.get(last) -1);
                        }
                    }else {
                        int first = tm.firstKey();
                        if(tm.get(first) == 1){
                            tm.remove(first);
                        }else {
                            tm.put(first, tm.get(first) - 1);
                        }
                    }
                }

            }

            if(tm.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                sb.append(tm.lastKey()).append(" ").append(tm.firstKey()).append("\n");
            }

        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
