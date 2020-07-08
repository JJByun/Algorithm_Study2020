public class TargetNumber {
    static class Solution {
        static int answer = 0;
        static int targetNum;
        public int solution(int[] numbers, int target) {
            targetNum = target;
            dfs(numbers, 0, numbers.length, 0);

            return answer;
        }
        public void dfs(int[] numbers, int depth, int n, int sum){
            //termination check
            if(depth == n){
                if(sum == targetNum)
                    answer++;
                return;
            }
            //recursion
            dfs(numbers, depth+1, n, sum + numbers[depth]);
            dfs(numbers, depth+1, n, sum - numbers[depth]);
        }
    }
}
