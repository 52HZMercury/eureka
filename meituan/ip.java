package meituan;

import java.util.Scanner;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2023-08-26 10:56
 **/
public class ip {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ip = sc.nextLine();
        if(!isValid(ip)){
            System.out.println("invalid");
            return;
        }
        System.out.printf(getType(ip));
    }

    public static boolean isValid(String ip){
        if(ip == null || ip.length() == 0 || ip.startsWith(".") || ip.endsWith(".")){
            return false;
        }
        String[] parts = ip.split("\\.");
        if(parts.length != 4){
            return false;
        }
        for(String part : parts){
            if(part.length() == 0 || part.length() > 3){
                return false;
            }
            if(part.startsWith("0") && part.length() > 1){
                return false;
            }
            try{
                int num = Integer.parseInt(part);
                if(num < 0 || num > 255){
                    return false;
                }
            } catch (NumberFormatException e){
                return false;
            }
        }
        return true;
    }

    public static String getType(String ip){
        String[] parts = ip.split("\\.");
        int first = Integer.parseInt(parts[0]);
        if(first >= 1 && first <= 126){
            return "A_address";
        }else if(first >= 128 && first <= 191){
            return "B_address";
        } else if (first >= 192 && first <= 223) {
            return "C_address";
        } else if (first >= 224 && first <= 239) {
            return "D_address";
        } else if (first >= 240 && first <= 255) {
            return "E_address";
        } else {
            return "other";
        }
    }
}
