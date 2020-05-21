import java.util.ArrayList;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        ArrayList<String> list = new ArrayList<>();
        for(String string : phone_book)
        	list.add(string);
        list.sort(null);
        
      //i번째 단어와 j번째 단어 비교
        for(int i = 0; i < phone_book.length-1; i++) {
        	for(int j = i+1; j < phone_book.length; j++) {
        		//i번째 단어의 0 ~ n번째 글자의 비교
        		for(int n = 0; n < list.get(i).length(); n++) {
        			if(n >= list.get(j).length()) {
        				answer = true;
        				break;
        			}
        			if(list.get(i).charAt(n) == list.get(j).charAt(n)) {
        				answer = false;
                	}
    				else {
    					answer = true;
    					break;
    				}
        		}
        		System.out.println("==");
        		if(answer == false)
        			return false;
        	}
        }
        
        return answer;
    }
}