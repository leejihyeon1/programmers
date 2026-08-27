package Greedy;

import java.util.Stack;

//그리디(탐욕법) - 큰 수 만들기
public class makeLargeNumber_v2 {
    public String solution(String number, int k) {
        //스택으로 숫자 크기 비교
        Stack<Integer> stack = new Stack<>();
        String[] arr = number.split("");
        stack.push(Integer.parseInt(arr[0]));

        int cnt = 0;//제거한 개수
        int idx = 1;
        while(cnt < k && idx <= arr.length-1){
            int num = Integer.parseInt(arr[idx]);

            //작은 수가 앞이면 제거하고 추가
            while(!stack.isEmpty() && stack.peek() < num && cnt < k){
                stack.pop();
                cnt++;
            }
            //큰 수가 앞이면 뒤에 추가
            idx++;
            stack.push(num);
        }

        //cnt가 k에 도달 못하고 while문이 끝난 경우 (앞 숫자들이 항상 큰 경우)
        while(cnt < k){
            stack.pop();
            cnt++;
        }

        //k만큼 제거 후 남은 수 이어 붙이기
        StringBuilder sb = new StringBuilder();
        for(Integer i : stack){
            sb.append(Integer.toString(i));
        }
        sb.append(number.substring(idx));
        return sb.toString();
    }
}