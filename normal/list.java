package normal;

import java.util.*;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2023-03-14 19:33
 **/
public class list {
    public static void main(String[] args) {

        Integer[] nums = new Integer[]{1,6,4,1,7,4,3};
        Integer[] nums2 = new Integer[]{3,6,1,9,8,2,6,3,6};

        List<Integer> list1 = Arrays.asList(nums);
        List<Integer> list2 = Arrays.asList(nums2);


        Set<Integer> res2 = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        Set<Integer> res = new TreeSet<>((o1, o2) -> {return o2 - o1;});

        for(Integer i: list1){
            res.add(i);
        }

        for(Integer i: list2){
            res.add(i);
        }

        for(Integer i : res){
            System.out.println(i);
        }


//
//        ArrayList<Integer> normal.list = new ArrayList<>();
//
//        ArrayList<Integer> list2 = new ArrayList<>();
//
//        for(int i = 0;i < nums.length;i++){
//            normal.list.add(nums[i]);
//        }
//
//        for(int i = 0;i < nums2.length;i++){
//            list2.add(nums2[i]);
//        }
//        //normal.list = nums.toArray();
//        Map<Integer,Integer> map = new HashMap<>();
//        for(Integer i :normal.list){
//            map.put(i,i);
//        }
//
//        for(Integer i: list2){
//            map.put(i,i);
//        }
//
//        ArrayList<Integer> list3 = new ArrayList<>();
//        for(Integer i:map.keySet()){
//            list3.add(i);
//            //System.out.println(i);
//        }
//
//        for(int i = list3.size()-1;i>0;i--){
//            System.out.println(list3.get(i));
//        }
    }
}
