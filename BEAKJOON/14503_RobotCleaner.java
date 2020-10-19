
import java.util.*;

public class BOJ_14503_RobotCleaner {
    //solution number : 14503 - 로봇 청소기

    static int[][] map = new int[50][50];
    static int[] dx = { 0, 1, 0, -1 }; // 북 동 남 서
    static int[] dy = { -1, 0, 1, 0 };
    static boolean[][] visited = new boolean[50][50];
    static Robot start;
    static int m, n, ans;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();

        int s = sc.nextInt();
        int e = sc.nextInt();
        int d = sc.nextInt();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        start = new Robot(s, e, d);
        visited[s][e] = true;

        bfs();
        System.out.println(ans + 1);
    }

    public static void bfs() {
        Queue<Robot> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            Robot pos = q.poll();
            int d = pos.d;
            int y = pos.r;
            int x = pos.c;

            int nextDirection = d;
            int nx = 0;
            int ny = 0;
            boolean flag = false;

            // 왼쪽 방향에 청소하지 않은 구역 탐색
            for (int i = 0; i < 4; i++) {
                nextDirection = turnDirection(nextDirection);
                nx = dx[nextDirection] + x;
                ny = dy[nextDirection] + y;
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (map[ny][nx] == 0 && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        ++ans;
                        q.add(new Robot(ny, nx, nextDirection));
                        flag = true;
                        break;
                    }
                }
            }

            // 후진
            if (!flag) {
                nextDirection = backDirection(d);
                nx = dx[nextDirection] + x;
                ny = dy[nextDirection] + y;

                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (map[ny][nx] == 0) {
                        q.add(new Robot(ny, nx, d));
                    }
                }
            }

        }
    }

    public static int backDirection(int d) {
        if (d == 0) {
            return 2;
        } else if (d == 1) {
            return 3;
        } else if (d == 2) {
            return 0;
        } else {
            return 1;
        }
    }

    public static int turnDirection(int d) {
        // 0 북, 1 동, 2 남, 3 서
        if (d == 0) {
            return 3;
        } else if (d == 1) {
            return 0;
        } else if (d == 2) {
            return 1;
        } else {
            return 2;
        }
    }

    public static class Robot {
        int r;
        int c;
        int d;

        Robot(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }



//    static final int[] dx = {0,0,-1,1};
//    static final int[] dy = {-1,1,0,0};
//    static final int UP = 0;
//    static final int RIGHT = 1;
//    static final int DOWN = 2;
//    static final int LEFT = 3;
//    static int N;
//    static int M;
//    static int[][] board;
//    static boolean[][] visited;
//    static int ret=0;
//    public static void main(String args[]) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] strs = br.readLine().split(" ");
//        N= Integer.parseInt(strs[0]);
//        M= Integer.parseInt(strs[1]);
//        board = new int[N][M];
//        visited = new boolean[N][M];
//        int[] ins = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//        Robot r = new Robot(ins[0],ins[1],ins[2]);
//
//        for(int i=0; i<N; i++){
//            int[] in = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//            for(int j=0; j<M; j++){
//                board[i][j] = in[j];
//            }
//        }
//        Queue<Robot> q = new LinkedList<>();
//        q.add(r);
//
//        while(!q.isEmpty()){
//            Robot cur = q.poll();
//            int x = cur.x;
//            int y = cur.y;
//            if(!visited[cur.x][cur.y]) {
//                visited[cur.x][cur.y] = true;
//                ret++;
//            }
//            if(isEnd(cur)){
//                break;
//            }
//            //2-a
//            if(cur.dir==UP){
//                if(board[x][y-1] == 0 && !visited[x][y-1]){
//                    q.add(new Robot(x,y-1,LEFT));
//                    continue;
//                }
//            }else if(cur.dir == LEFT){
//                if(board[x+1][y] == 0 && !visited[x+1][y]){
//                    q.add(new Robot(x+1,y,DOWN));
//                    continue;
//                }
//            }else if(cur.dir == RIGHT){
//                if(board[x-1][y] == 0 && !visited[x-1][y]){
//                    q.add(new Robot(x-1,y,UP));
//                    continue;
//                }
//            }else{
//                if(board[x][y+1] == 0 && !visited[x][y+1]){
//                    q.add(new Robot(x,y+1,LEFT));
//                    continue;
//                }
//            }
//            //여기까지 나왔다면 2-a는 만족하지 않은거임
//
//            //move();
//        }
//        System.out.println(ret);
//    }
//    public static boolean isEnd(Robot r){
//        int x = r.x;
//        int y =r.y;
//        boolean b = true;
//        for(int i=0; i<4; i++){
//            int x2 = x +dx[i];
//            int y2 = y + dy[i];
//            if(x2 < 0 || x2 >=N || y2 < 0 || y2>=M) continue;
//
//            if(board[x2][y2] == 0 && !visited[x2][y2]) return false;
//        }
//        //여기까지 나왔다면 4방향이 모두 청소됐거나 벽인거임
//        if(x>0){
//            if(board[x-1][y] == 1) return true;
//        }else
//            return true;
//        return true;
//    }
//    static class Robot{
//        int x;
//        int y;
//        int dir;
//        Robot(int x, int y ,int dir){
//            this.x=x;
//            this.y=y;
//            this.dir=dir;
//        }
//    }
}
