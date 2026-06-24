package DfsBfs;

// 깊이/너비 우선 탐색(DFS/BFS) - 타겟 넘버
// 사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때
// 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.
public class targetNumber {
    //1.문제를 단순하게 하기 (DFS 문제 - 깊이 우선 탐색 (끝까지 탐색!))
    int answer = 0;
    public int solution(int[] numbers, int target) {
        //2.numbers의 각 숫자 별 +,- 경우의 수 트리 구조로 그리기
        dfs(numbers,target,0,0); //최초 호출

        return answer;
    }

    private void dfs(int[] numbers,int target,int index, int sum){
        if(index == numbers.length){
            //3.모든 경우 중 합계가 target과 같은 것 구하기
            if(sum == target){
                answer++;
            }
            return;
        }

        //+,- 2가지 경우
        dfs(numbers,target,index+1, sum + numbers[index]);
        dfs(numbers,target,index+1, sum - numbers[index]);
    }
}