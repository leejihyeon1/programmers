package Greedy;

//그리디 - 조이스틱
public class joyStick_v2 {
    public int solution(String name) {
        char[] c = name.toCharArray();
        int n = name.length();
        int answer = 0;

        //1. 상하 이동 횟수
        for(int i=0; i<c.length; i++){
            //알파벳 시작은 항상 A로 시작
            answer += Math.min(c[i]-'A','Z'-c[i]+1);
        }

        //2. 좌우 이동 횟수
        int minMove = n - 1; //기본값 : 오른쪽으로 한칸씩 이동하는 경우
        for(int i = 0; i<n; i++){
            int next = i+1;

            //알파벳이 A이면 통과
            while(next < n && c[next] == 'A'){
                next++;
            }

            //i:오른쪽 방향으로 이동하면서 도달한 마지막 지점
            //next:연속된 A를 건너뛰고나서 다시 이동이 필요한 다음 지점
            //next~n-1까지가 아직 남은 편집 지점
            //ex) ...i..next...n-1
            if (next == n) {
                minMove = Math.min(minMove, i);
            } else {
                // 오른쪽 우선: i까지 갔다가 돌아와서 반대편 처리
                //i*2는 0부터 i까지, i부터 0까지 돌아오는 왕복 계산
                //n-next는 0번에서 맨 뒤로 이동하는 이동 횟수 +1을 넣음(=n-1-next +1)
                minMove = Math.min(minMove, i*2 + (n-next));

                // 왼쪽 우선 (원형 반대 방향): 반대편을 먼저 처리하고 오른쪽으로
                //0번부터 next까지 왕복 계산 후 0에서 i까지 더함
                minMove = Math.min(minMove, (n-next)*2 + i);
            }
        }

        answer += minMove;
        return answer;
    }
}