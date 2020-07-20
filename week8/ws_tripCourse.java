import java.lang.reflect.Array;
import java.util.*;

class Solution {
	static boolean[] visited;
	static String	ans	 = "";
	static ArrayList<String> list = new ArrayList<>();

	public static void main(String[] args)
	{
		String[][] array = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
		String[] answer = solution(array);
		for(String s : answer)
			System.out.print(s + " ");
	}
	static String[] solution(String[][] tickets)
	{
		int count;
		for (int i = 0; i < tickets.length; i++)
		{
			visited = new boolean[tickets.length];
			String DEP = tickets[i][0];
			String ARV = tickets[i][1];
			if (DEP.equals("ICN"))
			{
				visited[i] = true;
				ans = DEP + ",";
				count = 0;
				dfs(ARV, tickets, count + 1);
				visited[i] = false;
			}
		}
		Collections.sort(list);
		String[] answer = list.get(0).split(",");
		return (answer);
	}
	static void 	dfs(String ARV, String[][] tickets, int count)
	{
		ans += ARV + ",";
		if (count == tickets.length)
		{
			list.add(ans);
			return ;
		}
		for (int i = 0; i < tickets.length; i++)
		{
			String nDEF = tickets[i][0];
			String nARV = tickets[i][1];
			if (ARV.equals(nDEF) && !visited[i])
			{
				visited[i] = true;
				dfs(nARV, tickets, count + 1);
				visited[i] = false;
				ans = ans.substring(0, ans.length()-4);;
			}
		}
	}
}