package bytedance;

import java.util.*;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2023-03-01 13:49
 **/
public class bytedance_dfs {
    static int res = 0;
    static int res2 = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //初始化一个qipan
        int n = sc.nextInt();

        //四个方向
        int[][] dir = {
                {0,1},{0,-1},{1,0},{-1,0}
        };
        int[][] visited = new int[2*n+1][2*n+1];
        int[][] visited2 = new int[2*n+1][2*n+1];
        dfs(n,n,0,n,dir,visited);

        Deque<ArrayList<Integer>> queue = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(n);
        list.add(n);
        queue.add(list);
        bfs(queue,n,dir,visited2);

        System.out.println(res);
        System.out.println(res2);
    }

    private static void dfs(int x, int y, int step, int n, int[][] dir, int[][] visited){
        if(step == n){
            return;
        }
        if(visited[x][y] == 0){
            res++;
        }
        for(int i = 0;i<4;i++){
            dfs(x+dir[i][0],y+dir[i][1],step+1,n,dir,visited);
        }
    }

    private static void bfs(Queue<ArrayList<Integer>> queue, int n, int[][] dir, int[][] visited){
        while(!queue.isEmpty()){
            ArrayList<Integer> point = queue.poll();
            for(int i = 0;i < n;i++){
                for(int j = 0;j<4;j++){
                    if(visited[point.get(0)+dir[j][0]][point.get(1)+dir[j][1]] == 0){
                        visited[point.get(0)+dir[j][0]][point.get(1)+dir[j][1]] = 1;
                        res2++;
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(point.get(0)+dir[j][0]);
                        list.add(point.get(1)+dir[j][1]);
                        queue.add(list);
                    }
                }
            }

        }



    }
}
