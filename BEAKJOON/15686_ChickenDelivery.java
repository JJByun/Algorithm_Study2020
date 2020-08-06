import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class ChickenDelivery {
    //solution number : 15686
    static int n;
    static int m;
    static int[][] board;
    static int chickenCount = 0;
    static int houseCount = 0;
    static Point[] chi;
    static Point[] house;
    static int answer = Integer.MAX_VALUE;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = inputs[0];
        m = inputs[1];
        //house = new Point[2*n+1];
        int idx = 0;
        board = new int[n+1][n+1];
        //chi = new Point[15];
        int tmpN = n;
        while(tmpN-- > 0){
            int[] p = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int i=0; i<p.length;i++){
                board[idx][i] = p[i];
                if(p[i] == 2) chickenCount++;
                if(p[i] == 1) houseCount ++;
            }
            idx++;
        }
        int chiIdx = 0;
        int houseIdx = 0;
        chi = new Point[chickenCount];
        house =new Point[houseCount];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 2){
                    chi[chiIdx++] = new Point(i,j); //치킨집 위치 넣어주기
                }
                else if(board[i][j] == 1){
                    house[houseIdx++] = new Point(i,j); //집 위치 넣어주기
                }
            }
        }
        boolean[] visited = new boolean[chi.length];
        combination(chi,visited,0,chi.length,m);

        System.out.println(answer);
    }
    static int cal(ArrayList<Point> ret){
        int retAnswer = 0;
        for(Point l : house){
            int min = Integer.MAX_VALUE;
            for(Point ch : ret){
                min = Math.min(min, getDistance(l,ch)); // 치킨 집 중에서 가장 최소인 값 계속 min 에 넣어주기
            }
            retAnswer += min;
        }
        return retAnswer;
    }
    static void combination(Point[] arr, boolean[] visited, int start, int n, int r) {
        if(r == 0) {
            ArrayList<Point> ret =new ArrayList<>();
            for(int i=0; i<arr.length;i++){
                if(visited[i]){ //선택된 것들 리스트에 넣어주기
                    ret.add(new Point(arr[i].x,arr[i].y));
                }
            }
            answer = Math.min(answer,cal(ret));
            return;
        }

        for(int i=start; i<n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    static int getDistance(Point p1, Point p2){
        return Math.abs(p1.x-p2.x) + Math.abs(p1.y-p2.y);
    }
    static class Point{
        int x;
        int y;
        Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}
