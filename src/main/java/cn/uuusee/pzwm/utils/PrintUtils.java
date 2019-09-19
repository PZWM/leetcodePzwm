package cn.uuusee.pzwm.utils;

import java.util.List;

public class PrintUtils {
    public static void printList(List list){
        boolean first=true;
        for(Object o:list) {
            if(first){
                System.out.println("");
                first=false;
            }else{
                System.out.print(",");
            }
            System.out.print(o);
        }
    }
}
