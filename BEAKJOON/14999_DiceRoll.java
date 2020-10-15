import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_14999_DiceRoll {
    //solution number : 14999 - 주사위 굴리기
    static final int BOTTOM = 5;
    static final int UP = 0;
    static final int FRONT = 1;
    static final int LEFT = 2;
    static final int RIGHT = 3;
    static final int BACK = 4;
    static int[][] board;
    static int N;
    static int M;
    static final int[] dx={-1,1,0,0};
    static final int[] dy={0,0,-1,1};
    static int x2;
    static int y2;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        N = Integer.parseInt(strs[0]);
        M = Integer.parseInt(strs[1]);
        Dice d = new Dice(Integer.parseInt(strs[2]),Integer.parseInt(strs[3]));
        int itr = Integer.parseInt(strs[4]);
        board = new int[N][M];
        for(int i=0; i<N; i++){
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j=0; j<M; j++){
                board[i][j] = arr[j];
            }
        }
        int[] command = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int i=0; i<command.length; i++){
            int cur = command[i];
            move(cur,d.x,d.y);
            if(x2 < 0 || x2 >= N || y2 < 0 || y2>=M) continue;
            changeDice(cur, d);
            d.x=x2;
            d.y=y2;
            if(board[x2][y2] == 0){
                //주사위 바닥의 값이 칸에 복사
                board[x2][y2] = d.numbers[BOTTOM];
            }else{
                //칸의 값이 주사위 바닥에 복사
                d.numbers[BOTTOM] = board[x2][y2];
                //칸의 수 ==0 으로 바꿔주기
                board[x2][y2] = 0;
            }
            System.out.println(d.numbers[0]);
        }
    }
    public static void changeDice(int com, Dice d){
        int[] tmp = new int[6]; //임시배열
        for(int i=0; i<tmp.length; i++)
            tmp[i] = d.numbers[i];
        if(com==1){
            d.numbers[RIGHT] = tmp[UP];
            d.numbers[UP] = tmp[LEFT];
            d.numbers[LEFT] = tmp[BOTTOM];
            d.numbers[BOTTOM] = tmp[RIGHT];
        }else if(com==2){
            d.numbers[UP] = tmp[RIGHT];
            d.numbers[LEFT] = tmp[UP];
            d.numbers[BOTTOM] = tmp[LEFT];
            d.numbers[RIGHT] = tmp[BOTTOM];
        }else if(com==3){
            d.numbers[FRONT] = tmp[UP];
            d.numbers[BACK] = tmp[BOTTOM];
            d.numbers[BOTTOM] = tmp[FRONT];
            d.numbers[UP] = tmp[BACK];
        }else{
            d.numbers[UP] = tmp[FRONT];
            d.numbers[BACK] = tmp[UP];
            d.numbers[BOTTOM] = tmp[BACK];
            d.numbers[FRONT] = tmp[BOTTOM];
        }
    }
    public static void move(int command, int x, int y){
        if(command == 1){ //동
            x2 = x;
            y2 = y+1;
        }else if(command == 2){ //서
            x2 = x;
            y2 = y-1;
        }else if(command == 3){ //북
            x2 = x-1;
            y2 = y;
        }else{ //남
            x2 = x+1;
            y2 = y;
        }
    }
    public static class Dice{
        int x;
        int y;
        //0 -> 맨위 1 -> 앞쪽 2->오른쪽 3->왼쪽 4->뒤쪽 5->밑바닥
        int[] numbers = new int[6]; //배열에 주사위에 적힌 숫자 저장
        public Dice(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}
