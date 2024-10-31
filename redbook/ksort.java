package redbook;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2023-03-26 17:20
 **/
public class ksort {
    public static int kSort(int[] nums,int k){
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, Collections.reverseOrder());
        int res  = 0;
        for(int i = 0;i < nums.length;i++) {
            if (i >= k) {
                heap.offer(nums[i - k]);
            }
            if (!heap.isEmpty() && heap.peek() > nums[i]) {
                heap.offer(nums[i]);
                nums[i] = heap.poll();
                res++;
            }
        }
        while (!heap.isEmpty()){
            nums[nums.length - heap.size()] = heap.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i = 0; i<t;i++){
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] nums = new int[n];
            for(int j = 0;j<n;j++){
                nums[j] = scanner.nextInt();
            }
            int res = kSort(nums,k);
            System.out.println(res);
        }
    }
}
