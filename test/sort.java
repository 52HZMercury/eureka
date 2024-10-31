package test;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2023-06-14 10:11
 **/
public class sort {
    public static void bubblesort(int[] arr){
        int n = arr.length;
        for(int i = 0;i < n - 1;i++){
            for(int j = 0;j < n - i - 1;j++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j + 1];
                    arr[j + 1]= arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

}
