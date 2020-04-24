class Solution {
    public int solution(String skill, String[] skillt) {
        int answer = 0;
        String[] word = skill.split("");
        
        int check = 0;
        int noskill = 0;
        int ps = 0;
        
        for(int i = 0; i < skillt.length; i++ ){
            
            System.out.println("checkSkill : "+skillt[i]);
            noskill = 0;
            check = 0;
            ps = skillt[i].indexOf(word[0]);
            
            for(String w : word){
                
                //있다
                if(skillt[i].contains(w)){
                    
                    System.out.println("w :"+w);
                    check++;
                    
                    //찍기전에 나온경우
                    if(noskill > 0){
                        check = 0;
                        break;
                    }
                    //순서가 틀려서 나온경우
                    if(skillt[i].indexOf(w) >= ps){
                        ps = skillt[i].indexOf(w);
                    }
                    else{
                        check = 0;
                        break;
                    }
                    //
                    
                }
                
                //없다
                else{
                    noskill++;
                }
                if(noskill == skillt[i].length()-1)
                        check++;
            }
            if(check > 0){
                System.out.println("    correct : "+skillt[i]+"\n");
                answer++;
            }
                
        }    
        
        return answer;
    }
}