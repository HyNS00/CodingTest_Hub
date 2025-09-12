
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++){
            String command = br.readLine();
            int len = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            boolean isRight = true;

            for(int i = 0; i <len; i++){
                deque.add(Integer.parseInt(st.nextToken()));
            }
            boolean empty = false;
            for(char c : command.toCharArray()) {
                if (c == 'R') {
                    isRight = !isRight;
                }else {
                    if(deque.isEmpty()) {
                        empty = true;
                        break;
                    }else {
                        if(isRight) {
                            deque.pollFirst();
                        }else {
                            deque.pollLast();
                        }
                    }
                }
            }
            String result;
            if(empty) {
                sb.append("error").append("\n");
            }else {
                // CollectingAndThen은 반환값이 있어야한다.
                // 람다에서도 return을 명시해줘야한다
                if(!isRight) {
                    result = deque.stream().collect(Collectors.collectingAndThen(
                            Collectors.toList(),
                            list -> {
                                Collections.reverse(list);
                                return list.stream().map(String::valueOf)
                                        .collect(Collectors.joining(",", "[", "]"));
                            }
                    ));
                }else {
                    result = deque.stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]"));
                }

                sb.append(result).append("\n");
            }

        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
