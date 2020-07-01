import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class KnightMove {

    //solution number : 7562
    public static int[] _X = {-1,-2,-2,-1,1,2,2,1};
    public static int[] _Y = {-2,-1,1,2,2,1,-1,-2};
    static int board[][];
    static boolean[][] visited;
    static Location start;
    static Location end;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int itr = Integer.parseInt(br.readLine());

        for(int i=0; i<itr; i++) {
            int n = Integer.parseInt(br.readLine());
            board = new int[n][n];
            visited = new boolean[n][n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            start = new Location(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));

            st = new StringTokenizer(br.readLine());
            end = new Location(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            if(start.x == end.x && start.y == end.y){
                System.out.println(0);
                return;
            }
            bfs();
            System.out.println(board[end.x][end.y]);
        }
    }
    public static void bfs(){
        Queue<Location> q= new LinkedList<>();
        q.add(start);
        visited[start.x][start.y] = true;
        while(!q.isEmpty()){
            Location node = q.poll();
            int x1 = node.x;
            int y1 = node.y;

            if(x1 == end.x && y1 == end.y){
                break;
            }

            for(int i=0; i<_X.length; i++){
                int x2 = x1 + _X[i];
                int y2 = y1 + _Y[i];

                if(x2 >= 0 && x2 < board.length && y2 >= 0 && y2 < board.length && !visited[x2][y2]){
                    q.add(new Location(x2,y2));
                    visited[x2][y2] = true;
                    board[x2][y2] = board[x1][y1] + 1;
                }
            }
        }
    }
    public static class Location{
        int x;
        int y;
        public Location(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}

