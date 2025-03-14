package hot100;

import java.util.Scanner;
import java.util.Stack;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2025-03-14 13:04
 **/
public class maximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int h = matrix.length;
        int w = matrix[0].length;
        int[] heights = new int[w];
        int maxArea = 0;
        for(int i = 0;i < h;i++){
            for(int j = 0;j < w; j++){
                if(matrix[i][j] == '1'){
                    heights[j]++;
                }else{
                    heights[j] = 0;
                }
            }
            maxArea = Math.max(maxArea,largestRectangleArea(heights));
        }
        return maxArea;
    }

    public int largestRectangleArea(int[] heights){
        int n = heights.length;
        int maxRowArea = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i < n;i++){
            while(!stack.isEmpty() && heights[i] < heights[stack.peek()]){
                //取出下标
                int h = heights[stack.pop()];
                int left = stack.isEmpty() ? -1 : stack.peek();
                int w = i - left - 1;
                maxRowArea = Math.max(maxRowArea, h * w) ;
            }
            //存储下标用于计算面积
            stack.push(i);
        }
        //处理剩下的元素
        while(!stack.isEmpty()){
            //取出下标
            int h = heights[stack.pop()];
            int left = stack.isEmpty() ? -1 : stack.peek();
            int w = n - left - 1;
            maxRowArea = Math.max(maxRowArea, h * w) ;
        }
        return maxRowArea;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        char[][] matrix = new char[row][col];
        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                matrix[i][j] = sc.next().charAt(0);
            }
        }
        maximalRectangle maximalRectangle = new maximalRectangle();
        System.out.println(maximalRectangle.maximalRectangle(matrix));
    }
}
