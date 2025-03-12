package hot100;

import java.util.Scanner;
import java.util.Stack;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2025-03-12 18:53
 **/
public class largestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int n = heights.length;
        Stack<Integer> stack  = new Stack<>();
        for(int i = 0;i < n;i++){
            while(! stack.isEmpty() && heights[i] < heights[stack.peek()]){
                int height = heights[stack.pop()];
                int left = stack.isEmpty() ? -1 : stack.peek();
                int width = i - left - 1;
                maxArea = Math.max(width * height,maxArea);
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            int height = heights[stack.pop()];
            int left = stack.isEmpty() ? -1 : stack.peek();
            int width = n - left - 1;
            maxArea = Math.max(width * height,maxArea);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] heights = new int[n];
        for(int i = 0;i < heights.length;i++){
            heights[i] = sc.nextInt();
        }
        largestRectangleArea soltion = new largestRectangleArea();
        System.out.println(soltion.largestRectangleArea(heights));
    }
}
