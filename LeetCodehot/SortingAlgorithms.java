package LeetCodehot;

import java.util.*;
/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2025-04-02 13:31
 **/

public class SortingAlgorithms {

    // 1. 冒泡排序
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    // 交换相邻元素
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            // 如果没有交换则提前结束
            if (!swapped) break;
        }
    }

    // 2. 选择排序
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // 将最小值交换到当前位置
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    // 3. 插入排序
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i-1;
            // 将大于key的元素后移
            while (j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

    // 4. 希尔排序
    public static void shellSort(int[] arr) {
        int n = arr.length;
        // 使用希尔增量序列
        for (int gap = n/2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }

    // 5. 归并排序
    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length-1);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left)/2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid+1, k = 0;

        while (i <= mid && j <= right) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        //拷贝剩余的元素
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        System.arraycopy(temp, 0, arr, left, temp.length);
    }

    // 6. 快速排序
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length-1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // 选择最后一个元素为基准
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, high);
        return i+1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 7. 堆排序
    public static void heapSort(int[] arr) {
        int n = arr.length;
        // 构建最大堆
        for (int i = n/2 -1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        // 逐个提取元素
        for (int i = n-1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        if (left < n && arr[left] > arr[largest]) largest = left;
        if (right < n && arr[right] > arr[largest]) largest = right;

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    // 8. 计数排序（适用于非负整数）
    public static void countingSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int[] count = new int[max+1];

        for (int num : arr) count[num]++;

        int index = 0;
        for (int i = 0; i <= max; i++) {
            while (count[i]-- > 0) {
                arr[index++] = i;
            }
        }
    }

    // 9. 桶排序（假设输入在[0,1)范围内）
    public static void bucketSort(int[] arr) {
        int n = arr.length;

        // 归一化数组元素到 [0, 1) 范围
        int max = Arrays.stream(arr).max().getAsInt();
        double[] normalizedArr = new double[n];
        for (int i = 0; i < n; i++) {
            normalizedArr[i] = (double) arr[i] / (max + 1);
        }

        // 初始化桶
        ArrayList<Double>[] buckets = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // 将元素分配到桶中
        for (double num : normalizedArr) {
            int bucketIndex = (int)(num * n);
            buckets[bucketIndex].add(num);
        }

        // 对每个桶排序并合并回原数组
        int index = 0;
        for (ArrayList<Double> bucket : buckets) {
            Collections.sort(bucket);
            for (double num : bucket) {
                arr[index++] = (int) (num * (max + 1)); // 恢复原始值
            }
        }
    }


    // 10. 基数排序（LSD实现）
    public static void radixSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        for (int exp = 1; max/exp > 0; exp *= 10) {
            countingSortByDigit(arr, exp);
        }
    }

    private static void countingSortByDigit(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        for (int num : arr) count[(num/exp)%10]++;

        for (int i = 1; i < 10; i++) count[i] += count[i-1];

        for (int i = n-1; i >= 0; i--) {
            output[count[(arr[i]/exp)%10]-1] = arr[i];
            count[(arr[i]/exp)%10]--;
        }

        System.arraycopy(output, 0, arr, 0, n);
    }

    public static void main(String[] args) {
        // 测试示例
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("原数组: " + Arrays.toString(arr));

        // 调用不同的排序方法测试
//        bubbleSort(arr);
//        selectionSort(arr);
//        insertionSort(arr);
//        shellSort(arr);
//        mergeSort(arr);
//        quickSort(arr);
//        heapSort(arr);
//        countingSort(arr);
        bucketSort(arr);
//        radixSort(arr);
        System.out.println("桶排序后: " + Arrays.toString(arr));
    }
}

