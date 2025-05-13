package LeetCodehot;

import java.util.*;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2024-12-13 15:58
 **/
public class merge {
    public static int[][] merge(int[][] intervals) {
        //lamba表达式 左端点的升序排序
        Arrays.sort(intervals,(o1, o2)->{return o1[0] - o2[0];});
        List<int[]> merged = new ArrayList<>();
        for(int i = 0;i < intervals.length;i++){
            int l = intervals[i][0],r = intervals[i][1];
            if(merged.size() == 0 || l > merged.get(merged.size() - 1)[1]){
                //加入最右端
                merged.add(intervals[i]);
            }else{
                //更新最右端
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1],r);
            }
        }
        //传入0也可以,toArray()会自动设置merged集合的长度
        //当T泛型的长度没有list的size大时，会以size长度返回T；否则，使用传入的T。所以使用时不管写0还是其它数字，都没关系，习惯写0。
        return merged.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //传入数组的数量
        int n = sc.nextInt();
        int[][] intervals = new int[n][2];
        for(int i = 0;i < n;i++){
            //传入数组的元素
            int l = sc.nextInt();
            int r = sc.nextInt();
            intervals[i][0] = l;
            intervals[i][1] = r;
        }

        int[][] res = merge(intervals);

        System.out.println(Arrays.deepToString(res));
    }
}
