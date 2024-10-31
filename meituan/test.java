package meituan;
import java.util.*;
/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2023-08-19 21:01
 **/
public class test {


    // 注意类名必须为 Main, 不要有任何 package xxx 信息

        static class Merchant{
            String name;
            String address;
            boolean isMain;
            int branchCount;

            public Merchant (String name,String address){
                this.name  = name;
                this.address = address;
                this.isMain = false;
                this.branchCount = 0;
            }

            @Override
            public boolean equals(Object obj){
                if(obj instanceof Merchant){
                    Merchant other  = (Merchant) obj;
                    return this.name.equals(other.name) && this.address.equals(other.address);
                }
                return false;
            }

            @Override
            public int hashCode(){
                return   Objects.hash(name,address);

            }

            @Override
            public String toString(){
                return name + " "+ address + " " + branchCount;
            }
        }
        static HashMap<String,List<Merchant>> registeredMerchants = new HashMap<>();
        static boolean isVaildInput(String name, String address){
            return name.matches("[a-z]+") && address.matches("[a-z]+");
        }
        static boolean registeredMerchant(String name,String address){
            if(!isVaildInput(name,address)){
                return false;
            }
            Merchant newMerchant = new Merchant(name,address);
            if(!registeredMerchants.containsKey(name)){
                newMerchant.isMain = true;
                List<Merchant> List = new ArrayList<>();
                List.add(newMerchant);
                registeredMerchants.put(name,List);
                return true;
            }
            List<Merchant> List = registeredMerchants.get(name);
            if(List.contains(newMerchant)){
                return false;
            }
            List.add(newMerchant);
            List.get(0).branchCount++;
            return true;
        }

        static void printAllMerchants(){
            List<Merchant> allMerchants = new ArrayList<>();
            for(Map.Entry<String,List<Merchant>> entry : registeredMerchants.entrySet()){
                allMerchants.addAll(entry.getValue());
            }
            Collections.sort(allMerchants,(m1,m2) -> m1.name.compareTo(m2.name));
            for(Merchant m : allMerchants){
                if(m.isMain){
                    System.out.println(m);
                }

            }
        }


        public static void main(String[] args) {


            Scanner in = new Scanner(System.in);
            // 注意 hasNext 和 hasNextLine 的区别
            int n = in.nextInt();
            String[] names = new String[n];
            String[] address = new String[n];
            for (int i = 0;i < n;i++) { // 注意 while 处理多个 case
                names[i] = in.next();
                address[i] = in.next();
            }
            for(int i = 0; i < n; i++){
                boolean res = registeredMerchant(names[i],address[i]);
            }
            printAllMerchants();
        }
}

