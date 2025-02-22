class Solution {
    public int solution(int m, int n, String[] board) {
        int cnt = 0;
        char[][] game = new char[m][n];
        for(int i = 0; i < m; i++){
            String tmp = board[i];
            for(int j = 0; j < n; j++){
                game[i][j] = tmp.charAt(j);
            }
        }
        boolean[][] visited = new boolean[m][n];
        boolean flag = true;
        while(flag){
            flag = false;
            for(int i = 0; i < m-1; i++){
                for(int j = 0; j < n-1; j++){
                    char c = game[i][j];
                    if(c != '0' && c == game[i+1][j] &&
                      c == game[i][j+1] && c == game[i+1][j+1]){
                        visited[i][j] = true;
                        visited[i+1][j] = true;
                        visited[i][j+1] = true;
                        visited[i+1][j+1] = true;
                        flag = true;
                    }
                }
            }
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(visited[i][j]){
                        game[i][j] = '0';
                        cnt++;
                        visited[i][j] = false;
                    }
                }
            }
            for(int j = 0; j < n; j++){
                for(int i = m-1; i >= 0; i--){
                    if(game[i][j] == '0'){
                        for(int p = i-1; p >= 0; p--){
                            if(game[p][j] != '0'){
                                char tmp = game[p][j];
                                game[p][j] = game[i][j];
                                game[i][j] = tmp;
                                
                                break;
                            }
                        }
                    }
                }
            }
        }
        return cnt;
    }
}