import java.util.Stack;
class Solution {
    public String solution(int n, int k, String[] cmd) {
        // 상대적인 위치를 생각해서 문제를 풀이
        // 링크드 리스트 생각
        class Node{
            Node prev;
            Node next;
            int value; // index역할
            public Node(int value){
                this.value = value;
            }
        }
        Node[] nodes = new Node[n];
        for(int i = 0; i < n; i++){
            nodes[i] = new Node(i);
            if(i > 0){
                nodes[i].prev = nodes[i-1];
                nodes[i-1].next = nodes[i];
            }
        }
        Node current = nodes[k];
        Stack<Node> deleted = new Stack<>();
        for(String c : cmd){
            if(c.startsWith("C")){
                deleted.push(current);
                if(current.prev != null) current.prev.next = current.next;
                if(current.next != null) current.next.prev = current.prev;
                current = (current.next != null) ? current.next : current.prev;
            }else if(c.startsWith("Z")){
                Node restore = deleted.pop();
                // restore의 prev와 next는 그대로 유지하고 있다.
                // 그자리에 복귀
                if(restore.prev != null) restore.prev.next = restore;
                if(restore.next != null) restore.next.prev = restore;
            } else{
                String[] s = c.split(" ");
                int num = Integer.parseInt(s[1]);
                for(int i = 0; i < num; i++){
                    if(s[0].equals("U")){
                        current = current.prev;
                    }else{
                        current = current.next;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder("O".repeat(n));
        while(!deleted.isEmpty()){
            sb.setCharAt(deleted.pop().value,'X');
        }
        return sb.toString();
    }
}