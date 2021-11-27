package com.study.leetcode.leetcode.editor.cn;
//给定一个字符串，请将字符串里的字符按照出现的频率降序排列。 
//
// 示例 1: 
//
// 
//输入:
//"tree"
//
//输出:
//"eert"
//
//解释:
//'e'出现两次，'r'和't'都只出现一次。
//因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
// 
//
// 示例 2: 
//
// 
//输入:
//"cccaaa"
//
//输出:
//"cccaaa"
//
//解释:
//'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
//注意"cacaca"是不正确的，因为相同的字母必须放在一起。
// 
//
// 示例 3: 
//
// 
//输入:
//"Aabb"
//
//输出:
//"bbAa"
//
//解释:
//此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
//注意'A'和'a'被认为是两种不同的字符。
// 
// Related Topics 哈希表 字符串 桶排序 计数 排序 堆（优先队列） 👍 350 👎 0


import java.util.*;

public class SortCharactersByFrequency {

    public static void main(String[] args) {
        Solution solution = new SortCharactersByFrequency().new Solution();
        System.out.println(solution.frequencySort("cccaaa"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String frequencySort(String s) {
            char[] array = s.toCharArray();
            Map<Character, Integer> map = new HashMap<>();
            for (char c : array) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            List<Character>[] listArrays=new List[s.length()+1];
            map.forEach((key,value)->{
                List<Character>  innerList = listArrays[value];
                if (innerList==null){
                    innerList=new ArrayList<>();
                    innerList.add(key);
                    listArrays[value]=innerList;
                }else {
                    innerList.add(key);
                }
            });
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = listArrays.length - 1; i >= 0; i--) {
                List<Character> list = listArrays[i];
                if (list!=null){

                        for (Character character : list) {
                            for (int j = 0; j < i; j++) {
                                stringBuffer.append(character);
                            }
                        }

                }
            }
            return stringBuffer.toString();
        }

        public String frequencySort1(String s) {
            char[] array = s.toCharArray();
            Map<Character, Integer> map = new HashMap<>();
            for (char c : array) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<Map.Entry<Character, Integer>>((m1, m2) -> {
                return m2.getValue() - m1.getValue();
            });
            for (Map.Entry<Character, Integer> m : map.entrySet()) {
                queue.add(m);
            }
            char[] result = new char[s.length()];
            int index = 0;
            for (int i = 0; i < map.size(); i++) {
                Map.Entry<Character, Integer> entry = queue.poll();
                Integer value = entry.getValue();
                Character key = entry.getKey();
                for (Integer j = 0; j < value; j++) {
                    result[index++] = key;
                }
            }
            return new String(result);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


