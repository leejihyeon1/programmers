package FullSearch;

//완전탐색(DFS) - 모음사전
public class vowelDictionary {
    char[] vowel = {'A','E','I','O','U'}; //모음
    int cnt = 0;//몇번째 단어인지 카운트
    int answer = 0;
    String current = "";

    public int solution(String word) {
        dfs(current,word);
        return answer;
    }

    void dfs(String current,String word){
        if(current.length() == 5){
            return;
        }

        for(int i=0; i<vowel.length; i++){
            String temporary = current + vowel[i];
            cnt++;
            if(temporary.equals(word)){
                answer = cnt;
            }
            dfs(temporary,word);
        }
    }
}