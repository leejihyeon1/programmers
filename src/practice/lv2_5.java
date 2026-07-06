package practice;

//연습문제 - 숫자의 표현
//투포인터(left/right) 문제
public class lv2_5 {
    public int solution(int n) {
        //1. 1부터 시작해서 n이 되는 조합 찾기 (1,2,3,4,,,,15)
        //찾으면 answer 카운트 ++
        //2.1 했으면 2부터 찾기(left 이동)
        //숫자가 작으면 오른쪽에서 하나 추가, 크면 왼쪽 삭제 이런 식으로 반복

        int answer = 0;
        int left=1;//덧셈 시작 숫자
        int right=1;//덧셈 끝 숫자
        int sum=1;

        while (right <= n){
            //최종 값이 n이 됐을 때
            if(sum == n){
                answer++;
                //왼쪽(시작점) 이동(탐색했던 숫자 말고 다른 조합 찾기 위함) 1,2,3 -> 2,3
                //현재 숫자 제거니까 left를 뺀 다음에 left++ !!!!!!!!!
                sum -= left;
                left++;
            }else if(sum < n){
                //오른쪽(끝점) 이동(큰 숫자 추가) 1,2,3 -> 1,2,3,4
                //새로운 숫자 추가니까 right++ 한 다음에 right 더하기 !!!!!!!!!!
                right++;
                sum += right;
            }else{//sum > n
                //왼쪽(시작점) 이동(작은 숫자 빼기) 1,2,3 -> 2,3
                sum -= left;
                left++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        lv2_5 lv25 = new lv2_5();
        lv25.solution(15);
    }
}