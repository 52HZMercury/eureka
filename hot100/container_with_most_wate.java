package hot100;

import java.util.Scanner;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2024-10-19 15:47
 **/
public class container_with_most_wate {
    public static int maxArea(int[] height) {
        //短板向内进行收缩
        int waterMax = -1,left = 0,right = height.length - 1;
        while(left!=right){
            waterMax = height[left] > height[right] ?
                    Math.max(waterMax,(right-left) * height[right--]):
                    Math.max(waterMax,(right-left) * height[left++]);
        }
        return waterMax;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //输入容器长度
        int len = scanner.nextInt();
        int[] height = new int[len];
        for(int i = 0;i < len;i++){
            //输入全部容器的高度
            height[i] = scanner.nextInt();
        }
        System.out.println(maxArea(height));
    }
}
