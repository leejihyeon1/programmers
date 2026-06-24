package DfsBfs;

import java.util.LinkedList;
import java.util.Queue;

// 깊이/너비 우선 탐색(DFS/BFS) - 게임 맵 최단거리
// 게임 맵의 상태 maps가 매개변수로 주어질 때,ㅡ캐릭터가 상대 팀 진영에 도착하기 위해서
// 지나가야 하는 칸의 개수의 최솟값을 return 하도록 solution 함수를 완성해주세요.
// 단, 상대 팀 진영에 도착할 수 없을 때는 -1을 return 해주세요.
public class shortDistance {
    //1.문제를 단순하게 하기(BFS 문제 - 너비 우선 탐색 (끝까지 탐색!))

    //상하좌우 탐색하기 위한 배열 (dx,dy 같은 인덱스로 x,y 추출)
    private static final int[] dx = {-1,1,0,0};//위,아래 이동
    private static final int[] dy = {0,0,-1,1};//좌,우 이동

    public int solution(int[][] maps) {
        //칸의 개수 파악
        int w = maps.length;//행
        int h = maps[0].length;//열

        //BFS문제는 queue,LinkedList 사용(순서보장때문)
        Queue<int[]> queue = new LinkedList<>();//선입선출

        //출발점
        queue.offer(new int[]{0,0});

        //queue의 크기를 모르기 때문에 for대신 while 반복문 사용
        while (!queue.isEmpty()){
            int[] current = queue.poll();

            int x = current[0];
            int y = current[1];

            //상하좌우 탐색
            for(int i=0; i<4; i++){
                //현재 위치에서 한칸 움직임
                int nx = x + dx[i];
                int ny = y + dy[i];

                //맵 밖이면 패스
                if(nx<0 || ny<0 || nx>=w || ny>=h){
                    continue;
                }
                //벽이면 패스
                if(maps[nx][ny] == 0){
                    continue;
                }
                //이미 방문한 곳이면 패스(0,1밖에 없음)
                if(maps[nx][ny] > 1){
                    continue;
                }

                //거리저장(한칸 이동 했으니 +1로 이동거리 표시)
                maps[nx][ny] = maps[x][y]+1;

                queue.offer(new int[]{nx,ny});
            }
        }
        //도착점이 1이라는것은 한번도 도달 못했다는 뜻(도달하면 +1 하니까)
        //즉, 벽으로 막혀있는 것
        //w,h는 length이기 때문에 배열 인덱스로 하려면 -1 해야함
        return maps[w-1][h-1] == 1? -1 : maps[w-1][h-1];
    }
}