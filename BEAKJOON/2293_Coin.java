
public class Coin {

    public static void main(String args[]){
        int[] arr1 = {1,4,6};
        int[] arr2 = {1,2,5};
        System.out.println(solution(9, arr1));
        System.out.println(solution(18, arr2));
    }
    public static int solution(int num, int[] cards){
        int[] dp = new int[num+1];
        for(int i=0; i<dp.length; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for(int i=0; i< cards.length; i++){
            for(int j=cards[i]; j<= num; j++){
                dp[j] = Math.min(dp[j], dp[j-cards[i]]+1);
            }
        }

        return dp[num];
    }
}
