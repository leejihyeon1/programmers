package practice;

import java.util.Arrays;
import java.util.HashSet;

//summer/winter coding - 영어 끝말잇기
public class lv2_15 {
    public int[] solution(int n, String[] words) {
        //마지막 글자로 시작하거나 이전 단어와 겹치면 안됨
        //틀린 사람이 없으면 [0,0]
        //words.length%n == 몇번째 사람인지
        int[] answer = new int[2];
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            //중복된 단어인지
            if (set.contains(words[i])) {
                //탈락하는 사람 번호
                answer[0] = (i%n)+1;
                //몇번째니까 무조건 올림
                answer[1] = (i/n)+1;
                return answer;
            }
            set.add(words[i]);

            //마지막 글자와 첫 글자가 같은지
            if(i > 0) {
                char last = words[i - 1].charAt(words[i - 1].length() - 1);
                char first = words[i].charAt(0);

                if (last != first) {
                    //탈락하는 사람 번호
                    answer[0] = (i%n)+1;
                    //몇번째니까 무조건 올림
                    answer[1] = (i/n)+1;
                    return answer;
                }
            }
        }
            return answer;
        }

    public static void main(String[] args) {
        lv2_15 lv215 = new lv2_15();
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        lv215.solution(3,words);
    }
}