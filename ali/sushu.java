package ali;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2023-04-24 19:19
 **/

public class sushu{
    public static void main(String[] args){

        int count = 0;
        for(int i = 101;i <= 200; i++){
            boolean su = true;
            for(int j = 2; j < i ; j++){
                if(i % j == 0){
                    su = false;
                    break;
                }
            }
            if(su){
                System.out.print(i + " ");
                count++;
            }
        }
        System.out.println(count);
    }
}
