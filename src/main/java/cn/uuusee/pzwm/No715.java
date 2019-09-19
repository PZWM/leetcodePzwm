package cn.uuusee.pzwm;

import cn.uuusee.pzwm.utils.PrintUtils;
import com.alibaba.fastjson.JSON;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class No715 {
    /*
    * Range 模块是跟踪数字范围的模块。你的任务是以一种有效的方式设计和实现以下接口。

addRange(int left, int right) 添加半开区间 [left, right)，跟踪该区间中的每个实数。添加与当前跟踪的数字部分重叠的区间时，应当添加在区间 [left, right) 中尚未跟踪的任何数字到该区间中。
queryRange(int left, int right) 只有在当前正在跟踪区间 [left, right) 中的每一个实数时，才返回 true。
removeRange(int left, int right) 停止跟踪区间 [left, right) 中当前正在跟踪的每个实数。
 

示例：

addRange(10, 20): null
removeRange(14, 16): null
queryRange(10, 14): true （区间 [10, 14) 中的每个数都正在被跟踪）
queryRange(13, 15): false （未跟踪区间 [13, 15) 中像 14, 14.03, 14.17 这样的数字）
queryRange(16, 17): true （尽管执行了删除操作，区间 [16, 17) 中的数字 16 仍然会被跟踪）
 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/range-module
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    * */


    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        Class clazz = RangeModule.class;
        Object in = clazz.newInstance();
        StringBuilder a = new StringBuilder();
        a.append("[\"RangeModule\",\"queryRange\",\"queryRange\",\"addRange\",\"addRange\",\"queryRange\",\"queryRange\",\"queryRange\",\"removeRange\",\"addRange\",\"removeRange\",\"addRange\",\"removeRange\",\"removeRange\",\"queryRange\",\"queryRange\",\"queryRange\",\"queryRange\",\"removeRange\",\"addRange\",\"removeRange\",\"queryRange\",\"addRange\",\"addRange\",\"removeRange\",\"queryRange\",\"removeRange\",\"removeRange\",\"removeRange\",\"addRange\",\"removeRange\",\"addRange\",\"queryRange\",\"queryRange\",\"queryRange\",\"queryRange\",\"queryRange\",\"addRange\",\"removeRange\",\"addRange\",\"addRange\",\"addRange\",\"queryRange\",\"removeRange\",\"addRange\",\"queryRange\",\"addRange\",\"queryRange\",\"removeRange\",\"removeRange\",\"addRange\",\"addRange\",\"queryRange\",\"queryRange\",\"addRange\",\"addRange\",\"removeRange\",\"removeRange\",\"removeRange\",\"queryRange\",\"removeRange\",\"removeRange\",\"addRange\",\"queryRange\",\"removeRange\",\"addRange\",\"addRange\",\"queryRange\",\"removeRange\",\"queryRange\",\"addRange\",\"addRange\",\"addRange\",\"addRange\",\"addRange\",\"removeRange\",\"removeRange\",\"addRange\",\"queryRange\",\"queryRange\",\"removeRange\",\"removeRange\",\"removeRange\",\"addRange\",\"queryRange\",\"removeRange\",\"queryRange\",\"addRange\",\"removeRange\",\"removeRange\",\"queryRange\"]\n");
        StringBuilder b = new StringBuilder();
        b.append("[[],[21,34],[27,87],[44,53],[69,89],[23,26],[80,84],[11,12],[86,91],[87,94],[34,52],[1,59],[62,96],[34,83],[11,59],[59,79],[1,13],[21,23],[9,61],[17,21],[4,8],[19,25],[71,98],[23,94],[58,95],[12,78],[46,47],[50,70],[84,91],[51,63],[26,64],[38,87],[41,84],[19,21],[18,56],[23,39],[29,95],[79,100],[76,82],[37,55],[30,97],[1,36],[18,96],[45,86],[74,92],[27,78],[31,35],[87,91],[37,84],[26,57],[65,87],[76,91],[37,77],[18,66],[22,97],[2,91],[82,98],[41,46],[6,78],[44,80],[90,94],[37,88],[75,90],[23,37],[18,80],[92,93],[3,80],[68,86],[68,92],[52,91],[43,53],[36,37],[60,74],[4,9],[44,80],[85,93],[56,83],[9,26],[59,64],[16,66],[29,36],[51,96],[56,80],[13,87],[42,72],[6,56],[24,53],[43,71],[36,83],[15,45],[10,48]]");
        List<String> arr = JSON.parseArray(a.toString(), String.class);
        List<Integer[]> brr = JSON.parseArray(b.toString(), Integer[].class);

        for (int i = 0; i < arr.size(); i++) {
            Integer[] integers = brr.get(i);
            if (integers.length < 1) {
                continue;
            }
            Method method = clazz.getDeclaredMethod(arr.get(i), int.class, int.class);
            method.invoke(in, integers[0], integers[1]);

        }

    }
}

