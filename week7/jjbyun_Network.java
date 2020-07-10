public class Network {
    class Solution {
        public int solution(int n, int[][] computers) {
            int answer = 0; //찾으려는 것: 연결된 그래프의 개수
            boolean[] visited = new boolean[n];

            for(int i=0; i<n; i++){
                if(!visited[i]) //방문하지 않은 것, 즉 연결되지 않은 노드의 개수
                    answer += dfs(i,computers,visited);
            }
            return answer;
        }
        public int dfs(int i, int[][] computers, boolean[] visited){
            if(visited[i])
                return 0;
            visited[i] = true;
            for(int j=0; j<computers[i].length; j++){ //연결된것들 visited[i] = true 로 만들어주기
                if(computers[i][j] == 1)
                    dfs(j,computers,visited);
            }
            return 1; //탐색이 끝나면 무조건 1 증가시켜주기
        }
    }
}
