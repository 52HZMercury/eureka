package normal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2023-03-06 15:26
 **/
public class listlianhe {
    public static void main(String[] args) {

    }

    private static List<c> test(List<a> alist,List<b> blist){
        ArrayList<c> c = new ArrayList<>();
        Map<Integer,c> map  = new HashMap<>();
        for (a a:alist){
            map.put(a.id,new c(a.getId(),a.getCode()));
        }
        for(b b : blist){
            map.get(b.id).setName(b.name);
        }
        return c;

    }
}

class a{
    int id;
    String code;

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }
}

class b{
    int id;
    String name;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
class c{
    int id;
    String code;
    String name;

    public void setName(String name) {
        this.name = name;
    }

    public c(int id, String code) {

    }
}

