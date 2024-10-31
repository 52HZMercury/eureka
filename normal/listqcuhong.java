package normal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2023-03-06 15:11
 **/
public class listqcuhong {
    public static void main(String[] args) {

    }
    private static List<people> quchong(List<people> data){
        Map<String,people> map = new HashMap<>();
        ArrayList<people> res = new ArrayList<>();
        for(people p: data){
            map.put(p.getName(),p);
        }
        for(people p : map.values()){
            res.add(p);
        }
        return res;
    }


}

class people {
        String name;
        String time;
        String location;
        boolean res;

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public boolean getRes() {
        return res;
    }

}
