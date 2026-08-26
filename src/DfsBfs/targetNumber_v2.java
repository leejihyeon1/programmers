package DfsBfs;

// 깊이/너비 우선 탐색(DFS/BFS) - 타겟 넘버
// 사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때
// 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.
public class targetNumber_v2 {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers,target,0,0);//(배열,목표값,현재 인덱스,현재까지 합)
        return answer;
    }

    private void dfs(int[] numbers,int target,int idx, int sum){
        //배열의 모든 숫자를 다 쓴 경우
        if(idx == numbers.length){
            if(sum == target){
                answer++;
            }
            return;//재귀호출에서 return하면 메소드가 종료되는 것이 아니라 재귀호출한 자리로 돌아감
        }

        //더하는 경우
        dfs(numbers,target,idx+1,sum+numbers[idx]);
        //빼는 경우
        dfs(numbers,target,idx+1,sum-numbers[idx]);

    }
}