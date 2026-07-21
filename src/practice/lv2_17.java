package practice;

import java.util.HashMap;
import java.util.Map;

//연습문제 - 할인 행사
// map + 슬라이딩 윈도우
public class lv2_17 {
    public int solution(String[] want, int[] number, String[] discount) {
        //1. 원하는 제품을 개수만큼 반복해서 맵에 담기(제품,수량)
        int answer = 0;
        Map<String,Integer> wantMap = new HashMap<>();
        Map<String,Integer> discountMap= new HashMap<>();//10일 비교 목적

        for(int i=0; i<want.length; i++){
            wantMap.put(want[i],number[i]);
        }
        //10개 세팅
        for(int i=0; i<10; i++){
            discountMap.put(discount[i],discountMap.getOrDefault(discount[i],0)+1);//있으면 +1
        }

        //2. wantMap과 discountMap이 같은지 비교
        //다르면 앞에 하나 제거, 뒤에 하나 추가(한칸씩 밀리게)
        if(wantMap.equals(discountMap)) {
            answer++;
        }
        for(int i=10; i<discount.length; i++){//key,value 다 같아야 true
            discountMap.put(discount[i-10],discountMap.get(discount[i-10])-1);
                if(discountMap.get(discount[i-10]) == 0){
                    discountMap.remove(discount[i-10]);
                }
            discountMap.put(discount[i],discountMap.getOrDefault(discount[i],0)+1);
            if(wantMap.equals(discountMap)) {
                answer++;
            }
        }

        //3. 맵이 비었으면 모두 할인 가능 날짜 카운트 증가
        return answer;
    }

    public static void main(String[] args) {
        lv2_17 lv217 = new lv2_17();
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number={3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        lv217.solution(want,number,discount);
    }
}