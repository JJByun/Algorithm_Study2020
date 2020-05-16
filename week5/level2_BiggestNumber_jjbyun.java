import java.util.*;

public class BiggestNumber {
    public static String solution(int[] numbers) {
        String [] strArr = new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
            strArr[i]=String.valueOf(numbers[i]); //문자열로 넣어주기
        }
        Arrays.sort(strArr, new myComparator());

        if(strArr[0].equals("0"))
            return "0"; //최대값이 0이라면 무조건 0임

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<strArr.length; i++){
            sb.append(strArr[i]);
        }
        System.out.println("sb: "+sb);
        return sb.toString();
    }

    public static class myComparator implements Comparator<String>{

        public int compare(String o1, String o2){
            String s1 = o1+o2;
            String s2 = o2+o1;
            if(Integer.parseInt(s1) > Integer.parseInt(s2))
                return -1;
            else if(Integer.parseInt(s1) == Integer.parseInt(s2))
                return 0;
            else
                return 1;
        }
    }
}
