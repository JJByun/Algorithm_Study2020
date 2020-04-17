import java.util.Stack;

public class level1_week1 {

    int[][] _board;
    int[] _moves;
    Stack<Integer> stack = new Stack<>();
    int answer = 0;

    public int solution(int[][] board, int[] moves) {
        _board = board;
        _moves = moves;
        int boardSize = board.length; //보드 사이즈

        for(int i=0; i<_moves.length;i++){
            int getIndex = _moves[i];
            boolean b;
            pushStack(getIndex-1, boardSize);
            checkBomb();
        }
        return answer;
    }

    public boolean pushStack(int index, int boardSize){
        int getNum=0;
        //위부터 검사
        for( int i=0; i<boardSize; i++){
            if(_board[i][index] != 0){
                getNum = _board[i][index];
                _board[i][index]=0;
                break;
            }
        }

        if(getNum != 0){
            stack.push(getNum); //stack에 넣어주기
            return true;
        }
        //아무것도 없는 경우는 false 리턴
        return false;
    }

    public void checkBomb(){
        if(stack.size() >=2 ){
            int n1 = stack.pop();
            int n2 = stack.pop();
            if(n1 == n2 ){
                answer += 2;
            }
            else{
                stack.push(n2);
                stack.push(n1);
            }
        }
    }
}
