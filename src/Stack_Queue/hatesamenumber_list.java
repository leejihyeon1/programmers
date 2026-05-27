package Stack_Queue;

// 스택/큐 - 같은 숫자는 싫어
//배열 arr에서 연속적으로 나타나는 숫자는 제거하고 남은 수들을 return 하는 solution 함수를 완성해 주세요.

import java.util.ArrayList;
import java.util.List;

public class hatesamenumber_list {
    //1. 문제 간단하게 만들기
    public int[] solution(int []arr) {
        //2. 배열은 크기를 명시해줘야하기 때문에 리스트에 담은 후 배열로 옮길 예정
        List<Integer> result = new ArrayList<>();
        int num = arr[0];
        result.add(num);
        for(int a : arr){
            if(num != a){
                num = a;
                result.add(a);
            }
        }
        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        hatesamenumber_list test = new hatesamenumber_list();
        int[] arr = new int[]{1,1,3,3,0,1,1};
        test.solution(arr);
    }
}