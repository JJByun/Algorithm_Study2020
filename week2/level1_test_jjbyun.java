import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};

        int answer1=0;
        int answer2=0;
        int answer3=0;

        int count1=0;
        int count2=0;
        int count3=0;

        for(int i:answers){

            if(count1<one.length){
                if(one[count1]==i){
                    answer1++;
                }
                count1++;
            }else{
                count1=0;
                if(one[count1]==i){
                    answer1++;
                }
                count1++;

            }


            if(count2<two.length){
                if(two[count2]==i)
                    answer2++;
                count2++;
            }else{
                count2=0;
                if(two[count2]==i)
                    answer2++;
                count2++;
            }


            if(count3<three.length){
                if(three[count3]==i)
                    answer3++;
                count3++;
            }else{
                count3=0;
                if(three[count3]==i)
                    answer3++;
                count3++;

            }
        }


        System.out.println(answer1);
        System.out.println(answer2);
        System.out.println(answer3);

        //첫번째가 제일 큰 경우
        if(answer1 > answer2 && answer1 > answer3){
            list.add(1);
        }
        else if(answer2 > answer3 && answer2 > answer1){
            list.add(2);
        }else if(answer3 > answer1 && answer3 > answer2){
            list.add(3);
        }else if(answer1 == answer2 && answer1 > answer3){
            list.add(1);
            list.add(2);
        }else if(answer1 == answer3 && answer1 > answer2){
            list.add(1);
            list.add(3);
        }else if(answer2 == answer3 && answer3 > answer1){
            list.add(2);
            list.add(3);
        }else if(answer1 == answer2 && answer2 == answer3){
            list.add(1);
            list.add(2);
            list.add(3);
        }


        System.out.println(list);
        return convertIntegers(list);
    }
    public static int[] convertIntegers(ArrayList<Integer> integers)
    {
        int[] ret = new int[integers.size()];
        for (int i=0; i < ret.length; i++)
        {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }
}