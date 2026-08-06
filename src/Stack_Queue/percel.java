package Stack_Queue;

import java.util.Stack;

//연습문제 - 택배상자
public class percel {
    public int solution(int[] order) {
        //1.택배차 컨테이너 벨트는 선입선출(큐)
        //2.보관용 컨테이너 벨트는 후입선출(스택)
        //order 배열에 맞게 1,2,3,4,5인 택배를 몇개 실을 수 있는지
        int answer = 0;
        int box =1; //택배차 인덱스(택배번호와 동일함)
        int idx=0;//주문 인덱스
        Stack<Integer> temporary = new Stack<>();//보관용

        while (box <= order.length){
            //택배 순서와 주문 순서가 같을때
            if(box == order[idx]){
                answer++;
                box++;
                idx++;

                 //보관 벨트에 있는 것과 주문이 같은지 비교
                while(!temporary.isEmpty()&&idx<order.length){
                    if(temporary.peek() == order[idx]){
                        answer++;
                        idx++;
                        temporary.pop();
                    }else{
                        break;
                    }
                }
            }else{
                temporary.push(box);
                box++;
            }
        }

        //택배 벨트가 끝나도 보관 벨트가 남아있을 수도 있음
        while(!temporary.isEmpty()&&idx<order.length){
            if(temporary.peek() == order[idx]){
                answer++;
                idx++;
                temporary.pop();
            }else{
                break;
            }
        }
        return answer;
    }
}