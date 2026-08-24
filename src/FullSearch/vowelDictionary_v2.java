package FullSearch;

//완전탐색(DFS) - 모음사전
public class vowelDictionary_v2 {
    char[] vowel = {'A','E','I','O','U'};
    int count=0;
    int answer = 0;

    public int solution(String word) {
        dfs("",word);
        return answer;
    }

    private void dfs(String current, String word){
        if(!current.equals("")){
            count++;

            if(current.equals(word)){
                answer = count;
                return;
            }
        }

        if(current.length() == 5) return;

        for(char c : vowel){
            dfs(current+c,word);
        }
    }
}