public class _2016 {
    public String solution(int a, int b) {
        String answer = "";
        final int[] months = {31,29,31,30,31,30,31,31,30,31,30,31};
        final String [] DAYS = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
        int days_sum=0;
        for(int i=0; i<a-1;i++){
            days_sum+=months[i];
        }
        days_sum+=b-1;
        int rest = days_sum % 7;
        System.out.println(rest);
        System.out.println(days_sum);
        answer = DAYS[rest];
        return answer;
    }
}
