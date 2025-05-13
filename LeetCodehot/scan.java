package LeetCodehot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2024-10-18 15:43
 **/
public class scan {
    public static void main(String[] args) {
        //输入部分
        Scanner scanner = new Scanner(System.in);

        // 输入一个元素 处理一个
        ArrayList<Integer> list = new ArrayList<>();
        int index = 0;
        while(scanner.hasNextInt()){
            int input = scanner.nextInt();
            list.add(input);
            System.out.print(list.get(index++));
        }
        // 字符串版
        while(scanner.hasNext())
        {
            String string  = scanner.nextLine();
            char [] inputs  = string.toCharArray();
            System.out.println(Arrays.toString(inputs));
        }


        // 输入一行列表的数据  需要加上结束符号
        ArrayList<Integer> list2 = new ArrayList<>();
        System.out.println("开始输入第一个列表的元素，输入'end'结束:");
        while (true) {
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                list2.add(value);
            } else {
                scanner.next(); // 消耗掉非整数的输入
                break;
            }
        }
        System.out.println("输入结束.");
        System.out.println(Arrays.toString(list2.toArray()));


        // 输入字符串转为数组
        ArrayList<Integer> list3 = new ArrayList<>();

        String input1 = scanner.nextLine();
        String[] elements = input1.split("\\s+");
        for (String element : elements) {
            list3.add(Integer.parseInt(element));
        }
        System.out.println(Arrays.toString(list3.toArray()));

        scanner.close();

    }
}
