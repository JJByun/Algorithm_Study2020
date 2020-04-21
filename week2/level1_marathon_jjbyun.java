import java.util.Arrays;

public class marathon {
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);


        for(int i=0; i<participant.length-1; i++){
            if(!participant[i].equals(completion[i])){
                answer = participant[i];
                break;
            }
        }
        //answer = participant[participant.length-1];

        /*ArrayList<String> list = new ArrayList <String> ();

        for(String s:participant){
            list.add(s); //list에 넣어주기
        }
        for(String s:completion){
            list.remove(s);
        }
        for(String s: list){
            answer = s;
        }*/
        if(answer.equals(""))
            answer = participant[participant.length-1];
        return answer;
    }

}
