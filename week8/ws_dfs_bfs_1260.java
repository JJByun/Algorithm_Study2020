import java.util.*;

public class dfs_bfs_1260 {
	static int	N;	//정점의 개수
	static int	M;	//간선의 개수
	static int	V;	//start node
	static int	D;	//탐색 깊
	static boolean[][]	visited;	//방문한 좌표 체크
	static int[][] graphNN;
	static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		D = 0;
		graphNN = new int[N + 1][N + 1];
		visited = new boolean[N + 1][N + 1];
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				graphNN[i][j] = 0;
			}
		}
		int	L = 0;
		while (L < M) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			graphNN[x][y] = 1;
			L++;
		}
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				System.out.print(graphNN[i][j]);
			}
			System.out.println();
		}
		list.add(V);
		dfs(V);
		for (int l : list)
			System.out.print(l + " ");
	}

	static void dfs(int start)
	{
		if (!list.contains(start))
			list.add(start);
		for (int n = 1; n <= N; n++) {
			if (graphNN[start][n] == 1) {
				graphNN[start][n] = 0;
				dfs(n);
			}
			else if(graphNN[n][start] == 1) {
				graphNN[n][start] = 0;
				dfs(n);
			}
		}
	}
}