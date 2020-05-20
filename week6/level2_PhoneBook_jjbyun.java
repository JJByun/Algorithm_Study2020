public class PhoneBook {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        for(String number: phone_book){
            for(int i=0; i<phone_book.length; i++){
                if(number.equals(phone_book[i]))
                    continue;
                if(number.length() > phone_book[i].length())
                    continue;
                if(phone_book[i].startsWith(number)){
                    answer = false;
                    return answer;
                }

            }
        }
        return answer;
    }
}
