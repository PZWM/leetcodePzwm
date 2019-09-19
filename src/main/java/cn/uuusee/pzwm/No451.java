package cn.uuusee.pzwm;

import java.util.*;

public class No451 {

    /*
    * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。

示例 1:

输入:
"tree"

输出:
"eert"

解释:
'e'出现两次，'r'和't'都只出现一次。
因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
示例 2:

输入:
"cccaaa"

输出:
"cccaaa"

解释:
'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
注意"cacaca"是不正确的，因为相同的字母必须放在一起。
示例 3:

输入:
"Aabb"

输出:
"bbAa"

解释:
此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
注意'A'和'a'被认为是两种不同的字符。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sort-characters-by-frequency
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    * */

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.frequencySort("tree"));

    }

}

class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new TreeMap<>();
        char[] chars = s.toCharArray();
        if(chars.length==0)
            return "";
        for (char c : chars) {
            if (map.get(c) == null) {
                map.put(c, 1);
                continue;
            }
            map.put(c, map.get(c) + 1);
        }

        map = sortMapByValue(map);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }

    public static Map<Character, Integer> sortMapByValue(Map<Character, Integer> oriMap) {

        if (oriMap == null || oriMap.isEmpty()) {

            return null;

        }

        Map<Character, Integer> sortedMap = new LinkedHashMap<>();

        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(

                oriMap.entrySet());

        entryList.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));

        Iterator<Map.Entry<Character, Integer>> iter = entryList.iterator();

        Map.Entry<Character, Integer> tmpEntry = null;

        while (iter.hasNext()) {

            tmpEntry = iter.next();

            sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());

        }

        return sortedMap;

    }
}