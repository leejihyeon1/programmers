package practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

//연습문제 - 롤케이크 자르기
public class lv2_21 {
    public int solution(int[] topping) {
        //반복 돌면서 가짓수 체크해서 동일하면 cnt+1
        HashSet<Integer> olderSet = new HashSet<>();
        HashMap<Integer,Integer> youngerMap = new HashMap<>();

        //동생은 토핑 별 개수를 저장해서
        //형한테 준 토핑의 개수를 -1
        for(int i=0; i<topping.length; i++){
            //hashmap은 key값이 중복되면 value가 덮어써짐
            youngerMap.put(topping[i]
                    ,youngerMap.getOrDefault(topping[i],0)+1);
        }

        int cnt = 0;
        //형 set에 추가
        for(int i=0; i<topping.length; i++){
            olderSet.add(topping[i]);

            youngerMap.put(topping[i],youngerMap.get(topping[i])-1);
            //topping[i]-1이 0이면 map에서 제거
            if(youngerMap.get(topping[i]) == 0){
                youngerMap.remove(topping[i]);
            }

            if(olderSet.size() == youngerMap.size()){
                cnt++;
            }
        }
        return cnt;
    }
}