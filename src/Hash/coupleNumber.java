package Hash;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

//연습문제 - 숫자 짝꿍
public class coupleNumber {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();

        Map<Character,Integer> xMap = new HashMap<>();
        Map<Character,Integer> yMap = new HashMap<>();

        for(char s:X.toCharArray()){
            xMap.put(s,xMap.getOrDefault(s,0)+1);
        }
        for(char s:Y.toCharArray()){
            yMap.put(s,yMap.getOrDefault(s,0)+1);
        }

        for(char x: xMap.keySet()){
            if(yMap.containsKey(x)){
                int min = Math.min(yMap.get(x),xMap.get(x));

                for(int i=0; i<min; i++){
                    answer.append(x);
                }
            }

        }
        if(answer.length() == 0){
            return "-1";
        }

        String[] answerArr = answer.toString().split("");
        Arrays.sort(answerArr, Comparator.reverseOrder());

        StringBuilder sb = new StringBuilder();


        for(int i=0; i<answerArr.length; i++){
            if(i == 0 && answerArr[i].equals("0")){
                return "0";
            }
            sb.append(answerArr[i]);
        }

        return sb.toString();
    }
}