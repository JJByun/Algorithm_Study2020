import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Treasure {
    //solution number : 2589
    static char[][] board;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int M,N;
    static boolean[][] visited;
    static int maxCount = 0;
    static int result = 0;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] size = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = size[0];
        M = size[1];

        //board 생성
        board = new char[N][M];
        for(int i=0; i<N; i++){
            char [] charArr = br.readLine().toCharArray();
            for(int j=0; j<M; j++){
                board[i][j] = charArr[j];
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(board[i][j] == 'L'){ //땅이라면 탐색 시작면
                    bfs(new location(i,j,0));
                    maxCount = Math.max(result, maxCount);
                }
                result = 0;
            }
        }
        System.out.println(maxCount);
    }
    public static void bfs(location firstNode){
        visited = new boolean[N][M]; //bfs 안에서 visited를 만들어주어, 해당 Land 시작점에서 최단경로로 이동 가능한 케이스를 검사해줘야 함
        //dfs는 모든 경로를 다 검사하기 때문에 반복을 할 경우 시간 복잡도가 확 올라가지만, bfs는 그렇지 않
        Queue<location> q= new LinkedList<>();
        q.add(firstNode);
        while(!q.isEmpty()){
            location l = q.poll();음
            int x1 = l.x;
            int y1 = l.y;
            int count = l.count;
            result = count;
            visited[x1][y1] = true;
            for(int i=0; i<4; i++){
                int x2 = x1 + dx[i];
                int y2 = y1 + dy[i];
                if(x2 < 0 || x2 >= N || y2 < 0 || y2 >= M) continue; //범위 벗어나면 스킵
                if(visited[x2][y2] || board[x2][y2] == 'W') continue; //물이거나 이미 방문한 곳이면 스킵
                if(!visited[x2][y2] && board[x2][y2] == 'L'){ //땅이면서 방문 안했으
                    visited[x2][y2] = true;
                    q.add(new location(x2,y2,count+1));
                }
            }
        }
    }
    public static class location{
        int x;
        int y;
        int count;
        location(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
