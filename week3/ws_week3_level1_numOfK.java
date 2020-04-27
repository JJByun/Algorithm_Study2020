import java.util.ArrayList;


class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int[] tempArr;
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        
        for(int i = 0; i < commands.length; i++){
            int len = commands[i][1] - commands[i][0] + 1;
            tempArr = new int[len];
            
            System.arraycopy(array, commands[i][0]-1,
                             tempArr, 0, len);
            
            for(int t : tempArr)
                tempList.add(t);
            tempList.sort(null);
            
            answer[i] = tempList.get(commands[i][2]-1);
            tempList.clear();
        }
        
        return answer;
    }
}