class Solution {
    boolean solution(String s) {
        boolean answer = true;

        int pcount = 0;
        int ycount = 0;
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'P' || s.charAt(i) == 'p')
                pcount++;
            else if(s.charAt(i) == 'Y' || s.charAt(i) == 'y')
                ycount++;
        }
        if(pcount == 0 && ycount == 0)
            return true;
        else if(pcount == ycount)
            answer = true;
        else if(pcount != ycount)
            answer = false;

        return answer;
    }
}