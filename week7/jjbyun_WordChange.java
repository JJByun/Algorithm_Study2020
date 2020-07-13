import java.util.*;
class WordChange {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean check = false;
        //예외처리 < -찾는게 없는 경우
        for(String word : words)
            if(word.equals(target)){
                check = true;
                break;
            }
        if(check == false) return 0;

        List<wordPair> list = new ArrayList<>(); //방문한 문자는 재방문하지 않게 인덱싱 부여
        for(int i=0; i<words.length; i++){
            list.add(new wordPair(words[i],i));
        }
        Queue<String> q = new LinkedList<>();
        q.add(begin);
        boolean[] b= new boolean[52];
        int cnt =0;
        boolean ok = false;
        //bfs시작
        while(!q.isEmpty()){
            for(int i=0; i<q.size(); i++){
                String cur = q.peek();
                q.poll();
                if(cur.equals(target)){ //찾았다면 탈출
                    ok = true;
                    break;
                }
                for(int j=0; j<list.size(); j++){ //list를 돌면서 아직 안찾아간 값 찾아주기
                    String t_word;
                    int t_idx;
                    t_word = list.get(j).word;
                    t_idx = list.get(j).index;
                    if(b[t_idx] == true) continue;
                    if(check_diff(cur,t_word)){
                        System.out.println(t_word);
                        q.add(t_word);
                        b[t_idx]=true;
                    }
                }

            }
            if(ok) break;
            cnt++;
        }
        if(ok) answer=cnt;
        return answer;
    }

    public boolean check_diff(String s1, String s2){
        int count = 0;
        for(int i=0; i<s1.length(); i++)
            if(s1.charAt(i) != s2.charAt(i))
                count++;
        if(count == 1)
            return true;
        else
            return false;
    }

    public class wordPair{
        String word;
        int index;
        public wordPair(String word, int index){
            this.word = word;
            this.index = index;
        }
    }
}