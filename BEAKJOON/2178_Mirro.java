import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class mirro {
    static int[] dr = {1,-1,0,0}; //좌표 설정
    static int[] dc = {0,0,-1,1};
    static boolean[][] visited; //방문 체크
    static int[][] map; //map 저장 배열
    static int N,M;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        bfs(0,0);

        System.out.println(map[N-1][M-1]); //배열에 저장하므로 마지막 배열이 정답이 된다
    }

    public static void bfs(int i, int j){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {i,j});

        //bfs 기본형식
        //1. queue에 첫번재 원소 넣어주기
        //2. queue가 빌때까지 반복
        //3. queue에서 맨 앞의 값 꺼내서 처리
        //조건을 만족하면 다음 원소 queue에 넣어주기
        while(!q.isEmpty()){
            int location[] = q.poll();
            visited[i][j] = true;

            for(int dir = 0; dir<4; dir++){ //4가지 case를 for문으로 돌려주기
                int r = location[0] + dr[dir];
                int c = location[1] + dc[dir];

                //좌표가 -1이 되거나 N or M이 되어 map의 범위를 벗어나면 안되므로
                if(r >= 0 && c >= 0 && r < N && c < M){
                    if(map[r][c] != 0 && !visited[r][c]){
                        q.offer(new int[] {r,c});
                        visited[r][c] = true;
                        map[r][c] = map[location[0]][location[1]] + 1; //마지막 나가야하는 경우를 위해 하나 더 더해줌
                    }
                }
            }
        }
    }
}
