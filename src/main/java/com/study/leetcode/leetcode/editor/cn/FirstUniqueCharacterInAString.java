package com.study.leetcode.leetcode.editor.cn;
//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。 
//
// 
//
// 示例： 
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
// 
//
// 
//
// 提示：你可以假定该字符串只包含小写字母。 
// Related Topics 哈希表 字符串 
// 👍 341 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstUniqueCharacterInAString {

    public static void main(String[] args) {
        Solution solution = new FirstUniqueCharacterInAString().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstUniqChar(String s) {
            char[] chars = s.toCharArray();
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < chars.length; i++) {
                Integer number = map.getOrDefault(chars[i], 0);
                map.put(chars[i], ++number);
            }

            for (int i = 0; i < chars.length; i++) {
                if (1 == map.get(chars[i])) {
                    return i;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


