import java.util.Stack;

public class Solution {
    public String solution(int n, int k, String[] cmd) {
        class Node {
            int value;
            Node prev;
            Node next;

            public Node(int value) {
                this.value = value;
            }
        }
        // 노드들의 배열 (쉬운 접근을 위해)
        Node[] nodes = new Node[n];
        
        // 링크드 리스트 초기화
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
            if (i > 0) {
                nodes[i].prev = nodes[i-1];
                nodes[i-1].next = nodes[i];
            }
        }
        
        // 현재 선택된 노드
        Node current = nodes[k];
        
        // 삭제된 노드를 저장하는 스택
        Stack<Node> deleted = new Stack<>();
        
        // 명령어 실행
        for (String c : cmd) {
            if (c.startsWith("C")) {
                deleted.push(current);
                
                // 현재 노드 삭제
                if (current.prev != null) current.prev.next = current.next;
                if (current.next != null) current.next.prev = current.prev;
                
                // 다음 노드 선택
                current = (current.next != null) ? current.next : current.prev;
            } else if (c.startsWith("Z")) {
                Node restore = deleted.pop();
                
                // 노드 복구
                if (restore.prev != null) restore.prev.next = restore;
                if (restore.next != null) restore.next.prev = restore;
            } else {
                String[] s = c.split(" ");
                int x = Integer.parseInt(s[1]);
                
                // 위아래로 이동
                for (int i = 0; i < x; i++) {
                    if (s[0].equals("U")) current = current.prev;
                    else current = current.next;
                }
            }
        }
        
        // 결과 문자열 생성
        StringBuilder answer = new StringBuilder("O".repeat(n));
        while (!deleted.isEmpty()) {
            answer.setCharAt(deleted.pop().value, 'X');
        }
        
        return answer.toString();
    }
}