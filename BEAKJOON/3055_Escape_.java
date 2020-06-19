import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Escape {
    public static char [][] board;
    public static location end = null;
    public static int count = 0;
    public static boolean isEnd = false;
    public static Queue<location> wq = new LinkedList<>();
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static boolean [][] isMoved;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] ss = br.readLine().split(" ");
        int M = Integer.parseInt(ss[0]);
        int N = Integer.parseInt(ss[1]);
        //board 생성
        board = new char[M][N];
        isMoved = new boolean[M][N];
        location start = null;
        for(int i=0; i<M; i++){
            String strs = br.readLine();
            for(int j=0; j<strs.length();j++){
                if(strs.charAt(j) == 'S')
                    start = new location(i,j);
                if(strs.charAt(j) == 'D')
                    end = new location(i,j);
                if(strs.charAt(j) == '*')
                    wq.add(new location(i,j));
                board[i][j] = strs.charAt(j);
            }
        }
        bfs(start);
        if(!isEnd)
            System.out.println("KAKTUS");
        else
            System.out.println(count);
    }
    public static void bfs(location startNode){
        Queue<location> q = new LinkedList<>();
        q.add(startNode);
        isMoved[startNode.i][startNode.j] = true;
        while(!isEnd){
            //물 이동 먼저
            waterMove();
            count++;
            int qSize = q.size();
            if(qSize == 0) //더이상 들어온것이 아무것도 없으면 못가는것임
                break;
            for(int n=0; n<qSize;n++){ //큐에 있는 노드만큼 두더지 펴주기
                location node = q.poll();
                int i = node.i;
                int j = node.j;

                //이동 조건 체크
                for(int k=0; k<4; k++){
                    int dnx = i + dx[k];
                    int dny = j + dy[k];
//                    System.out.println("dnx dny: "+dnx + " "+dny);
                    if(dnx < 0 || dnx >= board.length || dny < 0 || dny >= board[0].length) continue;
                    //종료조건
                    if(board[dnx][dny] == 'D'){
                        isEnd = true;
                        break;
                    }
                    if(board[dnx][dny] == '.' && !isMoved[dnx][dny]){
                        q.add(new location(dnx,dny));
//                        System.out.println(dnx+" "+dny+" 넣기");
                        isMoved[dnx][dny] = true;
                    }

                }

            }
        }
    }
    public static void waterMove(){
        int wqSize = wq.size();
        while(wqSize-- > 0){
            location l = wq.poll();
            for(int i=0; i<4; i++){
                int dnx = l.i + dx[i];
                int dny = l.j + dy[i];
                if(dnx < 0 || dnx >= board.length || dny < 0 || dny >= board[0].length) continue;
                if(board[dnx][dny] == '.' || board[dnx][dny] =='S'){
                    board[dnx][dny] = '*';
                    wq.add(new location(dnx,dny));
                }
            }

        }

    }// end water()
    public static class location{
        int i;
        int j;
        public location(int i, int j){
            this.i=i;
            this.j=j;
        }
    }
}
