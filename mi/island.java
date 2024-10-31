package mi;
import java.util.*;
import java.util.regex.*;
/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2023-09-23 16:49
 **/
public  class island {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String regEX = "[^0-9]";
        Pattern p = Pattern.compile(regEX);
        Matcher m = p.matcher(s);
        String str = m.replaceAll("").trim();
        int sidelength = (int)Math.sqrt(str.length());
        char[][] grid  = new char[sidelength][sidelength];
        int count = 0;
        for(int i = 0;i < sidelength;i++){
            for(int j = 0;j < sidelength;j ++){
                grid[i][j] = str.charAt(count);
                count++;
            }
        }
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid){
        int res = 0;
        for(int i = 0;i < grid.length;i++){
            for(int j = 0;j < grid[0].length;j++){
                if(grid[i][j] == '1'){
                    dfs(grid,i,j);
                    res++;
                }
            }
        }
        return res;
    }

    public static void dfs(char[][] grid,int r,int c){
        if(!inArea(grid,r,c)){
            return;
        }
        if(grid[r][c] != '1'){
            return;
        }
        grid[r][c] = '2';
        dfs(grid,r-1,c);
        dfs(grid,r+1,c);
        dfs(grid,r,c-1);
        dfs(grid,r,c+1);
    }

    public static boolean  inArea(char[][] grid,int r,int c){
        return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length;
    }
}
