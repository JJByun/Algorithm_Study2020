public class MakeBigNumber {
    public String solution(String number, int k) {
        String answer = "";
        StringBuilder answers = new StringBuilder(); //StringBuffer는 값은 memory에 append하는 방식으로 클래스를 직접생성하지 않는다. 즉 클래스를 만들면서 변수나 매소드를 생성하지 않기 때문에 더 적은 시간이 걸린다.
        if(number.charAt(0) == '0') return "0";
        //가장 큰 수는 앞의 자리가 커야 함
        int maxIdx = 0;
        char maxValue = '0';
        for(int i=0; i<number.length()-k;i++){
            maxValue='0';
            for(int j=maxIdx; j<=k+i; j++ ){
                if(maxValue < number.charAt(j)){
                    maxValue = number.charAt(j);
                    maxIdx=j+1;
                }
            }
            answers.append(maxValue);
        }
        return answers.toString();

    }
}
