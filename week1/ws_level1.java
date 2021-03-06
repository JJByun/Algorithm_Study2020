import java.util.ArrayList;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        ArrayList<Integer> basket= new ArrayList<>();
        
        //이동할 위치값의 개수 만큼 반복
        for(int i = 0; i < moves.length; i++) {
            //보드의 깊이만큼 반복
            for(int j = 0; j < board.length; j++) {
                //보드의 j깊이, i위치에 값이 있으면
                if(board[j][moves[i]-1] != 0) {
                    //리스트에 값을 추가하고 0으로 초기화후 탈출
                    basket.add(board[j][moves[i]-1]);
                    board[j][moves[i]-1] = 0;
                    break;
                }
            }
        }
        //꺼내온 아이콘에 대한 리스트의 길이에 만큼 반복
        for(int i = 0; i < basket.size()-1; i++) {
            if(basket.get(i) == basket.get(i+1)) {
                answer+=2;
                basket.remove(i+1);
                basket.remove(i);
                i = -1;
            }
        }
        return answer;
    }
}