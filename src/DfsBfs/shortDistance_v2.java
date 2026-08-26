package DfsBfs;

import java.util.LinkedList;
import java.util.Queue;

// 깊이/너비 우선 탐색(DFS/BFS) - 게임 맵 최단거리
// 게임 맵의 상태 maps가 매개변수로 주어질 때,ㅡ캐릭터가 상대 팀 진영에 도착하기 위해서
// 지나가야 하는 칸의 개수의 최솟값을 return 하도록 solution 함수를 완성해주세요.
// 단, 상대 팀 진영에 도착할 수 없을 때는 -1을 return 해주세요.
public class shortDistance_v2 {
    //"최단거리" => BFS방식 (queue)
    public int solution(int[][] maps) {
        int w = maps[0].length; //가로길이
        int h = maps.length;//세로길이

        boolean[][] visited = new boolean[h][w];
        int[][] dist = new int[h][w];//이동 거리를 담을 배열
        Queue<int[]> queue = new LinkedList<>();

        //시작지점 값 세팅
        queue.offer(new int[]{0,0});
        visited[0][0] = true;
        dist[0][0] = 1;

        //상하좌우(배열의 인덱스로 생각하기)
        int[] dx = {-1,1,0,0};//x는 행(세로)-위,아래
        int[] dy = {0,0,-1,1};//y는 열(가로)-좌,우

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                //범위 안인지
                if(nx < 0 || nx >= h ||ny < 0 || ny >= w) continue;
                //벽(0)이 아닌지
                if(maps[nx][ny] == 0) continue;
                //방문 안했는지
                if(visited[nx][ny]) continue;

                visited[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;
                queue.offer(new int[]{nx,ny});

            }
        }
        return dist[h-1][w-1] == 0? -1:dist[h-1][w-1];
    }

}