class RangeModule {

    List<Integer> list = new ArrayList<>();

    public RangeModule() {

    }

    public void addRange(int left, int right) {
//        PrintUtils.printList(list);
        int size = list.size();
        if (size == 0) {
            list.add(left);
            list.add(right);
            return;
        }
        int c = 0;
        while (list.get(c) < left) {
            c++;
            if (c >= size) {
                list.add(left);
                list.add(right);
                return;
            }
        }
        if (c % 2 == 0) {
            //start
            int start = list.get(c);
            if (start > right) {
                list.add(c, right);
                list.add(c, left);
                return;
            } else if (start == right) {
                list.set(c, left);
            } else {
                int oc = c;
                while (oc < size && list.get(oc) < right) {
                    oc++;
                }
                if (oc % 2 == 0) {
                    if(oc<size&&list.get(oc)==right){
                        for (int i = 0; i < oc - c; i++) {
                            list.remove(c);
                        }
                        list.set(c,left);
                        return;
                    }
                    //那么将中间清除直接替换成这个left+right
                    for (int i = 0; i < oc - c; i++) {
                        list.remove(c);
                    }
                    list.add(c, right);
                    list.add(c, left);
                    return;
                } else {
                    for (int i = 0; i < oc - c; i++) {
                        list.remove(c);
                    }
                    list.add(c, left);
                    return;
                }
            }
        } else {
            //end
            int end = list.get(c);
            if (end >= right) {
                return;
            } else {
                int oc = c;
                while (oc < size && list.get(oc) < right) {
                    oc++;
                }
                if (oc % 2 == 0) {
                    //那么将中间清除直接替换成这个left+right
                    if(oc<size&&list.get(oc)==right){
                        for (int i = 0; i < oc - c+1; i++) {
                            list.remove(c);
                        }
                        return;
                    }
                    for (int i = 0; i < oc - c; i++) {
                        list.remove(c);
                    }
                    list.add(c, right);
                    return;
                } else {
                    for (int i = 0; i < oc - c; i++) {
                        list.remove(c);
                    }
                    return;
                }
            }
        }
    }

    public boolean queryRange(int left, int right) {
        int size = list.size();
        if (size == 0) {
            return false;
        }

        int c = 0;
        while (list.get(c) < left) {
            c++;
            if (c >= size) {
                return false;
            }
        }
        if (c % 2 == 0 ) {
            if(list.get(c)!=left) {
                return false;
            }else{
                return right <= list.get(c+1);
            }
        } else {
            return right <= list.get(c);
        }
    }

    public void removeRange(int left, int right) {
//        PrintUtils.printList(list);
        int size = list.size();
        if (size == 0) {
            return;
        }
        int c = 0;
        while (list.get(c) < left) {
            c++;
            if (c >= size) {
                return;
            }
        }
        if (c % 2 == 0) {
            //start
            int start = list.get(c);
            if (start >= right) {
                return;
            }
            int oc = c;
            while (oc < size && list.get(oc) < right) {
                oc++;
            }
            if (oc % 2 == 0) {
                //那么将中间清除直接替换成这个left+right
                for (int i = 0; i < oc - c; i++) {
                    list.remove(c);
                }
            } else {
                for (int i = 0; i < oc - c; i++) {
                    list.remove(c);
                }
                list.add(c, right);
            }
        } else {
            //end 如果是end，直接替换c位置为现在left
            int end = list.get(c);

            if (end > right) {
                list.add(c, right);
                list.add(c, left);
                return;
            }else if(end==right){
                list.set(c,left);
                return;
            }
            int oc = c;
            while (oc < size && list.get(oc) < right) {
                oc++;
            }
            if (oc % 2 == 0) {
                //那么将中间清除直接替换成这个left+right
                for (int i = 0; i < oc - c; i++) {
                    list.remove(c);
                }
                list.add(c, left);
            } else {
                for (int i = 0; i < oc - c; i++) {
                    list.remove(c);
                }
                list.add(c, right);
                list.add(c, left);
            }
        }
    }
}
/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */