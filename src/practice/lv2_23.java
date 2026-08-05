package practice;

import java.util.LinkedList;
import java.util.Queue;

//연습문제 - 숫자 변환 하기
public class lv2_23 {
    public int solution(int x, int y, int n) {
        //사용 가능한 경우의 수
        //1.x + n
        //2.x * 2
        //3.x * 3
        // 이미 x가 y라면 연산할 필요 없음
        if (x == y) {
            return 0;
        }
        // [현재 숫자, 연산 횟수]
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,0});
        // 방문 체크
        //x를 정수 숫자 그래도 배열 인덱스로 사용하기 위한 +1
        boolean[] visited = new boolean[y + 1];
        visited[x] = true;//x를 큐에 넣었으니 방문 했음 표시

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int num = current[0];
            int cnt = current[1];

            if(num == y) {
                return cnt;
            }

            // 만들 수 있는 다음 숫자 3개
            int[] next = {
                    num + n,
                    num * 2,
                    num * 3
            };

            for (int nextNum : next) {
                // y보다 크면 볼 필요 없음
                if (nextNum > y) {
                    continue;
                }

                // 이미 방문한 숫자는 다시 탐색하지 않음
                if (visited[nextNum]) {
                    continue;
                }

                // y를 만들었다면 현재 연산 + 1
                if (nextNum == y) {
                    return cnt + 1;
                }

                visited[nextNum] = true;
                queue.offer(new int[]{nextNum, cnt + 1});
            }

        }
        return -1;
    }
}