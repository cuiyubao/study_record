package com.study.leetcode.leetcode.editor.cn;
//字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。 
//
// 
//
// 示例： 
//
// 
//输入：S = "ababcbacadefegdehijhklij"
//输出：[9,7,8]
//解释：
//划分结果为 "ababcbaca", "defegde", "hijhklij"。
//每个字母最多出现在一个片段中。
//像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
// 
//
// 
//
// 提示： 
//
// 
// S的长度在[1, 500]之间。 
// S只包含小写字母 'a' 到 'z' 。 
// 
// Related Topics 贪心 哈希表 双指针 字符串 👍 615 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PartitionLabels {

    public static void main(String[] args) {
        Solution solution=new PartitionLabels().new Solution();
        System.out.println(solution.partitionLabels("ababcbacadefegdehijhklij"));
    }
 
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        //当前串最远距离
        int nowMaxPosition=0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            map.put(charArray[i],i);
        }
        //子字符串长度
        int addSize=0;
        for (int i = 0; i < charArray.length; i++) {
            //当前字符最远距离
            Integer nowCharPosition = map.get(charArray[i]);
            nowMaxPosition=Math.max(nowMaxPosition,nowCharPosition);
            addSize++;
            if (i==nowMaxPosition){
                 list.add(addSize);
                 addSize=0;
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}


