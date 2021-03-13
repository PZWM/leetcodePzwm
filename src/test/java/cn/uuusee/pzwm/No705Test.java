package cn.uuusee.pzwm;

import org.testng.annotations.Test;

public class No705Test {

    @Test
    public void test(){
        No705.No705A.MyHashSet myHashSet=new No705.No705A.MyHashSet();
        myHashSet.add(1);
        myHashSet.add(1);
        myHashSet.remove(1);
        System.out.println(myHashSet.contains(1));
    }
}
